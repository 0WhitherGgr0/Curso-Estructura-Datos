package cursoED.semana13.GrafoAd;

import java.util.LinkedList;

public class PilaLista {
    private LinkedList<Integer> pila;

    public PilaLista() {
        pila = new LinkedList<>();
    }

    public void insertar(Integer elemento) {
        pila.push(elemento);
    }

    public Integer quitar() {
        return pila.pop();
    }

    public boolean pilaVacia() {
        return pila.isEmpty();
    }
}
