package cursoED.semana06;

import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Deque<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int size;
    private int front;
    private int rear;

    public ArrayDeque() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayDeque(int numElements) {
        array = (E[]) new Object[numElements];
        size = 0;
        front = 0;
        rear = -1;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            E[] newArray = (E[]) new Object[array.length * 2];
            int index = 0;
            for (int i = front; i <= rear; i++) {
                newArray[index++] = array[i % array.length];
            }
            array = newArray;
            front = 0;
            rear = index - 1;
        }
    }

    @Override
    public void addFirst(E e) {
        ensureCapacity();
        if (front == 0) {
            front = array.length - 1;
        } else {
            front--;
        }
        array[front] = e;
        size++;
    }

    @Override
    public void addLast(E e) {
        ensureCapacity();
        if (rear == array.length - 1) {
            rear = 0;
        } else {
            rear++;
        }
        array[rear] = e;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        E element = array[front];
        array[front] = null;
        if (front == rear) {
            front = 0;
            rear = -1;
        } else {
            front = (front + 1) % array.length;
        }
        size--;
        return element;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        E element = array[rear];
        array[rear] = null;
        if (front == rear) {
            front = 0;
            rear = -1;
        } else {
            rear = (rear - 1 + array.length) % array.length;
        }
        size--;
        return element;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return array[front];
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return array[rear];
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
        return getFirst();
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return getLast();
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
    public boolean isEmpty() {
        return size == 0;
    }

	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}
}
