package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node match = get(root, key);
        if (match == null) {
            return null;
        }

        return match.value;
    }

    private Node get(Node node, K key) {
        // base case, not found
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + size(node.left) + size(node.right);
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        // fell off tree
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            // already in tree
            node.value = value;
        }

        return node;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    private void printInOrder() {
        printInOrder(root);

    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println("Key: " + node.key + ", Value: " + node.value);
            printInOrder(node.right);
        }
    }

    public static void main(String[] args) {
        BSTMap<String, Integer> bstMap = new BSTMap<>();

        bstMap.put("Alice", 1);
        bstMap.put("Bob", 2);
        bstMap.put("Charlie", 3);

        System.out.println("SIZE 3 ? :" + bstMap.size());

        // Testing get
        System.out.println("Alice (should be 1): " + bstMap.get("Alice"));
        System.out.println("Bob (should be 2): " + bstMap.get("Bob"));
        System.out.println("Charlie (should be 3): " + bstMap.get("Charlie"));
        System.out.println("David (should be null): " + bstMap.get("David"));

        // Testing printInOrder
        System.out.println("Print In Order:");
        bstMap.printInOrder();

        // Testing clear
        bstMap.clear();
        System.out.println("Size after clear (should be 0): " + bstMap.size());
        System.out.println("Alice after clear (should be null): " + bstMap.get("Alice"));
    }
}
