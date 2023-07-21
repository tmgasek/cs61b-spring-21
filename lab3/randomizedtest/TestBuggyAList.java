package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class TestBuggyAList {

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // getLast
            } else if (operationNumber == 2) {
                // removeLast

            } else if (operationNumber == 3) {

            }
        }

    }


}