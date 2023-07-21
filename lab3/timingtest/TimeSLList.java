package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    private static void timeN(AList<Integer> Ns, AList<Double> times, int N, AList<Integer> opCount) {
       Ns.addLast(N);
       SLList<Integer> SLL = new SLList<Integer>();
        for (int i = 0; i < N; i++) {
            SLL.addLast(i);
        }
        Stopwatch sw = new Stopwatch();
        // Perform M getLast operations on the SLList
        System.out.println("Getting last 1000 times for list size: " + N);
        for (int i = 0; i < 1000; i++) {
            SLL.getLast();
        }
        double timeInSeconds = sw.elapsedTime();
        times.addLast(timeInSeconds);
        opCount.addLast(1000);
    }

    public static void timeGetLast() {
        AList Ns = new AList<Integer>();
        AList times = new AList<Double>();
        AList opCount = new AList<Integer>();

        for (int i = 1000; i <= 128000; i *= 2) {

            timeN(Ns, times, i, opCount);
        }
        printTimingTable(Ns, times, opCount);

    }

}
