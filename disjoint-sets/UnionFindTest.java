import org.junit.Test;

import static org.junit.Assert.*;

public class UnionFindTest {


    @Test
    public void generalTest() {
        UnionFind ds = new UnionFind(10);

        // Test 1: Initial state. All elements are roots of their own trees with size 1
        assertArrayEquals(new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, ds.parent);

        ds.union(0, 1);

        // Test 2: After union of 0 and 1. 1 should be the root of the set with size 2.
        assertArrayEquals(new int[]{1, -2, -1, -1, -1, -1, -1, -1, -1, -1}, ds.parent);

        ds.union(0, 3);

        // Test 3: After union of 0 and 3. 1 should be the root of the set with size 3.
        assertArrayEquals(new int[]{1, -3, -1, 1, -1, -1, -1, -1, -1, -1}, ds.parent);

        ds.union(2, 5);

        // Test 4: After union of 2 and 5. 5 should be the root of the set with size 2.
        assertArrayEquals(new int[]{1, -3, 5, 1, -1, -2, -1, -1, -1, -1}, ds.parent);

        ds.union(0, 2);

        // Test 5: After union of 0 and 2. 1 should be the root of the set with size 5.
        assertArrayEquals(new int[]{1, -5, 5, 1, -1, 1, -1, -1, -1, -1}, ds.parent);
        assertArrayEquals(new int[]{1, -5, 5, 1, -1, 1, -1, -1, -1, -1}, ds.parent);
        assertArrayEquals(new int[]{1, -5, 5, 1, -1, 1, -1, -1, -1, -1}, ds.parent);
        assertArrayEquals(new int[]{1, -5, 5, 1, -1, 1, -1, -1, -1, -1}, ds.parent);
        assertArrayEquals(new int[]{1, -5, 5, 1, -1, 1, -1, -1, -1, -1}, ds.parent);
        assertArrayEquals(new int[]{1, -5, 5, 1, -1, 1, -1, -1, -1, -1}, ds.parent);
        assertArrayEquals(new int[]{1, -5, 5, 1, -1, 1, -1, -1, -1, -1}, ds.parent);
        assertArrayEquals(new int[]{1, -5, 5, 1, -1, 1, -1, -1, -1, -1}, ds.parent);
        assertArrayEquals(new int[]{1, -5, 5, 1, -1, 1, -1, -1, -1, -1}, ds.parent);
        assertArrayEquals(new int[]{1, -5, 5, 1, -1, 1, -1, -1, -1, -1}, ds.parent);
        assertArrayEquals(new int[]{1, -5, 5, 1, -1, 1, -1, -1, -1, -1}, ds.parent);
        assertArrayEquals(new int[]{1, -5, 5, 1, -1, 1, -1, -1, -1, -1}, ds.parent);
    }
}