package cursoED.semana10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArbolAvlTest {
	@Test
	void testInsertarElementoRaiz() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(100);
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(100, raiz.getDato());
		assertEquals(0, raiz.fe);
		asegurarQueEsUnaHoja(raiz);
	}

	private void asegurarQueEsUnaHoja(NodoAvl<Integer> nodo) {
		assertNull(nodo.getIzdo());
		assertNull(nodo.getDcho());
	}

	@Test
	void testInsertarClaveRepetida() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(100);
		assertThrows(RuntimeException.class, () -> a.insertar(100));
	}

//etc ...
	@Test
	void testInsertarSeisElementoPorLaDerecha() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(100);
		a.insertar(120);
		a.insertar(140);
		a.insertar(160);
		a.insertar(180);
		a.insertar(190);

//Resultara:
// 160
// / \
// 120 180
// / \ \
//100 140 190

		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(160, raiz.getDato());
		assertEquals(0, raiz.fe);
		NodoAvl<Integer> nodo = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(180, nodo.getDato());
		assertEquals(1, nodo.fe);
		assertNull(nodo.getIzdo());
		nodo = (NodoAvl<Integer>) nodo.getDcho();
		assertEquals(190, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
		NodoAvl<Integer> nodo120 = (NodoAvl<Integer>) raiz.getIzdo();

		assertEquals(120, nodo120.getDato());
		assertEquals(0, nodo120.fe);

		nodo = (NodoAvl<Integer>) nodo120.getIzdo();
		assertEquals(100, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
		nodo = (NodoAvl<Integer>) nodo120.getDcho();
		assertEquals(140, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
	}
}