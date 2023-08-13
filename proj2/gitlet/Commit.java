package gitlet;


import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

/**
 * Represents a gitlet commit object.
 * A commit is a snapshot of the entire project at one point in time.
 */
public class Commit implements Serializable {
    private String message;
    private String author;
    private Date timestamp;
    private String parentID; // First commit will have this null
    private HashMap<String, String> trackedFiles = new HashMap<>();

    // For all commits except the initial commit
    public Commit(String message, String author, String parentID) {
        this.message = message;
        this.author = author;
        this.timestamp = new Date();
        this.parentID = parentID;
    }

    // For the initial commit
    public Commit(String message, String author, Date timestamp) {
        this.message = message;
        this.author = author;
        this.timestamp = timestamp;
        this.parentID = null;
    }

    public void save() {
        String sha1 = Utils.sha1((Object) Utils.serialize(this));
        File commitFile = Utils.join(Repository.COMMITS_DIR, sha1);
        Utils.writeObject(commitFile, this);
    }

    public static Commit fromFile(String sha1) {
        File commitFile = Utils.join(Repository.COMMITS_DIR, sha1);
        return Utils.readObject(commitFile, Commit.class);
    }

    /**
     * Add a new file to the commit (filename -> sha1 of blob)
     */
    public void addFile(String filename, String sha1) {
        trackedFiles.put(filename, sha1);
    }

    public Commit getParent() {
        if (parentID == null) {
            return null;
        }
        return Commit.fromFile(parentID);
    }


    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setTrackedFiles(HashMap<String, String> trackedFiles) {
        this.trackedFiles = trackedFiles;
    }

    public String getSHA1() {
        return Utils.sha1((Object) Utils.serialize(this));
    }

    @Override
    public String toString() {
        return "Commit{" +
                "message='" + message + '\'' +
                ", author='" + author + '\'' +
                ", timestamp=" + timestamp +
                ", parentID='" + parentID + '\'' +
                ", trackedFiles=" + trackedFiles +
                '}';
    }
}
