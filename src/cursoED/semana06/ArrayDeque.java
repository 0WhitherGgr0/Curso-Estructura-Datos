package cursoED.semana06;

import java.util.NoSuchElementException;
public class ArrayDeque<E> implements Deque<E> {
    private E[] elements;
    private int head;
    private int tail;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        elements = (E[]) new Object[16];
        head = 0;
        tail = 0;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public ArrayDeque(int numElements) {
        elements = (E[]) new Object[numElements];
        head = 0;
        tail = 0;
        size = 0;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            @SuppressWarnings("unchecked")
            E[] newElements = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[(head + i) % elements.length];
            }
            elements = newElements;
            head = 0;
            tail = size;
        }
    }

    @Override
    public boolean offer(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(E e) {
        ensureCapacity();
        head = (head - 1 + elements.length) % elements.length;
        elements[head] = e;
        size++;
    }

    @Override
    public void addLast(E e) {
        ensureCapacity();
        elements[tail] = e;
        tail = (tail + 1) % elements.length;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return element;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        tail = (tail - 1 + elements.length) % elements.length;
        E element = elements[tail];
        elements[tail] = null;
        size--;
        return element;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements[head];
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements[(tail - 1 + elements.length) % elements.length];
    }

    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return elements[head];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return elements[(tail - 1 + elements.length) % elements.length];
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(elements[(head + i) % elements.length]);
        }
        sb.append("]");
        return sb.toString();
    }
}
