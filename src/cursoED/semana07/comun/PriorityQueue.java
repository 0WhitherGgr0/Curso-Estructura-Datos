package cursoED.semana07.comun;

public interface PriorityQueue<E> {
	boolean isEmpty();

	boolean offer(E e);

	E poll(); // Extraer el elemento con la mayor prioridad.

	E peek(); // Devuelve el elemento con la mayor prioridad.
}