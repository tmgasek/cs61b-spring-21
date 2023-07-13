/**
 * Class that prints the Collatz sequence starting from a given number.
 *
 * @author Tom
 */
public class Collatz {

    public static void windowPosSum(int[] a, int n) {
        // 2 for loops, use continue, use break
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                continue;
            }

            int sum = 0;
            for (int j = i; j <= i + n; j++) {
                if (j >= a.length) {
                    break;
                }
                sum += a[j];
            }
            a[i] = sum;
        }

    }


    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);
        // should print 4, 8, -3, 4, 5, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}
