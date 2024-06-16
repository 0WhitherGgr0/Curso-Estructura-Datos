package cursoED.semana11;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
	private char[] charArray;
	private int[] charfreq;
	// Mapas para la codificación y decodificación de caracteres
	private Map<Character, String> charCodificado = new HashMap<>();
	private Map<String, Character> codificadoChar = new HashMap<>();

	HuffmanNode root;


	HuffmanTree(char[] charArray, int[] charfreq) {
		this.charArray = charArray;
		this.charfreq = charfreq;

		root = buildTree();

		buildMaps(root, "");
	} 


	public String getCodificado(char car) {
		return charCodificado.get(car);
	}


	public String getDesCodificado(String str) {
		String result = "";
		String codigo = "";
		if(str == null) {
			return null;
		}
		// Itera sobre cada bit de la cadena
		for (int i = 0; i < str.length(); i++) {
			codigo += str.charAt(i); // Agrega el bit al código actual
			// Si el código está en el mapa, agrega el carácter resultante a la cadena resultado
			if (codificadoChar.containsKey(codigo)) {
				result += codificadoChar.get(codigo);
				codigo = ""; 
			}						
		}
		return result;
	}

	private void buildMaps(HuffmanNode root, String s) {
		// Si el nodo actual es una hoja (nodo sin hijos)
		if (root.left == null && root.right == null && Character.isLetter(root.c)) {
			charCodificado.put(root.c, s); // Asocia el carácter con su código
			codificadoChar.put(s, root.c); // Asocia el código con su carácter
			return;	
		}
		// Llama recursivamente para los hijos izquierdo y derecho
		buildMaps(root.left, s + "0");
		buildMaps(root.right, s + "1");
	}

	// Construye el árbol de Huffman a partir de los caracteres y sus frecuencias
	private HuffmanNode buildTree() {
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(charArray.length, new FreqComparator());
		for (int i = 0; i < charArray.length; i++) {
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
		return root; 
	}
}
