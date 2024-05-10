package cursoED.semana06;

public interface Deque<E> {
	boolean offerFirst(E e);//addFirst(e)
	boolean offerLast(E e); // addLast(e)
	E pollFirst(); //removeFirst()
	E pollLast(); //removeLast()
	E peekFirst(); //getFirst()
	E peekLast(); //getLast()
	boolean isEmpty();
}
