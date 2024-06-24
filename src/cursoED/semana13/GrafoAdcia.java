package cursoED.semana13;

import java.util.*;

public class GrafoAdcia {
	private Map<Integer, List<Integer>> adjList;

	public GrafoAdcia() {
		this.adjList = new HashMap<>();
	}

	public void agregaArco(int u, int v) {
		adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
	}

	public void agregaArcoPeso(int u, int v, int w) {
		agregaArco(u, v);
	}

	public void borraArco(int u, int v) {
		if (adjList.containsKey(u)) {
			adjList.get(u).remove(Integer.valueOf(v));
		}
	}

	public boolean adyacente(int u, int v) {
		return adjList.containsKey(u) && adjList.get(u).contains(v);
	}

	public void agregaVertice(int u) {
		adjList.putIfAbsent(u, new ArrayList<>());
	}

	public void borraVertice(int u) {
		adjList.remove(u);
		for (List<Integer> neighbors : adjList.values()) {
			neighbors.remove(Integer.valueOf(u));
		}
	}

	public void imprimirGrafo() {
		for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
			int u = entry.getKey();
			List<Integer> neighbors = entry.getValue();
			System.out.print(u + " -> ");
			for (int v : neighbors) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}
	
	
	/*static public int[] recorrerProf(GrafoAdcia g, String org) throws Exception {
		int v, w;
		PilaLista pila = new PilaLista();
		int [] m;
		m = new int[g.numeroDeVertices()];
		// inicializa los vértices como no marcados
		v = g.numVertice(org);
		if (v < 0) throw new Exception("Vértice origen no existe");
		for (int i = 0; i < g.numeroDeVertices(); i++)
		 m[i] = CLAVE;
		m[v] = 0; // vértice origen queda marcado
		pila.insertar(new Integer(v));
		while (!pila.pilaVacia())
		{
			 Integer cw;
			 cw = (Integer) pila.quitar();
			 w = cw.intValue();
			 System.out.println("Vértice" + g.tablAdc[w] + "visitado");
			 // inserta en la pila los adyacentes de w no marcados
			 // recorre la lista con un iterador
			 ListaIterador list = new ListaIterador(g.tablAdc[w].lad);
			 Arco ck;
			 do
			 {
				 int k;
				 ck = (Arco) list.siguiente();
				 if (ck != null)
				 {
					 k = ck.getDestino(); // vértice adyacente
					 if (m[k] == CLAVE)
						 {
						 pila.insertar(new Integer(k));
						 m[k] = 1; // vértice queda marcado
						 }
				 }
			 } while (ck != null);
			}
			return m;
		}*/

}
