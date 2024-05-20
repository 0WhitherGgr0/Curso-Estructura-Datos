package cursoED.semana09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArbolBinarioBusquedaTest {
	ArbolBinarioBusqueda<Integer> abb;

	@BeforeEach
	void init() {
// Inicializa el arbol de esta forma:
//    		25
//		   /  \
//		  10   36
//		   \   / \
//		   15 30  64
		Nodo<Integer> raiz;
		Nodo<Integer> izq, dcho, centro1, centro2;
		dcho = new Nodo<>(null, 15, null);
		centro1 = new Nodo<>(null, 10, dcho);
		izq = new Nodo<>(null, 30, null);
		dcho = new Nodo<>(null, 64, null);
		centro2 = new Nodo<>(izq, 36, dcho);
		raiz = new Nodo<>(centro1, 25, centro2);
		abb = new ArbolBinarioBusqueda<>(raiz);
	}

	/**
	 * Tarea, crear los metodos preordenStr, inordenStr, postordenStr
	 * y usarlos en los asserttions, de todos los tests, en lugar de imprimir en la pantalla
	 */
	@Test
	void testInit() {
		//abb.preorden(); // 25 10 15 36 30 64
		assertEquals("25, 10, 15, 36, 30, 64", abb.preordenStr()); 
		//abb.inorden(); // 10 15 25 30 36 64
		assertEquals("10, 15, 25, 30, 36, 64", abb.inordenStr());
		//abb.postorden(); // 15 10 30 64 36 25
		assertEquals("15, 10, 30, 64, 36, 25", abb.postordenStr());
	}

	@Test
	void testBuscarEnUnArbolVacio() {
		abb = new ArbolBinarioBusqueda<>();
		assertNull(abb.buscar(25));
	}

	@Test
	void testBuscar() {
		Nodo<Integer> n = abb.buscar(25);
		assertEquals(25, n.getDato());
		n = abb.buscar(10);
		assertEquals(10, n.getDato());
		assertEquals(15, abb.buscar(15).getDato());
		assertEquals(36, abb.buscar(36).getDato());
		assertEquals(30, abb.buscar(30).getDato());
		assertEquals(64, abb.buscar(64).getDato());
		assertNull(abb.buscar(80));
	}

	@Test
	void testInsertarUnNodoQueResultaraEnUnaHojaIzquierda() {
		abb.insertar(8);
		assertEquals(8, abb.buscar(8).getDato());
		abb.inorden(); //8 10 15 25 30 36 64 
		System.out.println();
	}
	@Test
	void testInsertarUnNodoQueResultaraEnUnaHojaDerecha() {
		abb.insertar(16);
		assertEquals(16, abb.buscar(16).getDato());
		System.out.println("ArbolBinarioBusquedaTest.testInsertarUnNodoQueResultaraEnUnaHojaDerecha()");
		abb.inorden(); //10 15 16 25 30 36 64 
		System.out.println();
//Resultara:	
//		25
//	   /  \
//	  10   36
//	   \   / \
//	   15 30  64
//		\
//		16
	}
	@Test
	void testInsertarUnNodoExistente() {
		assertThrows(RuntimeException.class, ()-> abb.insertar(10));
	}
	
	@Test
	void testEliminarUnValorNoExistente() {
		assertThrows(RuntimeException.class, () -> abb.eliminar(8));
	} 
	
	//MODIFICAR EL TEST PARA QUE LOS VALORES SEAN RECIBIDOS
	@Test
	void testEliminarHojas() {
		abb.eliminar(15);
		abb.eliminar(30);
		abb.eliminar(64);
		//ASSERTEQUALS (ESPERADO, ABB.INORDESTR)
		abb.inorden();
		System.out.println();
	}
	//MODIFICAR EL TEST PARA QUE LOS VALORES SEAN RECIBIDOS
	@Test
	void testEliminarNodoQueTieneUnSoloHijoDerecho() {
		abb.eliminar(10);
		//ASSERTEQUALS (ESPERADO, ABB.INORDESTR)
		abb.inorden();
		System.out.println();
//resultara:
//		25
//	   /  \
//	  15   36
//	       / \
//	      30  64
	}
	@Test
	void testEliminarNodoQueTieneUnSoloHijoIzquierdo() {
		abb.eliminar(64);
		abb.eliminar(36);
		abb.inorden();
		System.out.println();
//inicialmente:
//		25
//	   /  \
//	  10   36
//	   \   / \
//	   15 30  64
//Resultara:
//		25
//	   /  \
//	  10   30
//	   \  
//	   15   

	}

	@Test
	void testEliminarNodoQueTieneDosHijos() {
		abb.insertar(8);
		abb.eliminar(25);
		System.out.println("ArbolBinarioBusquedaTest.testEliminarNodoQueTieneDosHijos()");
		abb.inorden();
		System.out.println();
// Inicialmente:
//		25
//	   /  \
//	  10   36
//	  /\   / \
//	 8 15 30  64
// Resultara:
//		15
//	   /  \
//	  10   36
//	  /    / \
//	 8    30  64

	}

	@Test
	void testEliminarNodoQueTieneDosHijosQueSonHojas() {
		abb.eliminar(36);
		System.out.println("ArbolBinarioBusquedaTest.testEliminarNodoQueTieneDosHijosQueSonHojas()");
		abb.inorden();
		System.out.println();
// Inicialmente:
//		25
//	   /  \
//	  10   36
//	   \   / \
//	   15 30  64
// Resultara:
//		25
//	   /  \
//	  10   30
//	   \    \
//	   15   64

	}
	
	@Test
	void testEliminarNodoQueTieneDosHijosCuyoHijoMenoresTieneMultiplesDesendientes() {
		abb.insertar(28);
		abb.insertar(35);
		abb.insertar(33);
		abb.insertar(34);
		assertEquals(6, abb.altura());
		System.out.println("ArbolBinarioBusquedaTest.testEliminarNodoQueTieneDosHijosCuyoHijoMenoresTieneMultiplesDesendientes()");
		abb.inorden();
		System.out.println();
		abb.eliminar(36);
		abb.inorden();
		System.out.println();
		assertEquals(5, abb.altura());
		assertEquals(25, abb.getRaiz().getDato());
		Nodo<Integer> nodo = abb.getRaiz().getDcho();
		assertEquals(35, nodo.getDato());
		assertEquals(30, nodo.getIzdo().getDato());
		assertEquals(64, nodo.getDcho().getDato());
		assertEquals(28, nodo.getIzdo().getIzdo().getDato());
		assertEquals(33, nodo.getIzdo().getDcho().getDato());
		assertEquals(34, nodo.getIzdo().getDcho().getDcho().getDato());
		assertNull(nodo.getIzdo().getDcho().getIzdo());	
// Inicialmente (despues de los insertar):
//		25
//	   /  \
//	  10   36
//	   \   / \
//	   15 30  64
//		  /\
//		28 35
//		   /
//		  33
//		   \
//		   34
// Despues de eliminar 36:
//			25
//		   /  \
//		  10   35
//		   \   / \
//		   15 30  64
//			  /\
//			28 33
//			    \
//			    34

	}

	@Test
	void testAlturaArbolVacio() { 
		abb = new ArbolBinarioBusqueda<>();
		assertEquals(0, abb.altura());
	}
	@Test
	void testAlturaArbolDeAltura3() {
		assertEquals(3, abb.altura());
	}		
	@Test
	void testAlturaArbolDeAltura5() {
		abb.insertar(70);
		abb.insertar(80);
		assertEquals(5, abb.altura());
	}	
}
