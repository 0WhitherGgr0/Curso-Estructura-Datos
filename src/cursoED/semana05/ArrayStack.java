package cursoED.semana05;

public class ArrayStack<E> implements Stack<E> {

		private static final int DEFAULT_MAX_SIZE = 10000;
	    private final int MAX_SIZE;
	    private int head;
	    private E[] data;

	    public ArrayStack(final int maxSize) {
	        MAX_SIZE = maxSize;
	        head = -1;
	        data = (E[]) new Object[MAX_SIZE];
	    }

	    public ArrayStack() {
	        this(DEFAULT_MAX_SIZE);
	    }

	    @Override
	    public void push(E e) {
	        if (head >= MAX_SIZE - 1) {
	            throw new RuntimeException("Desbordamiento de pila");
	        }
	        head++;
	        data[head] = e;
	    }

	    @Override
	    public E pop() {
	        if (empty()) {
	            throw new RuntimeException("Desbordamiento negativo de pila");
	        }
	        E result = data[head];
	        data[head] = null; // Ayuda al recolector de basura
	        head--;
	        return result;
	    }

	    @Override
	    public E peek() {
	        if (empty()) {
	            throw new RuntimeException("Pila vacía");
	        }
	        return data[head];
	    }

	    @Override
	    public boolean empty() {
	        return head == -1;
	    }

	    @Override
	    public String toString() {
	        if (empty()) {
	            return "[]";
	        }
	        StringBuilder sb = new StringBuilder();
	        sb.append("[");
	        for (int i = head; i > 0; i--) {
	            sb.append(data[i]).append(", ");
	        }
	        sb.append(data[0]).append("]");
	        return sb.toString();
	    }
	

}
