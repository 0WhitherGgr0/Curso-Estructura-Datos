package cursoED.semana12;

import java.util.ArrayList;

public class BTreeNode {
    private ArrayList<Integer> keys;
    private int t;
    private ArrayList<BTreeNode> C;
    private boolean leaf;

    public BTreeNode(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        this.keys = new ArrayList<>();
        this.C = new ArrayList<>();
    }

    public String traverse() {
        StringBuilder result = new StringBuilder();
        traverse(result);
        return result.toString().trim();
    }

    private void traverse(StringBuilder result) {
        int i;
        for (i = 0; i < keys.size(); i++) {
            if (!leaf) {
                C.get(i).traverse(result);
            }
            result.append(keys.get(i)).append(" ");
        }
        if (!leaf) {
            C.get(i).traverse(result);
        }
    }

    public boolean isFull() {
        return keys.size() == 2 * t - 1;
    }

    public BTreeNode makeNewRoot(int val, BTreeNode newEntry) {
        BTreeNode root = new BTreeNode(t, false);
        root.keys.add(val);
        root.C.add(this);
        root.C.add(newEntry);
        return root;
    }

    public void split(int[] val, BTreeNode newEntry) {
        BTreeNode newNode = new BTreeNode(t, this.leaf);
        val[0] = this.keys.get(t - 1);

        for (int i = t; i < 2 * t - 1; i++) {
            newNode.keys.add(this.keys.get(i));
        }

        if (!this.leaf) {
            for (int i = t; i <= 2 * t - 1; i++) {
                newNode.C.add(this.C.get(i));
            }
            this.C.subList(t, 2 * t).clear();
        }

        this.keys.subList(t - 1, 2 * t - 1).clear();
        newEntry.keys.clear();
        newEntry.keys.add(val[0]);
        newEntry.C.clear();
        newEntry.C.add(newNode);
    }

    public void insert(int newKey, int[] val, BTreeNode[] newEntry) {
        if (!leaf) {
            int i = 0;
            while (i < keys.size() && newKey > keys.get(i))
                i++;
            C.get(i).insert(newKey, val, newEntry);
            if (newEntry[0] == null)
                return;

            if (keys.size() < 2 * t - 1) {
                keys.add(i, val[0]);
                C.add(i + 1, newEntry[0]);
                newEntry[0] = null;
            } else {
                keys.add(i, val[0]);
                C.add(i + 1, newEntry[0]);
                split(val, newEntry[0]);
            }
        } else {
            int i = 0;
            while (i < keys.size() && newKey > keys.get(i))
                i++;
            keys.add(i, newKey);
            if (keys.size() == 2 * t) {
                BTreeNode newLeaf = new BTreeNode(t, true);
                val[0] = this.keys.get(t - 1);
                newLeaf.keys.addAll(keys.subList(t, 2 * t - 1));
                this.keys.subList(t - 1, 2 * t - 1).clear();
                newEntry[0] = newLeaf;
            }
        }
    }

    public BTreeNode search(int key) {
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        if (i < keys.size() && keys.get(i) == key) {
            return this;
        }
        if (leaf) {
            return null;
        }
        return C.get(i).search(key);
    }
}
