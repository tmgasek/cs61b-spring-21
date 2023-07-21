package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    private static void timeN(AList<Integer> Ns, AList<Double> times, int N) {
        Ns.addLast(N);
        AList L = new AList<Integer>();
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < N; i++) {
            L.addLast(1);
        }
        double timeInSeconds = sw.elapsedTime();
        times.addLast(timeInSeconds);

    }

    public static void timeAListConstruction() {
        AList Ns = new AList<Integer>();
        AList times = new AList<Double>();

        for (int i = 1000; i <= 128000; i *= 2) {
            timeN(Ns, times, i);
        }



        printTimingTable(Ns, times, Ns);


//        Ns.addLast(2000);
//        Ns.addLast(4000);
//        Ns.addLast(8000);
//        Ns.addLast(16000);
//        Ns.addLast(32000);
//        Ns.addLast(64000);
//        Ns.addLast(128000);

    }
}
