package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;

    public MaxArrayDeque() {
        super();
    }

    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.comparator = c;
    }

    public T max() {
        if (this.isEmpty()) {
            return null;
        }

        T maxItem = this.get(0);
        for (int i = 1; i < this.size(); i++) {
            T currItem = this.get(i);
            if (comparator.compare(currItem, maxItem) > 0) {
                maxItem = currItem;
            }
        }

        return maxItem;
    }

    public T max(Comparator<T> c) {
        if (this.isEmpty()) {
            return null;
        }

        T maxItem = this.get(0);
        for (int i = 1; i < this.size(); i++) {
            T currItem = this.get(i);
            if (c.compare(currItem, maxItem) > 0) {
                maxItem = currItem;
            }
        }

        return maxItem;
    }
}
