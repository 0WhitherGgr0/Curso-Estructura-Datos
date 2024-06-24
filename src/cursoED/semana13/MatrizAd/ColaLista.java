package cursoED.semana13.MatrizAd;

import java.util.LinkedList;

public class ColaLista {
    private LinkedList<Integer> cola;

    public ColaLista() {
        cola = new LinkedList<>();
    }

    public void insertar(Integer elemento) {
        cola.addLast(elemento);
    }

    public Integer quitar() {
        return cola.removeFirst();
    }

    public boolean colaVacia() {
        return cola.isEmpty();
    }
}