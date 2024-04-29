package curso.ED.semana06;

import cursoED.semana04.Lista;
import cursoED.semana04.ListaEnlazadaSimple;

public class LinkedListQueue<E> implements Queue<E> {
    // Declara un miembro privado 'elements' que almacenará los elementos de la cola.
    private Lista<E> elements;
    
    // Constructor público sin argumentos que inicializa la lista enlazada simple como la estructura de datos subyacente.
    public LinkedListQueue() {
        elements = new ListaEnlazadaSimple<>();
    }
    
    // Método para agregar un elemento a la cola.
    @Override
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException(); // Lanza una excepción si el elemento a agregar es null.
        elements.agregar(e); // Añade el elemento al final de la lista.
        return true; // Siempre retorna true ya que una lista enlazada no tiene límites de capacidad predefinidos.
    }

    // Método para retirar y retornar el primer elemento de la cola.
    @Override
    public E poll() {
        if (isEmpty()) { 
            return null; // Si está vacía, retorna null.
        }
        return elements.remover(0); // Si no está vacía, remueve y retorna el elemento en el índice 0.
    }

    // Método para ver el primer elemento de la cola sin retirarlo.
    @Override
    public E peek() {
        if (isEmpty()) { 
            return null; // Si está vacía, retorna null.
        }
        return elements.get(0); // Si no está vacía, retorna el elemento en el índice 0 sin removerlo.
    }

    // Método para comprobar si la cola está vacía.
    @Override
    public boolean isEmpty() {
        return elements.esVacio(); 
    }

    // Método para obtener una representación en cadena de la cola.
    @Override
    public String toString() {
        return elements.toString(); 
    }

}
