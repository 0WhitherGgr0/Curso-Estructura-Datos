package cursoED.semana09;

public class ArbolBinario<T> {
	protected Nodo<T> raiz;

	public ArbolBinario(Nodo<T> raiz) {
		this.raiz = raiz;
	}

	public ArbolBinario() {
		this(null);
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}

	boolean esVacio() {
		return raiz == null;
	}

    public static <T> void inorden(Nodo<T> r) {
        if (r != null) {
        	inorden(r.getIzdo());
        	procesar(r);
        	inorden(r.getDcho());
        }
    }
    public static <T> void preorden(Nodo<T> r) {
        if (r != null) {
            procesar(r);
            preorden(r.getIzdo());
            preorden(r.getDcho());
        }
    }
    public static <T> void posorden(Nodo<T> r) {
        if (r != null) {
        	posorden(r.getIzdo());
        	posorden(r.getDcho());
            procesar(r);
        }
    }
    private static <T> void procesar(Nodo<T> n) {
        System.out.print(n.getDato() + " ");
    }
    public void postorden() {
    	posorden(this.getRaiz());
    }
    public void inorden() {
    	inorden(this.getRaiz());
    }
    public void preorden() {
        preorden(this.getRaiz());
    }
    public int altura() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int alturaIzquierda = calcularAltura(nodo.getIzdo());
            int alturaDerecha = calcularAltura(nodo.getDcho());

            return Math.max(alturaIzquierda, alturaDerecha) + 1;
        }
    }
    
       
    private void preordenStr(Nodo<T> nodo, StringBuilder sb) {
        if (nodo != null) {
            sb.append(nodo.getDato()).append(", ");
            preordenStr(nodo.getIzdo(), sb);
            preordenStr(nodo.getDcho(), sb);
        }
    }

    private void inordenStr(Nodo<T> nodo, StringBuilder sb) {
        if (nodo != null) {
            inordenStr(nodo.getIzdo(), sb);
            sb.append(nodo.getDato()).append(", ");
            inordenStr(nodo.getDcho(), sb);
        }
    }

    private void postordenStr(Nodo<T> nodo, StringBuilder sb) {
        if (nodo != null) {
            postordenStr(nodo.getIzdo(), sb);
            postordenStr(nodo.getDcho(), sb);
            sb.append(nodo.getDato()).append(", ");
        }
    }
   
    public String preordenStr() {
        StringBuilder sb = new StringBuilder();
        preordenStr(this.getRaiz(), sb);
        if (sb.length() > 0) 
        	sb.setLength(sb.length() - 2); // Elimina la última coma y espacio
        return sb.toString();
    }

    public String inordenStr() {
        StringBuilder sb = new StringBuilder();
        inordenStr(this.getRaiz(), sb);
        if (sb.length() > 0)
        	sb.setLength(sb.length() - 2); // Elimina la última coma y espacio
        return sb.toString();
    }

    public String postordenStr() {
        StringBuilder sb = new StringBuilder();
        postordenStr(this.getRaiz(), sb);
        if (sb.length() > 0) 
        	sb.setLength(sb.length() - 2); // Elimina la última coma y espacio
        return sb.toString();
    }

       
}