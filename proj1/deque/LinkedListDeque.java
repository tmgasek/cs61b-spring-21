package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T>{
    private final Node head;
    private final Node tail;
    private int size;

    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private class LinkedListDequeIterator<T> implements Iterator<T> {
        private Node curr;

        public LinkedListDequeIterator(Node first) {
            curr = first;
        }

        public boolean hasNext() {
            return curr != tail;
        }

        public T next() {
            T returnItem = (T) curr.item;
            curr = curr.next;
            return returnItem;
        }
    }

    public LinkedListDequeIterator<T> iterator() {
        return new LinkedListDequeIterator<>(head.next);
    }

    // Create an empty LLDeque
    public LinkedListDeque() {
        head = new Node(null, null, null);
        tail = new Node(null, null, null);
        head.next = tail;
        tail.prev = head;
    }

    // Adds an item to the front of the deque. Item never null
    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item, head, head.next);
        // Update the previous first node's prev to be this node
        head.next.prev = newNode;
        // Set this node to be first after head sentinel
        head.next = newNode;
        size++;
    }

    // Adds an item to the back of the deque. Item never null
    @Override
    public void addLast(T item) {
        Node newNode = new Node(item, tail.prev, tail);
        // Update the previous last node's next to be this node
        tail.prev.next = newNode;
        // Set this node to be the last before the tail sentinel
        tail.prev = newNode;
        size++;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node p = head.next;
        System.out.print("[HEAD] -> ");
        while (p != tail) {
            System.out.print(p.item + " -> ");
            p = p.next;
        }
        System.out.print("[TAIL]");
        System.out.println();
    }

    // Removes and returns item at front of the deque. If no item, return null
    @Override
    public T removeFirst() {
        Node first = head.next;
        if (first == tail) {
            // empty list
            return null;
        }
        Node second = first.next;
        // second's prev needs to point to head
        second.prev = head;
        // head next needs to point to second
        head.next = second;
        size--;
        return first.item;
    }

    // Removes and returns item at back of the deque. If no item, return null
    @Override
    public T removeLast() {
        Node last = tail.prev;
        if (last == head) {
            // empty list
            return null;
        }
        Node secondLast = last.prev;
        // second last needs to now point to tail
        secondLast.next = tail;
        // tail prev needs to point to second last
        tail.prev = secondLast;
        size--;
        return last.item;
    }

    // Gets item at given index, where 0 is front, 1 is next item ...
    // If no item, return null. Must not alter the deque.

    @Override
    public T get(int idx) {
        Node p = head.next;
        int curr = 0;
        while (p != tail) {
            if (curr == idx) {
                return p.item;
            }
            curr++;

            p = p.next;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof LinkedListDeque)) {
            return false;
        }
        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
        if (other.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (!other.get(i).equals(this.get(i))) {
                return false;
            }
        }
        return true;
    }

    private T getRecursiveHelper(int idx, Node p) {
        if (p == tail) {
            return null;
        }
        if (idx == 0) {
            return p.item;
        }
        return getRecursiveHelper(idx - 1, p.next);
    }

    public T getRecursive(int idx) {
        return getRecursiveHelper(idx, head.next);
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();


        // test iterator
        lld1.addFirst(1);
        hello my name is
        lld1.addFirst(2);
        lld1.addFirst(3);

        for (int i : lld1) {
            System.out.println(i);
        }

    }


}
