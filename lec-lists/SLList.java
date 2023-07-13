// An SLList is a list of integers that hides stuff o.o
public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    // Creates an empty SLList
    public SLList() {
        sentinel = new IntNode(-1, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(-1, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /**
     * Adds an item to the front of the list.
     */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /**
     * Returns first item in the list.
     */
    public int getFirst() {
        return sentinel.next.item;
    }

    public void printList() {
        IntNode p = sentinel.next;
        while (p != null) {
            System.out.printf("%d -> ", p.item);
            p = p.next;
        }
        System.out.println("NULL");
    }

    public void addLast(int x) {
        // This is bad - exception to rule. Special cases are not good.

        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
        size++;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        // creates a list of one int (10)
        SLList L = new SLList();
        L.addLast(4);
        L.addFirst(3);
        L.addFirst(2);
        L.addLast(5);
        L.addFirst(1);

        L.printList();
        System.out.println("SIZE: " + L.size());


    }
}
