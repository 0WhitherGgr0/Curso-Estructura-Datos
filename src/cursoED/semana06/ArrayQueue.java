package cursoED.semana06;
public class ArrayQueue<E> implements Queue<E> {
	private static final int DEFAULT_MAX_SIZE = 100;
	private final int MAX_SIZE;
	private int head;
	private int tail;
	private E[] elements;

	public ArrayQueue() {	
		this(DEFAULT_MAX_SIZE);		
	}	
 
	public ArrayQueue(int maxSize) {
		MAX_SIZE = maxSize;
		head = 0;
		tail = -1;
		elements = (E[])new Object[MAX_SIZE];
	}	
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
 
 	@Override
	public E poll() {
		if (!isEmpty()) {
			return elements[head++];
		}		
		return null;
	}
 	@Override
	public E peek() {
		if (!isEmpty()) {
			return elements[head];
		}		
		return null;
	}	
 	@Override
	public boolean isEmpty() {
		return head > tail;
	}    

 	public boolean isFull() { 
		return tail == MAX_SIZE -1;
	}	
}
