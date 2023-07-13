public class Sort {
    public static void sort(String[] x) {
        sort(x, 0);
    }

    /** Sorts x starting at pos start */
    private static void sort(String[] x, int start) {
        // base case
        if (start == x.length) {
            return;
        }

        int smallestIdx = findSmallest(x, start);
        swap(x, start, smallestIdx);
        sort(x, start + 1);
    }

    /** Return the index of smallest String in String[] x, starting at start. */
    public static int findSmallest(String[] x, int start) {
        int smallestIdx = start;
        for (int i = start; i < x.length; i += 1) {
            int cmp = x[i].compareTo(x[smallestIdx]);
            if (cmp < 0) {
                smallestIdx = i;
            }
        }
        return smallestIdx;
    }


    /** Swap item a with b. */
    public static void swap(String[] x, int a, int b) {
        String tmp = x[a];
        x[a] = x[b];
        x[b] = tmp;

    }

    public static void main(String[] args) {

    }
}
