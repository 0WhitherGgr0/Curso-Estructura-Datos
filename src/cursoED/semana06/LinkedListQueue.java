package cursoED.semana06;

import cursoED.semana04.Lista;
import cursoED.semana04.ListaEnlazadaSimple;

public class LinkedListQueue<E> implements Queue<E> {
    private Lista<E> elements;
    
    public LinkedListQueue() {
        elements = new ListaEnlazadaSimple<>();
    }
    
    @Override
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException(); // Lanza una excepción si el elemento a agregar es null.
        elements.agregar(e); // Añade el elemento al final de la lista.
        return true; 
    }

    @Override
    public E poll() {
        if (isEmpty()) { 
            return null; // Si está vacía, retorna null.
        }
        return elements.remover(0); 
    }

    @Override
    public E peek() {
        if (isEmpty()) { 
            return null; // Si está vacía, retorna null.
        }
        return elements.get(0); // Si no está vacía, retorna el elemento en el índice 0 sin removerlo.
    }

    @Override
    public boolean isEmpty() {
        return elements.esVacio(); 
    }

    @Override
    public String toString() {
        return elements.toString(); 
    }

}
