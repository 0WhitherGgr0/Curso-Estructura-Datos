package cursoED.semana12;

public class BTree {

    private BTreeNode root;
    private int t;

    public BTree(int t) {
        this.root = new BTreeNode(t, true);
        this.t = t;
    }

    public void insert(int key) {
        BTreeNode[] newEntry = {null};
        int[] val = {0};
        root.insert(key, val, newEntry);
        if (newEntry[0] != null) {
            root = root.makeNewRoot(val[0], newEntry[0]);
        }
    }

    public String display() {
        return root.traverse();
    }

    public BTreeNode search(int key) {
        return root.search(key);
    }
}
