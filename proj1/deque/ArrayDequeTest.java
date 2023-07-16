package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void addFirst() {
        ArrayDeque<String> ad = new ArrayDeque();
        // size should be 0
        assertEquals(0, ad.size());
        ad.addFirst("a");
        assertEquals(1, ad.size());
        ad.addFirst("b");
        assertEquals(2, ad.size());
        ad.addFirst("c");
        assertEquals(3, ad.size());

        // test it's in correct place
        assertEquals("c", ad.get(0));
        assertEquals("b", ad.get(1));
        assertEquals("a", ad.get(2));
    }

    @Test
    public void addLast() {
        ArrayDeque<String> ad = new ArrayDeque();
        // size should be 0
        assertEquals(0, ad.size());
        ad.addLast("a");
        assertEquals(1, ad.size());
        ad.addLast("b");
        assertEquals(2, ad.size());
        ad.addLast("c");
        assertEquals(3, ad.size());

        // test it's in correct place
        assertEquals("a", ad.get(0));
        assertEquals("b", ad.get(1));
        assertEquals("c", ad.get(2));
    }


    @Test
    public void isEmpty() {
        ArrayDeque<String> ad = new ArrayDeque();
        assertTrue(ad.isEmpty());
        ad.addFirst("a");
        assertFalse(ad.isEmpty());
        ad.removeFirst();
        assertTrue(ad.isEmpty());
    }

    @Test
    public void size() {
        ArrayDeque<String> ad = new ArrayDeque();
        assertEquals(0, ad.size());
        ad.addFirst("a");
        assertEquals(1, ad.size());
        ad.addFirst("b");
        assertEquals(2, ad.size());
        ad.addFirst("c");
        assertEquals(3, ad.size());
    }

    @Test
    public void printDeque() {
    }

    @Test
    public void get() {
        ArrayDeque<String> ad = new ArrayDeque();
        ad.addFirst("a");
        ad.addLast("b");
        ad.addFirst("c");
        ad.addLast("d");
        ad.addFirst("e");
        ad.addLast("f");

        assertEquals("e", ad.get(0));
        assertEquals("c", ad.get(1));
        assertEquals("a", ad.get(2));
        assertEquals("b", ad.get(3));
        assertEquals("d", ad.get(4));
        assertEquals("f", ad.get(5));

        assertEquals(6, ad.size());
    }

    @Test
    public void removeFirst() {
        ArrayDeque<String> ad = new ArrayDeque();
        ad.addFirst("a");
        ad.addLast("b");
        ad.addFirst("c");
        ad.addLast("d");
        ad.addFirst("e");
        ad.addLast("f");

        assertEquals("e", ad.removeFirst());
        assertEquals("c", ad.removeFirst());
        assertEquals("a", ad.removeFirst());
        assertEquals("b", ad.removeFirst());
        assertEquals("d", ad.removeFirst());
        assertEquals("f", ad.removeFirst());

        assertEquals(0, ad.size());
    }

    @Test
    public void removeLast() {
        ArrayDeque<String> ad = new ArrayDeque();
        ad.addFirst("a");
        ad.addLast("b");
        ad.addFirst("c");
        ad.addLast("d");
        ad.addFirst("e");
        ad.addLast("f");

        assertEquals("f", ad.removeLast());
        assertEquals("d", ad.removeLast());
        assertEquals("b", ad.removeLast());
        assertEquals("a", ad.removeLast());
        assertEquals("c", ad.removeLast());
        assertEquals("e", ad.removeLast());

        assertEquals(0, ad.size());
    }

    @Test
    public void avoidNegativeSize() {
        ArrayDeque<String> ad = new ArrayDeque();
        ad.addFirst("a");
        ad.addLast("b");

        ad.removeFirst();
        ad.removeFirst();
        ad.removeFirst();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();

        assertEquals(0, ad.size());
    }
}