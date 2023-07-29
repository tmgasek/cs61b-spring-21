public class QuickFindDS {
    private int[] id;

    /* The indices of the array represent the elements of set */
    /* The value at an index is the set number it belongs to */

    /* O(N) */
    public QuickFindDS(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }

    }

    /* need to iterate through array -> O(N) */
    public void connect(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    /* O(1) */
    public boolean isConnected(int p, int q) {
        return (id[p] == id[q]);
    }
}
