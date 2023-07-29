public class SLList<T> implements List61B<T> {
    public class Node {
        public T item;
        public Node next;

        public Node(T i, Node h) {
            item = i;
            next = h;
        }
    }

    private Node sentinel;
    private int size;

    public SLList() {
        size = 0;
        sentinel = new Node(null, null);
    }

    public SLList(T x) {
        size = 1;
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
    }

    // add item in front
    public void addFirst(T x) {
        Node oldFrontNode = sentinel.next;
        Node newNode = new Node(x, oldFrontNode);
        sentinel.next = newNode;
        size++;
    }

    // get front item
    public T getFirst() {
        return sentinel.next.item;
    }

    // puts item at back of list
    public void addLast(T x) {
        size++;
        Node p = sentinel;

        // move p until reaches end
        while (p.next !=null) {
            p = p.next;
        }

        p.next = new Node(x, null);
    }

    public Node getLastNode() {
        Node p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public T getLast() {
        Node back = getLastNode();
        return back.item;
    }

    public T removeLast() {
        // get last node
        Node back = getLastNode();
        if (back == sentinel) {
            return null;
        }

        size--;
        Node p = sentinel;
        while (p.next != back) {
            p = p.next;
        }

        p.next = null;
        return back.item;
    }

    public int size() {
        return size;
    }

    public T get(int position) {
        if (position == 0) {
            return getFirst();
        }

        Node curr = sentinel.next.next;
        while (position > 1 && curr.next !=null) {
            position--;
            curr = curr.next;
        }

        return curr.item;
    }

    // insert into given pos
    public void insert(T item, int pos) {
        if (sentinel.next == null || pos == 0) {
            addFirst(item);
            return;
        }

        Node curr = sentinel.next.next;
        while (pos > 1 && curr.next != null) {
            pos--;
            curr = curr.next;
        }

        Node newNode = new Node(item, curr.next);
        curr.next = newNode;
    }



























}
