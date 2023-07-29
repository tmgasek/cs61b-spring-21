import java.util.Iterator;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size; // next item to be added will be at pos size

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    // returns true if this map contains a mapping for the specified key
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    // associates the specified value with the specified key in this map
    // throws IllegalArgumentException if key is null.
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("You can't add null");
        }

        if (contains(x)) {
            return;
        }
        items[size] = x;
        size++;
    }

    // Returns the number of key-value mappings in this map
    public int size() {
        return size;
    }

    // returns an iterator (a.k.a seer) into ME
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int pos;

        public ArraySetIterator() {
            pos = 0;
        }

        public boolean hasNext() {
            return pos < size;
        }

        public T next() {
            T returnItem = items[pos];
            pos++;
            return returnItem;
        }


    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if (o.size() != this.size()) {
            return false;
        }
        for (T item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        Iterator<Integer> aseer = aset.iterator();
        while (aseer.hasNext()) {
            int i = aseer.next();
            System.out.println(i);
        }

        for (int i : aset) {
            System.out.println(i);
        }


//        ArraySet<String> s = new ArraySet<>();
//        s.add(null);
//        s.add("horse");
//        s.add("fish");
//        s.add("house");
//        s.add("fish");
//        System.out.println(s.contains("horse"));
//        System.out.println(s.size());


    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
