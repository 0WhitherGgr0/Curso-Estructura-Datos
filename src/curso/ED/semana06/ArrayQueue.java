package curso.ED.semana06;
public class ArrayQueue<E> implements Queue<E> {
	private static final int DEFAULT_MAX_SIZE = 100;
	private final int MAX_SIZE;
	private int head;
	private int tail;
	private E[] elements;
	// Constructor por defecto que crea una cola con el tamaño máximo por defecto.	
	public ArrayQueue() {	
		this(DEFAULT_MAX_SIZE);		
	}	
    // Constructor que permite especificar el tamaño máximo de la cola.
	public ArrayQueue(int maxSize) {
		MAX_SIZE = maxSize;
		head = 0;
		tail = -1;
		elements = (E[])new Object[MAX_SIZE];
	}	
    // Método para agregar un elemento al final de la cola.
	@Override
	public boolean offer(E e) {
		if (e == null)
			throw new NullPointerException();
		
		if (!isFull()) {
			elements[++tail] = e;
			return true;
		} else
			return false;
	}
    // Método para eliminar y devolver el elemento al frente de la cola.
	@Override
	public E poll() {
		if (!isEmpty()) {
			return elements[head++];
		}		
		return null;
	}
    // Método para obtener el elemento al frente de la cola sin eliminarlo.
	@Override
	public E peek() {
		if (!isEmpty()) {
			// Devuelve el elemento en la posición actual de 'head'.
			return elements[head];
		}		
		return null;
	}	
    // Método para verificar si la cola está vacía.
	@Override
	public boolean isEmpty() {
		return head > tail;
	}    
	// Método para verificar si la cola está completamente llena.	
	public boolean isFull() {
		return tail == MAX_SIZE -1;
	}	
}
