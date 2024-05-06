package cursoED.semana07.heap;

import cursoED.semana07.comun.PriorityQueue;

public class HeapPriorityQueue<E> implements PriorityQueue<E> {
	private Heap<E> heap;

	HeapPriorityQueue() {
		heap = new Heap<>();
	}

	@Override
	public boolean isEmpty() {
		return heap.isEmpty();
	}

	@Override
	public boolean offer(E e) {
		if (e == null)
			throw new NullPointerException();
		heap.insert(e);
		
		return true;
	}

	@Override
	public E poll() {
		try {
			return heap.remove();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public E peek() {
		try {
			return heap.element();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String toString() {
		return heap.toString();
	}
}
