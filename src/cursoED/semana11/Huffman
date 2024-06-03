package cursoED.semana11;

import java.util.PriorityQueue;
import java.util.Comparator;

public class Huffman {
	public static void printCode(HuffmanNode root, String s) {
		if (root.left == null && root.right == null && Character.isLetter(root.c)) {
			System.out.println(root.c + " | " + s);
			return;
		}
		printCode(root.left, s + "0");
		printCode(root.right, s + "1");
	}

	public static void main(String[] args) {
		int n = 6;
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 45, 13, 12, 16, 9, 5 };
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new FreqComparator());
		for (int i = 0; i < n; i++) {
			HuffmanNode hn = new HuffmanNode();
			hn.c = charArray[i];
			hn.freq = charfreq[i];
			hn.left = null;
			hn.right = null;
			q.add(hn);
		}
		HuffmanNode root = null;
		while (q.size() > 1) {
			HuffmanNode x = q.poll();
			HuffmanNode y = q.poll();
			HuffmanNode z = new HuffmanNode();
			z.freq = x.freq + y.freq;
			z.c = '-';
			z.left = x;
			z.right = y;
			root = z;
			q.offer(z);
		}
		System.out.println(" Char | Huffman code ");
		System.out.println("--------------------");
		printCode(root, "");
	}
}

class HuffmanNode {
	int freq;
	char c;
	HuffmanNode left;
	HuffmanNode right;
}

class FreqComparator implements Comparator<HuffmanNode> {
	public int compare(HuffmanNode x, HuffmanNode y) {
		return x.freq - y.freq;
	}
}
