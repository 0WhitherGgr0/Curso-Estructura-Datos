package cursoED.semana09;

public class ArbolBinarioBusqueda<T extends Comparable<T>> extends ArbolBinario<T> {
    public ArbolBinarioBusqueda(Nodo<T> raiz) {
        super(raiz);
    }

    public ArbolBinarioBusqueda() {
        super();
    }

    public Nodo<T> buscar(T dato) {
        if (getRaiz() == null)
            return null;
        else
            return localizar(getRaiz(), dato);
    }

    private Nodo<T> localizar(Nodo<T> raizSub, T dato) {
        if (raizSub == null)
            return null;
        int comparacion = dato.compareTo(raizSub.getDato());
        if (comparacion == 0)
            return raizSub;
        else if (comparacion < 0)
            return localizar(raizSub.getIzdo(), dato);
        else
            return localizar(raizSub.getDcho(), dato);
    }



    
//************************************************
    public String preordenStr() {
        StringBuilder sb = new StringBuilder();
        preordenStr(this.getRaiz(), sb);
        return sb.toString();
    }

    private void preordenStr(Nodo<T> nodo, StringBuilder sb) {
        if (nodo != null) {
            sb.append(nodo.getDato()).append(", ");
            preordenStr(nodo.getIzdo(), sb);
            preordenStr(nodo.getDcho(), sb);
        }
    }

    public String inordenStr() {
        StringBuilder sb = new StringBuilder();
        inordenStr(this.getRaiz(), sb);
        return sb.toString();
    }

    private void inordenStr(Nodo<T> nodo, StringBuilder sb) {
        if (nodo != null) {
            inordenStr(nodo.getIzdo(), sb);
            sb.append(nodo.getDato()).append(", ");
            inordenStr(nodo.getDcho(), sb);
        }
    }

    public String postordenStr() {
        StringBuilder sb = new StringBuilder();
        postordenStr(this.getRaiz(), sb);
        return sb.toString();
    }

    private void postordenStr(Nodo<T> nodo, StringBuilder sb) {
        if (nodo != null) {
            postordenStr(nodo.getIzdo(), sb);
            postordenStr(nodo.getDcho(), sb);
            sb.append(nodo.getDato()).append(", ");
        }
    }

    
    
 //************************************************************
    public void insertar(T valor) throws Exception {
        raiz = insertar(raiz, valor);
    }

    protected Nodo<T> insertar(Nodo<T> raizSub, T dato) throws Exception {
        if (raizSub == null)
            raizSub = new Nodo<>(null, dato, null);
        else if (dato.compareTo(raizSub.getDato()) < 0) {
            Nodo<T> iz;
            iz = insertar(raizSub.getIzdo(), dato);
            raizSub.setIzdo(iz);
        } else if (dato.compareTo(raizSub.getDato()) > 0) {
            Nodo<T> dr;
            dr = insertar(raizSub.getDcho(), dato);
            raizSub.setDcho(dr);
        } else
            throw new Exception("Nodo duplicado");
        return raizSub;
    }
 
    
//*************************************************************
    public void eliminar(T valor) throws Exception {
        raiz = eliminar(raiz, valor);
    }

    protected Nodo<T> eliminar(Nodo<T> raizSub, T dato) throws Exception {
        if (raizSub == null)
            throw new Exception("No encontrado el nodo con la clave");
        else if (dato.compareTo(raizSub.getDato()) < 0) {
            Nodo<T> iz;
            iz = eliminar(raizSub.getIzdo(), dato);
            raizSub.setIzdo(iz);
        } else if (dato.compareTo(raizSub.getDato()) > 0) {
            Nodo<T> dr;
            dr = eliminar(raizSub.getDcho(), dato);
            raizSub.setDcho(dr);
        } else // Nodo encontrado
        {
            Nodo<T> q;
            q = raizSub; // nodo a quitar del árbol
            if (q.getIzdo() == null)
                raizSub = q.getDcho();
            else if (q.getDcho() == null)
                raizSub = q.getIzdo();
            else { // tiene rama izquierda y derecha
                q = reemplazar(q);
            }
            q = null;
        }
        return raizSub;
    }

    private Nodo<T> reemplazar(Nodo<T> act) {
        Nodo<T> a, p;
        p = act;
        a = act.getIzdo(); // rama de nodos menores
        while (a.getDcho() != null) {
            p = a;
            a = a.getDcho();
        }
        act.setDato(a.getDato());
        if (p == act)
            p.setIzdo(a.getIzdo());
        else
            p.setDcho(a.getIzdo());
        return a;
    }

}
