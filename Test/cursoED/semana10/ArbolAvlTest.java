package cursoED.semana10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArbolAvlTest {
	private ArbolAvl<Integer> arbol;

	@BeforeEach
	void setUp() {
		arbol = new ArbolAvl<>();
		// Insertar valores para la prueba
		arbol.insertar(50);
		arbol.insertar(30);
		arbol.insertar(70);
		arbol.insertar(20);
		arbol.insertar(40);
		arbol.insertar(60);
		arbol.insertar(80);
	}

	@Test
	void testInsertarElementoRaiz() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(100);
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(100, raiz.getDato());
		assertEquals(0, raiz.fe);
		asegurarQueEsUnaHoja(raiz);
		// Estructura del árbol:
		// 100
		// (es una hoja, sin hijos)
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
		// Estructura del árbol:
		// 100
		// (es una hoja, sin hijos)
	}

	@Test
	void testInsertarSeisElementoPorLaDerecha() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(100);
		a.insertar(120);
		a.insertar(140);
		a.insertar(160);
		a.insertar(180);
		a.insertar(190);

		// Estructura esperada del árbol después de las inserciones:
		// 160
		// / \
		// 120 180
		// / \ \
		// 100 140 190

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
	// *****************************************

	@Test
	void testInsertarSeisElementoPorLaIzquierda() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		Logical h = new Logical(false); // Creamos un Logical para seguir la altura del árbol
		a.insertar(190);
		a.insertar(180);
		a.insertar(160);
		a.insertar(140);
		a.insertar(120);
		a.insertar(100);
		// Estructura esperada del árbol después de las inserciones:
		// 160
		// / \
		// 120 180
		// / \ \
		// 100 140 190

	}

	@Test
	void testInsercionSubarbolIzquierdoRamaIzquierdaRotacionII() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		Logical h = new Logical(false);
		a.insertar(3);
		a.insertar(2);
		a.insertar(1);
		// Estructura esperada del árbol después de las inserciones:
		// 2
		// / \
		// 1 3

		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(2, raiz.getDato());
		assertEquals(0, raiz.fe);

		NodoAvl<Integer> hijoIzquierdo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(1, hijoIzquierdo.getDato());
		assertEquals(0, hijoIzquierdo.fe);

		NodoAvl<Integer> hijoDerecho = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(3, hijoDerecho.getDato());
		assertEquals(0, hijoDerecho.fe);
	}

	@Test
	void testInsercionSubarbolIzquierdoRamaIzquierdaRotacionDD() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		Logical h = new Logical(false);
		a.insertar(3);
		a.insertar(5);
		a.insertar(7);

		// Estructura esperada del árbol después de las inserciones:
		// 5
		// / \
		// 3 7
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(5, raiz.getDato());
		assertEquals(0, raiz.fe);

		NodoAvl<Integer> hijoIzquierdo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(3, hijoIzquierdo.getDato());
		assertEquals(0, hijoIzquierdo.fe);

		NodoAvl<Integer> hijoDerecho = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(7, hijoDerecho.getDato());
		assertEquals(0, hijoDerecho.fe);
	}

	@Test
	void testRotacionIICasoElse() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		Logical h = new Logical(false);

		a.insertar(50);
		a.insertar(30);
		a.insertar(70);
		a.insertar(65);
		a.insertar(20);
		a.insertar(22);

		// Estructura esperada del árbol después de las inserciones:
		// 50
		// / \
		// 22 70
		// / \ /
		// 20 30 65

		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(50, raiz.getDato());
		assertEquals(0, raiz.fe);

		NodoAvl<Integer> hijoIzquierdo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(22, hijoIzquierdo.getDato());
		assertEquals(0, hijoIzquierdo.fe);

		NodoAvl<Integer> hijoDerecho = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(70, hijoDerecho.getDato());
		assertEquals(-1, hijoDerecho.fe);

		NodoAvl<Integer> nietoIzquierdoIzquierdo = (NodoAvl<Integer>) hijoIzquierdo.getIzdo();
		assertEquals(20, nietoIzquierdoIzquierdo.getDato());
		assertEquals(0, nietoIzquierdoIzquierdo.fe);
		asegurarQueEsUnaHoja(nietoIzquierdoIzquierdo);

		NodoAvl<Integer> nietoIzquierdoDerecho = (NodoAvl<Integer>) hijoIzquierdo.getDcho();
		assertEquals(30, nietoIzquierdoDerecho.getDato());
		assertEquals(0, nietoIzquierdoDerecho.fe);
		asegurarQueEsUnaHoja(nietoIzquierdoDerecho);

		NodoAvl<Integer> nietoDerechoIzquierdo = (NodoAvl<Integer>) hijoDerecho.getIzdo();
		assertEquals(65, nietoDerechoIzquierdo.getDato());
		assertEquals(0, nietoDerechoIzquierdo.fe);
		asegurarQueEsUnaHoja(nietoDerechoIzquierdo);
	}

	@Test
	void testRotacionDDCasoElse() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		Logical h = new Logical(false);

		a.insertar(50);
		a.insertar(30);
		a.insertar(70);
		a.insertar(60);
		a.insertar(80);
		a.insertar(65);
		// Estructura esperada del árbol después de las inserciones:
		// 50
		// / \
		// 30 65
		// / \
		// 60 70
		// \
		// 80

	}

	// *****************************************
	@Test
	void testInsercionSubarbolIzquierdoRamaIzquierdaRotacionIDFeCero() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		Logical h = new Logical(false);
		a.insertar(10);
		a.insertar(5);
		a.insertar(7);

		// Estructura esperada del árbol después de las inserciones:
		// 7
		// / \
		// 5 10
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(7, raiz.getDato());
		assertEquals(0, raiz.fe);

		NodoAvl<Integer> hijoIzquierdo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(5, hijoIzquierdo.getDato());
		assertEquals(0, hijoIzquierdo.fe);

		NodoAvl<Integer> hijoDerecho = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(10, hijoDerecho.getDato());
		assertEquals(0, hijoDerecho.fe);
	}

	@Test
	void testInsercionRotacionIDFeMenos1() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		Logical h = new Logical(false);
		a.insertar(40);
		a.insertar(80);
		a.insertar(20);
		a.insertar(10);
		a.insertar(30);
		a.insertar(50);
		a.insertar(90);
		a.insertar(45);
		a.insertar(75);
		a.insertar(60);

		// Estructura esperada del árbol después de las inserciones:
		// 40
		// / \
		// 20 75
		// / \ / \
		// 10 30 50 80
		// / \ \
		// 45 60 90

		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(40, raiz.getDato());
		assertEquals(1, raiz.fe);

		NodoAvl<Integer> hijoIzquierdo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(20, hijoIzquierdo.getDato());
		assertEquals(0, hijoIzquierdo.fe);

		NodoAvl<Integer> hijoDerecho = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(75, hijoDerecho.getDato());
		assertEquals(0, hijoDerecho.fe);

	}

	@Test
	void testInsercionRotacionIDFe1() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		Logical h = new Logical(false);
		a.insertar(40);
		a.insertar(80);
		a.insertar(20);
		a.insertar(10);
		a.insertar(30);
		a.insertar(50);
		a.insertar(90);
		a.insertar(45);
		a.insertar(75);
		a.insertar(76);

		// Estructura esperada del árbol después de las inserciones:
		// 40
		// / \
		// 20 75
		// / \ / \
		// 10 30 50 80
		// / \ \
		// 45 60 90
		// \
		// 76

		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(40, raiz.getDato());
		assertEquals(1, raiz.fe);

		NodoAvl<Integer> hijoIzquierdo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(20, hijoIzquierdo.getDato());
		assertEquals(0, hijoIzquierdo.fe);

		NodoAvl<Integer> hijoDerecho = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(75, hijoDerecho.getDato());
		assertEquals(0, hijoDerecho.fe);

	}
	/// ***************************************************

	@Test
	void testInsercionSubarbolIzquierdoRamaIzquierdaRotacionDIFeCero() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		Logical h = new Logical(false);
		a.insertar(10);
		a.insertar(15);
		a.insertar(13);
		// Estructura esperada del árbol después de las inserciones:
		// 13
		// / \
		// 10 15
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(13, raiz.getDato());
		assertEquals(0, raiz.fe);

		NodoAvl<Integer> hijoIzquierdo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(10, hijoIzquierdo.getDato());
		assertEquals(0, hijoIzquierdo.fe);

		NodoAvl<Integer> hijoDerecho = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(15, hijoDerecho.getDato());
		assertEquals(0, hijoDerecho.fe);
	}

	@Test
	void testInsercionRotacionDIFe1() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		Logical h = new Logical(false);

		a.insertar(50);
		a.insertar(30);
		a.insertar(70);
		a.insertar(60);
		a.insertar(80);
		a.insertar(65); // Esta inserción provoca rotación DI en 70

		// Estructura esperada del árbol después de las inserciones:
		// 60
		// / \
		// 50 70
		// / \ / \
		// 30 65 60 80

	}

	@Test
	void testInsercionRotacionDIFeMenos1() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		Logical h = new Logical(false);

		// Insertar nodos en el orden que provoque la rotación DI con n2.fe == -1
		a.insertar(50);
		a.insertar(30);
		a.insertar(70);
		a.insertar(60);
		a.insertar(80);
		a.insertar(55); // Esta inserción provoca rotación DI en 70

		// Estructura esperada del árbol después de las inserciones:
		// 60
		// / \
		// 50 70
		// / \ / \
		// 30 55 60 80

		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(60, raiz.getDato());
		assertEquals(0, raiz.fe);

		NodoAvl<Integer> hijoIzquierdo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(50, hijoIzquierdo.getDato());
		assertEquals(0, hijoIzquierdo.fe);

		NodoAvl<Integer> hijoDerecho = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(70, hijoDerecho.getDato());
		assertEquals(1, hijoDerecho.fe);

		NodoAvl<Integer> nietoDerecho = (NodoAvl<Integer>) hijoDerecho.getDcho();
		assertEquals(80, nietoDerecho.getDato());
		assertEquals(0, nietoDerecho.fe);

	}

	/// ***************************************************

	@Test
	void testInsercionSubarbolIzquierdoRamaIzquierdaArbolMasGrandeRotacionII() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		Logical h = new Logical(false);
		a.insertar(29);
		a.insertar(19);
		a.insertar(50);
		a.insertar(60);
		a.insertar(12);
		a.insertar(22);
		a.insertar(8);
		a.insertar(17);
		a.insertar(5);

		// Estructura esperada del árbol después de las inserciones:
		// 29
		// / \
		// 12 50
		// / \ \
		// 8 19 60
		// / / \
		// 5 17 22

		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(29, raiz.getDato());
		assertEquals(-1, raiz.fe);

		NodoAvl<Integer> hijoIzquierdo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(12, hijoIzquierdo.getDato());
		assertEquals(0, hijoIzquierdo.fe);

		NodoAvl<Integer> hijoDerecho = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(50, hijoDerecho.getDato());
		assertEquals(1, hijoDerecho.fe);
	}

	@Test
	void testEliminarNodoConUnHijo() throws Exception {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(50);
		a.insertar(30);
		a.insertar(70);
		a.eliminar(30);

		// Estructura esperada del árbol después de eliminar el nodo con un hijo 30:
		// 50
		// \
		// 70

		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(50, raiz.getDato());
		assertEquals(1, raiz.fe);

		NodoAvl<Integer> hijoDerecho = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(70, hijoDerecho.getDato());
		assertEquals(0, hijoDerecho.fe);
		asegurarQueEsUnaHoja(hijoDerecho);

		assertNull(raiz.getIzdo());
	}

	@Test
	void testEliminarNodoEnArbolVacio() {
		ArbolAvl<Integer> arbolVacio = new ArbolAvl<>();
		Exception exception = assertThrows(Exception.class, () -> arbolVacio.eliminar(10));

	}
	@Test
	void testEliminarNodoInexistente() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		Exception exception = assertThrows(Exception.class, () -> a.eliminar(90));
	}

	@Test
	void testEliminarHoja() throws Exception {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(20);
		a.eliminar(20);
		assertNull(a.getRaiz());
	}

	@Test
	void testEliminarNodoHoja() throws Exception {
		arbol.eliminar(20); // Nodo hoja
		assertThrows(Exception.class, () -> arbol.eliminar(20));
	}

	@Test
	void testEliminarNodoConDosHijos() throws Exception {
		arbol.eliminar(50); // Nodo 50 tiene dos hijos, 30 y 70
		assertThrows(Exception.class, () -> arbol.eliminar(50));
	}
	 @Test
	    void testEliminarNodoConHijoDerechoUnico() throws Exception {
	        arbol.insertar(90); // Insertar un nodo para que 80 tenga un hijo derecho
	        arbol.eliminar(80); // Nodo 80 tiene solo un hijo derecho, que es 90
	        assertThrows(Exception.class, () -> arbol.eliminar(80));
	    }

	    @Test
	    void testEliminarNodoMayorQueRaiz() throws Exception {
	        arbol.eliminar(70); // Nodo 70 está en la rama derecha del árbol
	        assertThrows(Exception.class, () -> arbol.eliminar(70));
	    }

	    @Test
	    void testEliminarNodoConDosHijosConReemplazo() throws Exception {
	        arbol.eliminar(70); // Nodo 70 tiene dos hijos, 60 y 80
	        arbol.eliminar(50); // Nodo 50 tiene dos hijos, 30 y el reemplazado 60
	        assertThrows(Exception.class, () -> arbol.eliminar(50));
	    }
	    @Test
	    void testEliminarNodoConHijoIzquierdoUnico() throws Exception {
	        arbol.insertar(35); // Insertar un nodo para que 40 tenga un hijo izquierdo
	        arbol.eliminar(40); // Nodo 40 tiene solo un hijo izquierdo, que es 35
	        assertThrows(Exception.class, () ->  arbol.eliminar(40));    
	    }
	    @Test
	    void testEquilibrar2RotacionII() throws Exception {
	        ArbolAvl<Integer> arbol = new ArbolAvl<>();
	        arbol.insertar(20); // Nodo raíz
	        arbol.insertar(30); // Hijo derecho
	        arbol.insertar(10); // Hijo izquierdo
	        arbol.insertar(5);  // Nieto izquierdo

	        // Estructura esperada del árbol después de las inserciones:
	        //     20
	        //    /  \
	        //  10   30
	        // /
	        // 5

	        arbol.eliminar(30); // Eliminar el nodo 30 del árbol

	        // Estructura esperada del árbol después de la eliminación:
	        //     10
	        //    /  \
	        //   5   20

	        NodoAvl<Integer> raiz = arbol.getRaiz();
	        assertEquals(10, raiz.getDato());
	        assertEquals(0, raiz.fe);

	        NodoAvl<Integer> hijoIzquierdo = (NodoAvl<Integer>) raiz.getIzdo();
	        assertEquals(5, hijoIzquierdo.getDato());
	        assertEquals(0, hijoIzquierdo.fe);

	        NodoAvl<Integer> hijoDerecho = (NodoAvl<Integer>) raiz.getDcho();
	        assertEquals(20, hijoDerecho.getDato());
	        assertEquals(0, hijoDerecho.fe);
	    }

	    @Test
	    void testEquilibrar1RotacionDI() throws Exception {
	        ArbolAvl<Integer> arbol = new ArbolAvl<>();
	        arbol.insertar(20); // Nodo raíz
	        arbol.insertar(10); // Hijo izquierdo
	        arbol.insertar(30); // Hijo derecho
	        arbol.insertar(25); // Nieto derecho

	        // Estructura esperada del árbol después de las inserciones:
	        //     20
	        //    /  \
	        //  10   30
	        //        \
	        //        25

	        arbol.eliminar(10); // Eliminar el nodo 10 del árbol

	        // Estructura esperada del árbol después de la eliminación:
	        //     25
	        //    /  \
	        //   20  30

	        NodoAvl<Integer> raiz = arbol.getRaiz();
	        assertEquals(25, raiz.getDato());
	        assertEquals(0, raiz.fe);

	        NodoAvl<Integer> hijoIzquierdo = (NodoAvl<Integer>) raiz.getIzdo();
	        assertEquals(20, hijoIzquierdo.getDato());
	        assertEquals(0, hijoIzquierdo.fe);

	        NodoAvl<Integer> hijoDerecho = (NodoAvl<Integer>) raiz.getDcho();
	        assertEquals(30, hijoDerecho.getDato());
	        assertEquals(0, hijoDerecho.fe);
	    }

	    @Test
	    void testEquilibrar2RotacionID() throws Exception {
	    	ArbolAvl<Integer> arbol = new ArbolAvl<>();
	        arbol.insertar(20); // Nodo raíz
	        arbol.insertar(10); // Hijo izquierdo
	        arbol.insertar(30); // Hijo derecho
	        arbol.insertar(15); // Nieto derecho

	        // Estructura esperada del árbol después de las inserciones:
	        //     20
	        //    /  \
	        //  10   30
	        //    \
	        //    15

	        arbol.eliminar(30); // Eliminar el nodo 30 del árbol

	        // Estructura esperada del árbol después de la eliminación:
	        //     15
	        //    /  \
	        //   10  20

	        NodoAvl<Integer> raiz = arbol.getRaiz();
	        assertEquals(15, raiz.getDato());
	        assertEquals(0, raiz.fe);

	        NodoAvl<Integer> hijoIzquierdo = (NodoAvl<Integer>) raiz.getIzdo();
	        assertEquals(10, hijoIzquierdo.getDato());
	        assertEquals(0, hijoIzquierdo.fe);

	        NodoAvl<Integer> hijoDerecho = (NodoAvl<Integer>) raiz.getDcho();
	        assertEquals(20, hijoDerecho.getDato());
	        assertEquals(0, hijoDerecho.fe);
	    
	    }
	    
	    @Test
	    void testRotacionDDDespuesDeEliminar() throws Exception {
	        ArbolAvl<Integer> arbol = new ArbolAvl<>();
	        arbol.insertar(20); // Nodo raíz
	        arbol.insertar(10); // Hijo izquierdo
	        arbol.insertar(30); // Hijo derecho
	        arbol.insertar(25);  // Nieto derecho

	        // Estructura esperada del árbol después de las inserciones:
	        //      20
	        //     /  \
	        //   10   30
	        //       /
	        //     25

	        arbol.eliminar(30); // Eliminar el nodo 30 del árbol

	        // Estructura esperada del árbol después de la eliminación:
	        //     20
	        //    /  \
	        //  10   25

	        NodoAvl<Integer> raiz = arbol.getRaiz();
	        assertEquals(20, raiz.getDato());
	        assertEquals(0, raiz.fe);

	        NodoAvl<Integer> hijoIzquierdo = (NodoAvl<Integer>) raiz.getIzdo();
	        assertEquals(10, hijoIzquierdo.getDato());
	        assertEquals(0, hijoIzquierdo.fe);

	        NodoAvl<Integer> hijoDerecho = (NodoAvl<Integer>) raiz.getDcho();
	        assertEquals(25, hijoDerecho.getDato());
	        assertEquals(0, hijoDerecho.fe);
	    }





}