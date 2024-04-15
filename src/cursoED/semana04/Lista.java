package cursoED.semana04;

public interface Lista<E> {
	int tamanyo();
	boolean esVacio();
	boolean contiene(Object o);
	void agregar(E e);
	void agregar(int index, E element);
	boolean remover(Object o);
	E remover(int index);
	void limpiar();
	E get(int index);
	E set(int index, E element);
	int indiceDe(Object o);
}
