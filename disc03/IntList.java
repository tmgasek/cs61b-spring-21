public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    public static void evenOdd(IntList lst) {

    }

    public void print() {
        IntList p = rest;
        System.out.print(first + " -> ");
        while (p != null) {
            System.out.print(p.first + " -> ");
            p = p.rest;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        IntList L = new IntList(0, null);
        L = new IntList(3, L);
        L = new IntList(1, L);
        L = new IntList(4, L);

        L.print();

        System.out.println(L);

    }
}
