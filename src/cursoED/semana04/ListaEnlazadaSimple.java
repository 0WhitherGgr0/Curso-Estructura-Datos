package cursoED.semana04;

public class ListaEnlazadaSimple<E> implements Lista<E> {
    private int tamanyo = 0;
    private Nodo<E> primero;
    private Nodo<E> ultimo;
    
    private static class Nodo<E> {
        E item;
        Nodo<E> sgte;
        
        Nodo(E element, Nodo<E> sgte) {
            this.item = element;
            this.sgte = sgte;
        }
    }
    
    @Override
    public int tamanyo() {
        return tamanyo;
    }
    
    @Override
    public boolean esVacio() {
        return tamanyo == 0;
    }
    
    @Override
    public boolean contiene(Object o) {
        return indiceDe(o) >= 0;
    }
    
    @Override
    public void agregar(E e) {
        final Nodo<E> u = ultimo;
        final Nodo<E> nuevoNodo = new Nodo<>(e, null);
        ultimo = nuevoNodo;
        if (u == null)
            primero = nuevoNodo;
        else
            u.sgte = nuevoNodo;
        tamanyo++;
    }
    
    @Override
    public E get(int index) {
        validarElementoIndice(index);
        return nodo(index).item;
    }
    
    private void validarElementoIndice(int index) {
    	if (!(index >= 0 && index < tamanyo))
    	throw new IndexOutOfBoundsException("indice: " + index + ", tamaño: " + tamanyo);

    }
    
    
  //Ejercicio: desarrollado
    private Nodo<E> nodo(int index) {
        validarElementoIndice(index);
        Nodo<E> x = primero;
        for (int i = 0; i < index; i++)
            x = x.sgte;
        return x;
    }
    
    //*****************************************
    
    @Override
    public E set(int index, E element) {
        validarElementoIndice(index);
        Nodo<E> x = nodo(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }
    
    
    @Override
    public void agregar(int index, E element) {
        validarAgregarIndice(index);
        if (index == tamanyo)
            agregar(element);
        else if (index == 0)
            linkearPrimero(element);
        else
            linkearMedio(element, index);
    }
    
    //Practica: desarrolla linkearPrimero y linkearMedio
    private void linkearPrimero(E element) {
        primero = new Nodo<>(element, primero);
        if (ultimo == null)
            ultimo = primero;
        tamanyo++;
    }
    
    private void linkearMedio(E element, int index) {
        Nodo<E> x = primero;
        for (int i = 0; i < index - 1; i++)
            x = x.sgte;
        x.sgte = new Nodo<>(element, x.sgte);
        tamanyo++;
    }
    
    //*****************************************
    
    private void validarAgregarIndice(int index) {
    	if (!(index >= 0 && index <= tamanyo))
    	throw new IndexOutOfBoundsException("indice: " + index + ", tamaño: " + tamanyo);

    }
    
    @Override
    public boolean remover(Object o) {
        Nodo<E> previo = null;
        if (o == null) {
            for (Nodo<E> x = primero; x != null; previo = x, x = x.sgte) {
                if (x.item == null) {
                    desligar(previo, x);
                    return true;
                }
            }
        } else {
            for (Nodo<E> x = primero; x != null; previo = x, x = x.sgte) {
                if (o.equals(x.item)) {
                    desligar(previo, x);
                    return true;
                }
            }
        }
        return false;
    }
   
    //Practica: private E desligar(Nodo<E> previo, Nodo<E> x)
    
    private E desligar(Nodo<E> previo, Nodo<E> x) {
        if (previo == null) {
            primero = x.sgte;
        } else {
            previo.sgte = x.sgte;
        }
        if (x == ultimo) {
            ultimo = previo;
        }
        tamanyo--;
        E item = x.item;
        x.item = null;
        x.sgte = null;
        return item;
    }
    
    //*****************************************

    @Override
    public E remover(int index) {
        validarElementoIndice(index);
        Nodo<E> x = primero;
        Nodo<E> previo = null;
        for (int i = 0; i < index; i++) {
            previo = x;
            x = x.sgte;
        }
        return desligar(previo, x);
    }
    
    @Override
    public void limpiar() {
        for (Nodo<E> x = primero; x != null;) {
            Nodo<E> sgte = x.sgte;
            x.item = null;
            x.sgte = null;
            x = sgte;
        }
        primero = ultimo = null;
        tamanyo = 0;
    }
    
    @Override
    public int indiceDe(Object o) {
        int index = 0;
        if (o == null) {
            for (Nodo<E> x = primero; x != null; x = x.sgte) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Nodo<E> x = primero; x != null; x = x.sgte) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }
  //Ejercicio: desarrollar
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista(");
        Nodo<E> current = primero;
        while (current != null) {
            sb.append(current.item);
            if (current.sgte != null) {
                sb.append(", ");
            }
            current = current.sgte;
        }
        sb.append(")");
        return sb.toString();
    }
    //*****************************************
   
}
