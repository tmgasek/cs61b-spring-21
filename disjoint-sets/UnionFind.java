import java.util.Arrays;

public class UnionFind {
    public int[] parent;

    /**
     * Creates a UnionFind data structure holding n vertices.
     * Initially, all vertices are in disjoint sets.
     */
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
    }

    /**
     * Throws exception if v1 is not a valid index
     */
    public void validate(int v1) {
        if (v1 < 0 || v1 >= parent.length) {
            throw new IllegalArgumentException("Index " + v1 + " is not " +
                    "between 0 and " + (parent.length - 1));
        }
    }

    /**
     * Returns size of the set v1 belongs to
     */
    public int sizeOf(int v1) {
        int root = find(v1);
        return Math.abs(parent[root]);
    }

    /**
     * Returns the parent of v1.
     * If v1 is the root of a tree, returns the negative size of the tree
     * for which v1 is the root.
     */
    public int parent(int v1) {
        return -99;
    }

    /**
     * Returns true if nodes v1 and v2 are connected
     */
    public boolean connected(int v1, int v2) {
        return true;
    }

    /**
     * Connects two elements v1 and v2 together. v1 and v2 can be any valid elements,
     * and a union-by-size heuristic is used. If the sizes of the sets are equal,
     * tie-break by connecting v1’s root to v2’s root.
     * Unioning a vertex with itself or vertices that are already connected
     * should not change the sets, but it may alter the internal structure of the data structure.
     */
    public void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);

        if (root1 == root2) {  // Already in the same set
            return;
        }

        System.out.println("sizeOfRoot1 = " + sizeOf(root1));
        System.out.println("sizeOfRoot2 = " + sizeOf(root2));

        // always link root of smaller tree to root of larger tree.
        if (parent[root1] <= parent[root2]) {
            parent[root1] += parent[root2];  // Add the sizes together
            parent[root2] = root1;  // root1 becomes root2's parent
        } else {
            parent[root2] += parent[root1];  // Add the sizes together
            parent[root1] = root2;  // root2 becomes root1's parent
        }
    }

    /**
     * Returns the root of the set v1 belongs to.
     * Path-compression is employed allowing for fast search-time.
     */
    public int find(int v1) {
        validate(v1);
        int root = v1;

        // find the root
        while (parent[root] >= 0) {
            root = parent[root];
        }

        // path compression: make all the nodes on the path point to the root
        while (v1 != root) {
            int next = parent[v1];
            parent[v1] = root;
            v1 = next;
        }

        return root;
    }

    public static void main(String[] args) {
        UnionFind ds = new UnionFind(5);

        ds.union(0, 1);
        System.out.println("union 0, 1");
        System.out.println(Arrays.toString(ds.parent));

        // set the parent of 0 to parent of 3
        ds.union(0, 3);
        System.out.println("union 0, 3");
        System.out.println(Arrays.toString(ds.parent));

        ds.union(2,4);
        System.out.println("union 2, 4");
        System.out.println(Arrays.toString(ds.parent));

        ds.union(0, 2);
        System.out.println("union 0, 2");
        System.out.println(Arrays.toString(ds.parent));

    }


}
