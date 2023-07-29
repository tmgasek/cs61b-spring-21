public interface DisjointSets {
    /** Connects two items P and Q */
    void connect(int p, int q);

    /** Returns true if P and Q are connected */
    boolean isConnected(int p, int q);
}
