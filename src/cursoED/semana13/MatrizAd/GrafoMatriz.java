package cursoED.semana13.MatrizAd;

public class GrafoMatriz {
	int numVerts;
	static int MaxVerts = 20;
	Vertice[] verts;
	int[][] matAd;

	public GrafoMatriz() {
		this(MaxVerts);
	}

	public GrafoMatriz(int mx) {
		matAd = new int[mx][mx];
		verts = new Vertice[mx];
		for (int i = 0; i < mx; i++) {
			for (int j = 0; j < mx; j++) {
				matAd[i][j] = 0;
			}
		}
		numVerts = 0;
	}

	public void nuevoVertice(String nom) {
		boolean esta = numVertice(nom) >= 0;
		if (!esta) {
			Vertice v = new Vertice(nom);
			v.asigVert(numVerts);
			verts[numVerts++] = v;
		}
	}

	public int numVertice(String vs) {
		Vertice v = new Vertice(vs);
		boolean encontrado = false;
		int i = 0;
		for (; (i < numVerts) && !encontrado;) {
			encontrado = verts[i].equals(v);
			if (!encontrado)
				i++;
		}
		return (i < numVerts) ? i : -1;
	}

	public void nuevoArco(String a, String b) {
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0) {
			throw new IllegalArgumentException("Vértice no existe");
		}
		matAd[va][vb] = 1;
	}

	public boolean adyacente(String a, String b) throws Exception {
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0)
			throw new Exception("Vértice no existe");
		return matAd[va][vb] == 1;
	}

	public boolean adyacente(int va, int vb) throws Exception {
		if (va < 0 || vb < 0)
			throw new Exception("Vértice no existe");
		return matAd[va][vb] == 1;
	}

	public int numeroDeVertices() {
		return numVerts;
	}

	static final int CLAVE = -1; // Constante para vértices no visitados

	public static int[] recorrerAnchura(GrafoMatriz g, String org) throws Exception {
		int w, v;
		int[] m;
		v = g.numVertice(org);
		if (v < 0)
			throw new Exception("Vértice origen no existe");
		ColaLista cola = new ColaLista();
		m = new int[g.numeroDeVertices()];

		// Inicializa los vértices como no marcados
		for (int i = 0; i < g.numeroDeVertices(); i++) {
			m[i] = CLAVE;
		}

		m[v] = 0; // Vértice origen queda marcado
		cola.insertar(v);

		while (!cola.colaVacia()) {
			Integer cw = cola.quitar();
			w = cw.intValue();
			System.out.println("Vértice " + g.verts[w].nomVertice() + " visitado");

			// Inserta en la cola los adyacentes de w no marcados
			for (int u = 0; u < g.numeroDeVertices(); u++) {
				if (g.matAd[w][u] == 1 && m[u] == CLAVE) {
					// Marca el vértice u con el número de arcos hasta él
					m[u] = m[w] + 1;
					cola.insertar(u);
				}
			}
		}

		return m;
	}
}
