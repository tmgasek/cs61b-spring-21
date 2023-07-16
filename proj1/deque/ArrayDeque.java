package deque;

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public void upSize(int capacity) {
        Item[] newArr = (Item[]) new Object[capacity];

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

    public void downSize(int capacity) {
        Item[] newArr = (Item[]) new Object[capacity];

        int currIdx = (nextFirst + 1) % items.length;
        for (int newIdx = 0; newIdx < capacity; newIdx++) {
            newArr[newIdx] = items[currIdx];
            currIdx = (currIdx + 1) % items.length;
        }

        items = newArr;
        nextFirst = capacity - 1;
        nextLast = items.length - size;

    }

    public void addFirst(Item item) {
        if (size >= items.length) {
            upSize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size++;
    }

    public void addLast(Item item) {
        if (size >= items.length) {
            upSize(size * 2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1 + items.length) % items.length;
        size++;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public int size() {
        return size;
    }

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

    public Item removeFirst() {
        if (size <= 0) {
            return null;
        }
        if (shouldDownSize()) {
            downSize(items.length / 2);
        }

        // get index before nextFirst
        int currFirstIdx = (nextFirst + 1 + items.length) % items.length;
        // save item at that index
        Item currFirstItem = items[currFirstIdx];
        // make the item at that index null (prevent loitering)
        items[currFirstIdx] = null;
        // set the nextFirst to the index before it
        nextFirst = currFirstIdx;
        // decrease size
        size--;
        return currFirstItem;
    }


    public Item removeLast() {
        if (size <= 0) {
            return null;
        }
        if (shouldDownSize()) {
            downSize(items.length / 2);
        }

        int currLastIdx = (nextLast - 1 + items.length) % items.length;
        Item currLastItem = items[currLastIdx];
        items[currLastIdx] = null;
        nextLast = currLastIdx;
        size--;
        return currLastItem;
    }

    public Item get(int i) {
        int currIdx = (nextFirst + 1 + i) % items.length;
        return items[currIdx];
    }

    private boolean shouldDownSize() {
        double ratio = ((double) size - 1) / (double) items.length;
        return ratio < 0.25 && items.length >= 16;
    }

    public static void main(String[] args) {
        ArrayDeque<String> ad = new ArrayDeque();
        ad.addLast("a");
        ad.addLast("b");
        ad.addFirst("c");
        ad.addLast("d");
        ad.addLast("e");
        ad.addFirst("f");
        ad.addLast("g");
        ad.addLast("h");

        ad.addLast("Z");

        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeFirst();


        ad.printDeque();
    }
}
