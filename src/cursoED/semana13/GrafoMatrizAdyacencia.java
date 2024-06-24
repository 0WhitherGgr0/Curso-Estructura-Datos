package cursoED.semana13;

public class GrafoMatrizAdyacencia {
	private int[][] matrizAdy;
	private int numVertices;

	public GrafoMatrizAdyacencia(int numVertices) {
		this.numVertices = numVertices;
		this.matrizAdy = new int[numVertices][numVertices];
	}

	public void agregaArco(int u, int v) {
		matrizAdy[u][v] = 1;
	}

	public void agregaArcoPeso(int u, int v, int w) {
		agregaArco(u, v);
	}

	public void borraArco(int u, int v) {
		matrizAdy[u][v] = 0;
	}

	public boolean adyacente(int u, int v) {
		return matrizAdy[u][v] != 0;
	}

	public void agregaVertice(int u) {
		if (u >= numVertices) {
			int[][] nuevaMatrizAdy = new int[u + 1][u + 1];
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j < numVertices; j++) {
					nuevaMatrizAdy[i][j] = matrizAdy[i][j];
				}
			}
			matrizAdy = nuevaMatrizAdy;
			numVertices = u + 1;
		}
	}

	public void borraVertice(int u) {
		for (int i = 0; i < numVertices; i++) {
			matrizAdy[u][i] = 0; // Eliminar arcos salientes desde u
			matrizAdy[i][u] = 0; // Eliminar arcos entrantes hacia u
		}
	}

	public void imprimirGrafo() {
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				System.out.print(matrizAdy[i][j] + " ");
			}
			System.out.println();
		}
	}

/*	public static int[]recorrerAnchura(GrafoMatrizAdyacencia g, String org) throws Exception {
		int w, v;
		int [] m;
		v = g.numVertice(org);
		if (v < 0) throw new Exception("Vértice origen no existe");
		ColaLista cola = new ColaLista();
		m = new int[g.numeroDeVertices()];
		// inicializa los vértices como no marcados
		for (int i = 0; i < g.numeroDeVertices(); i++)
				m[i] = CLAVE;
		m[v] = 0; // vértice origen queda marcado
		cola.insertar(new Integer(v));
		while (! cola.colaVacia())
		{
			 Integer cw;
			 cw = (Integer) cola.quitar()
			 w = cw.intValue();
			 System.out.println("Vértice " + g.verts[w] + "visitado");
			 // inserta en la cola los adyacentes de w no marcados
			 for (int u = 0; u < g.numeroDeVertices(); u++)
				 if ((g.matAd[w][u] == 1) && (m[u] == CLAVE))
				 {
				 // se marca vertice u con número de arcos hasta el
				 m[u] = m[w] + 1;
				 cola.insertar(new Integer(u));
				 }
		}
		return m;
	}*/
}
