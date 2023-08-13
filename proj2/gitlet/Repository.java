package gitlet;

import java.io.File;
import java.util.Date;

import static gitlet.Utils.*;


public class Repository {
    public static final File CWD = new File(System.getProperty("user.dir"));
    public static final File GITLET_DIR = join(CWD, ".gitlet");
    public static final File STAGING_FILE = join(GITLET_DIR, "staging.txt");
    public static final File COMMITS_DIR = join(GITLET_DIR, "commits");
    public static final File BLOBS_DIR = join(GITLET_DIR, "blobs");
    public static final File HEAD_FILE = join(GITLET_DIR, "HEAD");
    static Commit HEAD;

    public void init() {
        // Create the .gitlet dir
        if (GITLET_DIR.exists()) {
            throw new RuntimeException("Repository already initialised. Exit");
        }

        if (!GITLET_DIR.mkdir()) {
            throw new RuntimeException("Failed to create .gitlet dir");
        }

        // Create the staging area
        if (!STAGING_FILE.exists()) {
            try {
                STAGING_FILE.createNewFile();
            } catch (Exception e) {
                throw new RuntimeException("Failed to create staging area");
            }
        }

        // Create the commits folder
        if (!COMMITS_DIR.exists()) {
            if (!COMMITS_DIR.mkdir()) {
                throw new RuntimeException("Failed to create commits folder");
            }
        }

        // Create the blobs folder
        if (!BLOBS_DIR.exists()) {
            if (!BLOBS_DIR.mkdir()) {
                throw new RuntimeException("Failed to create blobs folder");
            }
        }

        // Create the first commit - contains no files, no parent,
        // and has the commit message "initial commit"
        Date timestamp = new Date(0);
        Commit firstCommit = new Commit("initial commit", "System", timestamp);
        firstCommit.save();
        HEAD = firstCommit;
        // Create the HEAD file
        if (!HEAD_FILE.exists()) {
            try {
                HEAD_FILE.createNewFile();
            } catch (Exception e) {
                throw new RuntimeException("Failed to create HEAD file");
            }
        }

        // Write the SHA of the first commit to the HEAD file
        writeContents(HEAD_FILE, firstCommit.getSHA1());
    }

    // Add a file to staging area.
    public static void add(String filename) {
        // TODO:
        // Compare this SHA to the SHA of the file's contents in the current commit
        // If they are the same, remove the file from the staging area
        // And also remove it if it's already there.

        // Create SHA of the file's contents.
        byte[] fileContents = readContents(new File(filename));
        String sha = sha1((Object) fileContents);
        Blob blob = new Blob(filename, fileContents);

        // Write blob to blobs folder
        File blobFile = join(BLOBS_DIR, sha);
        Utils.writeContents(blobFile, (Object) fileContents);

        // Write to staging area file
        Utils.writeObject(STAGING_FILE, blob);
    }


    public static void commit(String message) {
        // Read in from filesystem the HEAD commit object and staging area file.
        Blob blob = Utils.readObject(STAGING_FILE, Blob.class);
        // Clone the HEAD commit.
        // Get the SHA in the HEAD file.
        String HEAD_SHA = Utils.readContentsAsString(HEAD_FILE);

        Commit HEAD_COMMIT = Commit.fromFile(HEAD_SHA);

        // Modify its msg and timestamp according to the user's input.
        Commit newCommit = new Commit(message, "Tom", HEAD_SHA);
        newCommit.setTimestamp(new Date());

        String blobSHA = sha1((Object) blob.getContent());
        // Use staging area to modify the files tracked by new commit.
        newCommit.addFile(blob.getFilename(), blobSHA);
        // Write back any new object made or modified objects read earlier.
        newCommit.save();

        // Clear staging area.
        STAGING_FILE.delete();
        try {
            STAGING_FILE.createNewFile();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create staging area");
        }

        // Write the SHA of the new commit to the HEAD file.
        Utils.writeContents(HEAD_FILE, newCommit.getSHA1());
    }

    public static void log() {
        // Read in SHA from HEAD file.
        String HEAD_SHA = Utils.readContentsAsString(HEAD_FILE);
        // Read in commit object from filesystem.
        Commit curr = Commit.fromFile(HEAD_SHA);
        // Loop over the commit objects, starting from the current one.
        System.out.println("--HEAD--");
        while (curr != null) {
            // Print out the commit object.
            System.out.println("--SHA: " + curr.getSHA1());
            System.out.println(curr);
            // Read in the parent commit object.
            curr = curr.getParent();
        }
    }
}














