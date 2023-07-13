public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (this.rest == null) {
            return 1;
        }

        return 1 + this.rest.size();
    }

    // returns ith item in this IntList
    public int get(int i) {
        if (i == 0) {
            return this.first;
        }
        return this.rest.get(i - 1);
    }

    public IntList getNode(int i) {
        if (i == 0) {
            return this;
        }
        return this.rest.getNode(i - 1);
    }

    /**
     * Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change.
     */
    public static IntList incrList(IntList L, int x) {
        int i = L.size() - 1;
        IntList newL = null;

        while (i >= 0) {
            int currVal = L.get(i) + x;
            newL = new IntList(currVal, newL);
            i--;
        }
        return newL;
    }

    /**
     * Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword.
     */
    public static IntList dincrList(IntList L, int x) {
        int i = L.size() - 1;
        while (i >= 0) {
            IntList curr = L.getNode(i);
            curr.first = curr.first + x;
            i--;
        }
        return L;
    }

    public static void printList(IntList L) {
        IntList p = L;
        while (p != null) {
            System.out.printf("%d -> ", p.first);
            p = p.rest;
        }
        System.out.println("NULL");
    }


    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);


//        System.out.println(L.get(1));
//        printList(incrList(L, 3));
//        printList(dincrList(L, 3));
    }
}
