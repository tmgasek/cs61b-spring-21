package gitlet;

/**
 * Driver class for Gitlet, a subset of the Git version-control system.
 *
 * @author TODO
 */
public class Main {

    /**
     * Usage: java gitlet.Main ARGS, where ARGS contains
     * <COMMAND> <OPERAND1> <OPERAND2> ...
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Args can't be empty!");
        }

        Repository repo = new Repository();
        String firstArg = args[0];
        switch (firstArg) {
            case "init":

                repo.init();
                break;
            case "add":
                if (args.length != 2) {
                    throw new IllegalArgumentException("Incorrect operands.");
                }

                String filename = args[1];
                System.out.println("Adding " + filename + " to staging area.");
                Repository.add(filename);

                break;
            case "commit":
                if (args.length != 2) {
                    throw new IllegalArgumentException("Incorrect operands.");
                }

                String message = args[1];
                System.out.println("Committing with message: " + message);
                Repository.commit(message);

                // Get the current HEAD - Head file has SHA string
                String headSHA = Utils.readContentsAsString(Repository.HEAD_FILE);
                System.out.println("HEAD is now at " + headSHA);

                String stagingContent = Utils.readContentsAsString(Repository.STAGING_FILE);
                System.out.println("Staging area is now empty: " + stagingContent.equals(""));

                // Get the current commit
                Commit currentCommit = Commit.fromFile(headSHA);
                System.out.println("Current commit is " + currentCommit.getSHA1());

                // Get parent of current commit
                Commit parent = Commit.fromFile(currentCommit.getParent().getSHA1());
                System.out.println("Parent of current commit is " + parent.getSHA1());

                break;
        }
    }
}
