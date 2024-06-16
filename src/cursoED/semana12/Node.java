package cursoED.semana12;

public class Node {
	int n;
	int[] key;
	Node[] child;
	boolean leaf;

	public Node(int t) {
		this.n = 0;
		this.key = new int[2 * t - 1];
		this.child = new Node[2 * t];
		this.leaf = true;
	}
	Node BtreeSearch(Node x, int k) {
	    int i = 0;
	    while (i < x.n && k >= x.key[i]) {
	        i++;
	    }
	    if (i < x.n && k == x.key[i]) {
	        return x;
	    }
	    if (x.leaf) {
	        return null;
	    }
	    return BtreeSearch(x.child[i], k);
	}
	
}
