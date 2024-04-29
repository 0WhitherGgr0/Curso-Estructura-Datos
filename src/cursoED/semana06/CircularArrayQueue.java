package cursoED.semana06;

public class CircularArrayQueue<E> implements Queue<E> {
    private static final int DEFAULT_MAX_SIZE = 100;
    private final int MAX_SIZE;
    private int head; // Índice del primer elemento de la cola.
    private int tail; // Índice del último elemento añadido a la cola.
    private Object[] elements;
    // Constructor sin argumentos que inicializa la cola con el tamaño máximo por defecto.
    public CircularArrayQueue() {
        this(DEFAULT_MAX_SIZE);
    }
    // Constructor que acepta un tamaño máximo específico para la cola.
    public CircularArrayQueue(int maxSize) {
        // Se suma 1 al tamaño máximo para diferenciar entre cola llena y vacía.
        MAX_SIZE = maxSize + 1;
        head = 0;
        tail = MAX_SIZE - 1; // Inicializa 'tail' al final del arreglo 
        elements = new Object[MAX_SIZE]; // Inicialización del arreglo.
    }
    
    // Método privado para calcular el siguiente índice en el arreglo de manera circular.
    private int nextIndex(int currentIndex) {
        // Usa modulo para volver al inicio del arreglo si se alcanza el final.
        return (currentIndex + 1) % MAX_SIZE;
    }

    // Método para añadir un elemento al final de la cola.
    @Override
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException("Cannot add null to the queue"); // No permite elementos nulos.
        if (!isFull()) {
            tail = nextIndex(tail); // Mueve 'tail' al siguiente índice circular.
            elements[tail] = e; // Almacena el elemento en la nueva posición de 'tail'.
            return true; // Indica éxito.
        } else {
            return false; // Retorna false si la cola está llena y no se puede añadir el elemento.
        }
    }

    // Método para remover y retornar el elemento al frente de la cola.
    @Override
    public E poll() {
        if (!isEmpty()) {
            E element = (E) elements[head]; // Guarda el elemento en 'head'.
            elements[head] = null; // Limpia la referencia para facilitar la recolección de basura.
            head = nextIndex(head); // Actualiza 'head' al siguiente índice circular.
            return element; // Retorna el elemento.
        }
        return null; // Retorna null si la cola está vacía.
    }

    // Método para ver el elemento al frente de la cola sin removerlo.
    @Override
    public E peek() {
        if (!isEmpty()) {
            return (E) elements[head]; // Retorna el elemento en 'head' sin modificarlo.
        }
        return null;
    }

    // Método para verificar si la cola está vacía.
    @Override
    public boolean isEmpty() {
        // La cola está vacía si el siguiente índice de 'tail' es igual a 'head'.
        return nextIndex(tail) == head;
    }

    // Método para verificar si la cola está completamente llena.
    public boolean isFull() {
        // La cola está llena si el índice dos lugares después de 'tail' es igual a 'head'.
        return nextIndex(nextIndex(tail)) == head;
    }

    // Método para proporcionar una representación en cadena de la cola.
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]"; // Retorna una representación vacía si la cola está vacía.
        }
        StringBuilder sb = new StringBuilder(); // Utiliza StringBuilder para construir la representación.
        sb.append('[');
        int i = head;
        while (i != tail) { // Itera desde 'head' hasta 'tail'.
            sb.append(elements[i]).append(", ");
            i = nextIndex(i); // Usa el índice circular para moverse por el arreglo.
        }
        sb.append(elements[tail]).append(']'); // Añade el último elemento.
        return sb.toString(); // Retorna la cadena construida.
    }
}
