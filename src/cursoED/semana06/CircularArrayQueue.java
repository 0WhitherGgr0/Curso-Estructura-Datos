package cursoED.semana06;

public class CircularArrayQueue<E> implements Queue<E> {
    private static final int DEFAULT_MAX_SIZE = 100;
    private final int MAX_SIZE;
    private int head; 
    private int tail; 
    private Object[] elements;

    public CircularArrayQueue() {
        this(DEFAULT_MAX_SIZE);
    }

    public CircularArrayQueue(int maxSize) {

        MAX_SIZE = maxSize + 1;
        head = 0;
        tail = MAX_SIZE - 1; 
        elements = new Object[MAX_SIZE];
    }
    
    
    private int nextIndex(int currentIndex) {
    
        return (currentIndex + 1) % MAX_SIZE;
    }

    
    @Override
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException("Cannot add null to the queue"); // No permite elementos nulos.
        if (!isFull()) {
            tail = nextIndex(tail);
            elements[tail] = e;
            return true; 
        } else {
            return false; 
        }
    }

    
    @Override
    public E poll() {
        if (!isEmpty()) {
            E element = (E) elements[head];
            elements[head] = null;  
            head = nextIndex(head); 
            return element; 
        }
        return null; 
    }
    
    @Override
    public E peek() {
        if (!isEmpty()) {
            return (E) elements[head];
        }
        return null;
    }

    
    @Override
    public boolean isEmpty() {
    
        return nextIndex(tail) == head;
    }

    
    public boolean isFull() {
    
        return nextIndex(nextIndex(tail)) == head;
    }

    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]"; 
        }
        StringBuilder sb = new StringBuilder(); 
        sb.append('[');
        int i = head;
        while (i != tail) { 
            sb.append(elements[i]).append(", ");
            i = nextIndex(i);
        }
        sb.append(elements[tail]).append(']');
        return sb.toString(); 
    }
}
