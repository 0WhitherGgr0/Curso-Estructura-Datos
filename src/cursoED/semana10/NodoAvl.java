package cursoED.semana10;

import cursoED.semana09.Nodo;

public class NodoAvl<T> extends Nodo<T> {
	int fe;

	public NodoAvl(Nodo<T> izdo, T dato, Nodo<T> dcho) {
		super(izdo, dato, dcho);
		fe = 0;
	}

}
