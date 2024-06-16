package cursoED.semana12;

public class BTreeNode {
	int[] keys;
    int t;
    BTreeNode[] C;
    int n;
    boolean leaf;

    public BTreeNode(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        this.keys = new int[2 * t - 1];
        this.C = new BTreeNode[2 * t];
        this.n = 0;
    }

    public void traverse() {
        int i;
        for (i = 0; i < this.n; i++) {
            if (!this.leaf) {
                this.C[i].traverse();
            }
            System.out.print(keys[i] + " ");
        }

        if (!this.leaf)
            this.C[i].traverse();
    }

    public BTreeNode search(int k) {
        int i = 0;
        while (i < n && k > keys[i])
            i++;

        if (keys[i] == k)
            return this;

        if (leaf)
            return null;

        return C[i].search(k);
    }
}
