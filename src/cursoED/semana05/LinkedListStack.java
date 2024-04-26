package cursoED.semana05;

import cursoED.semana04.Lista;
import cursoED.semana04.ListaEnlazadaSimple;
import java.util.EmptyStackException;

public class LinkedListStack<E> implements Stack<E> {

    private Lista<E> data;

    public LinkedListStack() {
        data = new ListaEnlazadaSimple<>();
    }

    @Override
    public void push(E e) {
        data.agregar(0, e);
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return data.remover(0);
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return data.get(0);
    }

    @Override
    public boolean empty() {
        return data.esVacio();
    }

    @Override
    public String toString() { 
        if (empty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < data.tamanyo() - 1; i++) {
            sb.append(data.get(i)).append(", ");
        }
        sb.append(data.get(data.tamanyo() - 1)).append("]");
        return sb.toString();
    }
}
