package cursoED.semana13.GrafoAd;

public class GrafoAdcia {
	int numVerts;
	static int maxVerts = 20;
	VerticeAdy[] tablAdc;

	public GrafoAdcia(int mx) {
		tablAdc = new VerticeAdy[mx];
		numVerts = 0;
		maxVerts = mx;
	}

	public void nuevoVertice(String nombre) {
		if (numVerts >= maxVerts) {
			// Se podría implementar una ampliación dinámica del tamaño de tablAdc
			throw new IllegalStateException("El número máximo de vértices ha sido alcanzado.");
		}
		VerticeAdy v = new VerticeAdy(nombre);
		tablAdc[numVerts] = v;
		v.setNumVertice(numVerts);
		numVerts++;
	}

	public void insertarArco(int origen, int destino, double peso) {
		if (origen < 0 || origen >= numVerts || destino < 0 || destino >= numVerts) {
			throw new IllegalArgumentException("Índice de vértice inválido.");
		}
		VerticeAdy v = tablAdc[origen];
		Arco a = new Arco(destino, peso);
		if (!v.getLad().contains(a)) {
			v.getLad().add(0, a); // Insertar al principio para O(1)
		}
	}

	public void eliminarArco(int origen, int destino) {
		if (origen < 0 || origen >= numVerts) {
			throw new IllegalArgumentException("Índice de vértice inválido.");
		}
		VerticeAdy v = tablAdc[origen];
		Arco a = new Arco(destino);
		v.getLad().remove(a);
	}

	public boolean adyacente(int origen, int destino) {
		if (origen < 0 || origen >= numVerts) {
			return false;
		}
		VerticeAdy v = tablAdc[origen];
		Arco a = new Arco(destino);
		return v.getLad().contains(a);
	}

	public void eliminarVertice(int vertice) {
		if (vertice < 0 || vertice >= numVerts) {
			throw new IllegalArgumentException("Índice de vértice inválido.");
		}
		for (int i = 0; i < numVerts; i++) {
			eliminarArco(i, vertice);
		}
		for (int i = vertice; i < numVerts - 1; i++) {
			tablAdc[i] = tablAdc[i + 1];
			tablAdc[i].setNumVertice(i);
		}
		tablAdc[numVerts - 1] = null;
		numVerts--;
	}
    public int numVertice(String nombre) {
        for (int i = 0; i < numVerts; i++) {
            if (tablAdc[i].getNombre().equals(nombre)) {
                return i;
            }
        }
        return -1; // Vértice no encontrado
    }

    public int numeroDeVertices() {
        return numVerts;
    }

    static final int CLAVE = -1; // Constante para vértices no visitados

    public static int[] recorrerProf(GrafoAdcia g, String org) throws Exception {
        int v, w;
        PilaLista pila = new PilaLista();
        int[] m = new int[g.numeroDeVertices()];

        // Inicializa los vértices como no marcados
        v = g.numVertice(org);
        if (v < 0) throw new Exception("Vértice origen no existe");

        for (int i = 0; i < g.numeroDeVertices(); i++) {
            m[i] = CLAVE;
        }

        m[v] = 0; // Vértice origen queda marcado
        pila.insertar(v);

        while (!pila.pilaVacia()) {
            Integer cw = pila.quitar();
            w = cw.intValue();
            System.out.println("Vértice " + g.tablAdc[w].getNombre() + " visitado");

            // Inserta en la pila los adyacentes de w no marcados
            ListaIterador list = new ListaIterador(g.tablAdc[w].getLad());
            Arco ck;
            while ((ck = list.siguiente()) != null) {
                int k = ck.getDestino(); // Vértice adyacente
                if (m[k] == CLAVE) {
                    pila.insertar(k);
                    m[k] = 1; // Vértice queda marcado
                }
            }
        }

        return m;
    }
}
