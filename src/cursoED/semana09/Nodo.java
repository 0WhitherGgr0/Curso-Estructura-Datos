package cursoED.semana09;

public class Nodo<T> {
	private T dato;
	private Nodo<T> izdo;
	private Nodo<T> dcho;

	public Nodo(Nodo<T> izdo, T dato, Nodo<T> dcho) {
		this.dato = dato;
		this.izdo = izdo;
		this.dcho = dcho;
	}

	public T getDato() {
		return dato;
	}

	public Nodo<T> getIzdo() {
		return izdo;
	}

	public Nodo<T> getDcho() {
		return dcho;
	}

	public void setIzdo(Nodo<T> izdo) {
		this.izdo = izdo;
	}

	public void setDcho(Nodo<T> dcho) {
		this.dcho = dcho;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
}