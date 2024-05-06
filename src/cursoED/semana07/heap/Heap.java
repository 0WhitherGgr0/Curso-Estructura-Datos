package cursoED.semana07.heap;

public class Heap<E> {
	static final int TAMINI = 10;
	private int numElem;
	private E[] v;

	public Heap() {
		numElem = 0;
		v = (E[]) new Object[TAMINI];
	}

	public static int parent(int i) {
		return (i - 1) / 2;
	}

	public static int leftChild(int i) {
		return (2 * i + 1);
	}

	public static int rightChild(int i) {
		return (2 * i + 1) + 1;
	}

	private boolean isFull() {
		return (numElem == v.length);
	}

	public boolean isEmpty() {
		return (numElem == 0);
	}

	private void ampliar() {
		E[] oldV = v;
		v = (E[]) new Object[numElem + TAMINI];
		for (int j = 0; j < numElem; j++)
			v[j] = oldV[j];
	}

	private void flotar(int i) {
		E nuevaClave = v[i];
		Comparable<? super E> key = (Comparable<? super E>) v[parent(i)];
		while ((i > 0) && (key.compareTo(nuevaClave) > 0)) {
			v[i] = v[parent(i)]; // baja el padre al hueco
			i = parent(i); // sube un nivel en el �rbol
			key = (Comparable<? super E>) v[parent(i)];
		}
		v[i] = nuevaClave; // sit�a la clave en su posici�n
	}

	public void insert(E e) {
		if (isFull()) {
			ampliar();
		}
		v[numElem] = e;
		flotar(numElem);
		numElem++;
	}

	public E element() {
		if (isEmpty())
			throw new RuntimeException("Acceso a mont�culo vac�o");
		return v[0];
	}

	public void criba(int raiz) {
		boolean esMonticulo;
		int hijo;
		esMonticulo = false;
		while ((raiz < numElem / 2) && !esMonticulo) {
			// determina el �ndice del hijo menor
			if (leftChild(raiz) == (numElem - 1)) // �nico descendiente
				hijo = leftChild(raiz);
			else {
				Comparable<? super E> key = (Comparable<? super E>) v[leftChild(raiz)];
				if (key.compareTo(v[rightChild(raiz)]) < 0)
					hijo = leftChild(raiz);
				else
					hijo = rightChild(raiz);
			}
			// compara raiz con el menor de los hijos
			Comparable<? super E> key = (Comparable<? super E>) v[hijo];
			if (key.compareTo(v[raiz]) < 0) {
				E t = v[raiz];
				v[raiz] = v[hijo];
				v[hijo] = t;
				raiz = hijo; /* continua por la rama de claves m�nimas */
			} else
				esMonticulo = true;
		}
	}

	public E remove() {
		if (isEmpty())
			throw new RuntimeException("Acceso a mont�culo vac�o");
		E menor;
		menor = v[0];
		v[0] = v[numElem - 1];
		criba(0);
		numElem--;
		return menor;
	}

	@Override
	public String toString() {
		String result = "[";
		int i = 0;
		for (i = 0; i < numElem - 1; i++) {
			result += v[i] + ", ";
		}
		if (i == numElem - 1)
			result += v[i];
		result += "]";
		return result;
	}
}
