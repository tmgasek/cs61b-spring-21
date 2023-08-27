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
                break;
            case "log":
                if (args.length != 1) {
                    throw new IllegalArgumentException("Incorrect operands.");
                }
                Repository.log();
                break;
            case "checkout":
                if (args.length != 2) {
                    throw new IllegalArgumentException("Incorrect operands.");
                }

                String commitSHA = args[1];
                Repository.checkout(commitSHA);
        }
    }
}
