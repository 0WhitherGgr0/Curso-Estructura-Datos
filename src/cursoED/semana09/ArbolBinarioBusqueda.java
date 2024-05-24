package cursoED.semana09;

public class ArbolBinarioBusqueda<T extends Comparable<T>> extends ArbolBinario<T> {
    public ArbolBinarioBusqueda(Nodo<T> raiz) {
        super(raiz);
    }

    public ArbolBinarioBusqueda() {
        super();
    }

    public Nodo<T> buscar(T dato) {
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

    public void insertar(T valor) throws RuntimeException {
        raiz = insertar(raiz, valor);
    }

    protected Nodo<T> insertar(Nodo<T> raizSub, T dato) throws RuntimeException {
        if (raizSub == null)
            raizSub = new Nodo<>(null, dato, null);
        else if (dato.compareTo(raizSub.getDato()) < 0) {
            Nodo<T> iz = insertar(raizSub.getIzdo(), dato);
            raizSub.setIzdo(iz);
        } else if (dato.compareTo(raizSub.getDato()) > 0) {
            Nodo<T> dr = insertar(raizSub.getDcho(), dato);
            raizSub.setDcho(dr);
        } else {
            throw new RuntimeException("Nodo duplicado");
        }
        return raizSub;
    }

    public void eliminar(T valor) throws RuntimeException {
        raiz = eliminar(raiz, valor);
    }

    protected Nodo<T> eliminar(Nodo<T> raizSub, T dato) throws RuntimeException {
        if (raizSub == null)
            throw new RuntimeException("No encontrado el nodo con la clave");
        int comparacion = dato.compareTo(raizSub.getDato());
        if (comparacion < 0) {
            Nodo<T> iz = eliminar(raizSub.getIzdo(), dato);
            raizSub.setIzdo(iz);
        } else if (comparacion > 0) {
            Nodo<T> dr = eliminar(raizSub.getDcho(), dato);
            raizSub.setDcho(dr);
        } else {
            Nodo<T> q = raizSub;
            if (q.getIzdo() == null) {
                raizSub = q.getDcho();
            } else if (q.getDcho() == null) {
                raizSub = q.getIzdo();
            } else {
                q = reemplazar(q);
            }
            q = null;
        }
        return raizSub;
    }

    private Nodo<T> reemplazar(Nodo<T> act) {
        Nodo<T> a, p;
        p = act;
        a = act.getIzdo(); 
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
