public class AList<Item> {
    private Item[] items;
    private int size;

    /**
     * Creates an empty list.
     */
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /**
     * Inserts X into the back of the list.
     * The next item we want to add will go into position size.
     */
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = x;
        size++;
    }

    /**
     * Returns the item from the back of the list.
     */
    public Item getLast() {
        return items[size - 1];
    }

    /**
     * Gets the ith item in the list (0 is the front).
     */
    public Item get(int i) {
        return items[i];
    }

    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    public Item removeLast() {
        Item last = getLast();
        // This allows the GC to destroy item at that pos instead of keeping
        // it around for no reason and cause LOITERING
        items[size - 1] = null;
        size--;
        return last;
    }
}
