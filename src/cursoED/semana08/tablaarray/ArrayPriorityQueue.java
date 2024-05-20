package cursoED.semana08.tablaarray;

import java.util.ArrayDeque;
import java.util.Queue;

import cursoED.semana07.comun.PriorityQueue;

public class ArrayPriorityQueue<E extends WithPriority> implements PriorityQueue<E> {
	private Queue<E>[] table;// Cada posicion del arreglo representa una prioridad especifica
	private int numberOfPriority;//El numero maximo de prioridades permitidas.

	public ArrayPriorityQueue(int numberOfPriority) {
		if (numberOfPriority < 0) {
			throw new RuntimeException("Error en prioridad: " + numberOfPriority);
		}
		this.numberOfPriority = numberOfPriority;
		table = new Queue[numberOfPriority + 1];
		for (int i = 0; i < table.length; i++) {
			table[i] = new ArrayDeque<>();// Inicializa cada cola con una instancia de ArrayDeque.
		}
	}

	@Override
	public boolean isEmpty() {
		int i = 0;
		while (table[i].isEmpty() && i < numberOfPriority) {
			i++;
		}
		return table[i].isEmpty();
	}

	@Override
	public boolean offer(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		int priority = e.getPriority();
		if (priority >= 0 && priority <= numberOfPriority) {
			return table[priority].offer(e);
		} else {
			return false;
		}
	}

	@Override
	public E poll() {
		int i = 0;
		int index = -1;
		// búsqueda de la primera cola no vacía
		do {
			if (!table[i].isEmpty()) {//verifica si la cola en el índice i no está vacía.
				index = i; //Guarda el indice 
				break;
			} else
				i++;

		} while (i <= numberOfPriority);
		if (index != -1)
			return table[index].poll(); //que se encontró una cola no vacía
		else
			return null;
	}

	@Override
	public E peek() {
		int i = 0;
		int index = -1;
		// búsqueda de la primera cola no vacía
		do {
			if (!table[i].isEmpty()) {
				index = i;
				break;
			} else
				i++;

		} while (i <= numberOfPriority);
		if (index != -1)
			return table[index].peek();
		else
			return null;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < table.length; i++) {
		result += table[i];
		}
		return result;
	}
}
