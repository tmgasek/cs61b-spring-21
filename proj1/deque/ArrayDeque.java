package deque;

import afu.org.checkerframework.checker.oigj.qual.O;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private void upSize(int capacity) {
        T[] newArr = (T[]) new Object[capacity];

        // insert the old array into new Array
        int currIdx = (nextFirst + 1) % items.length;
        for (int newIdx = 0; newIdx < size; newIdx++) {
            newArr[newIdx] = items[currIdx];
            currIdx = (currIdx + 1) % items.length;
        }

        items = newArr;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    private void downSize(int capacity) {
        T[] newArr = (T[]) new Object[capacity];

        int currIdx = (nextFirst + 1) % items.length;
        for (int newIdx = 0; newIdx < capacity; newIdx++) {
            newArr[newIdx] = items[currIdx];
            currIdx = (currIdx + 1) % items.length;
        }

        items = newArr;
        nextFirst = capacity - 1;
        nextLast = items.length - size;

    }

    private boolean shouldDownSize() {
        double ratio = ((double) size - 1) / (double) items.length;
        return ratio < 0.25 && items.length >= 16;
    }

    @Override
    public void addFirst(T item) {
        if (size >= items.length) {
            upSize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size >= items.length) {
            upSize(size * 2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1 + items.length) % items.length;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        System.out.print("IDX: \t");
        for (int i = 0; i < items.length; i++) {
            System.out.print(i + " \t");
        }
        System.out.println();
        System.out.print("ITEM: \t");
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                System.out.print("-" + " \t");
            } else {
                System.out.print(items[i] + " \t");
            }
        }
        System.out.printf("\n\nNEXT FIRST: %d \t NEXT LAST: %d\n", nextFirst, nextLast);
    }

    @Override
    public T removeFirst() {
        if (size <= 0) {
            return null;
        }
        if (shouldDownSize()) {
            downSize(items.length / 2);
        }

        // get index before nextFirst
        int currFirstIdx = (nextFirst + 1 + items.length) % items.length;
        // save item at that index
        T currFirstItem = items[currFirstIdx];
        // make the item at that index null (prevent loitering)
        items[currFirstIdx] = null;
        // set the nextFirst to the index before it
        nextFirst = currFirstIdx;
        // decrease size
        size--;
        return currFirstItem;
    }

    @Override
    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        if (shouldDownSize()) {
            downSize(items.length / 2);
        }

        int currLastIdx = (nextLast - 1 + items.length) % items.length;
        T currLastItem = items[currLastIdx];
        items[currLastIdx] = null;
        nextLast = currLastIdx;
        size--;
        return currLastItem;
    }

    @Override
    public T get(int i) {
        int currIdx = (nextFirst + 1 + i) % items.length;
        return items[currIdx];
    }
}


