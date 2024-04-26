package cursoED.semana04;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListaEnlazadaSimpleTest {
	
    ListaEnlazadaSimple<Integer> lista = new ListaEnlazadaSimple<>();
    ListaEnlazadaSimple<String> otraLista = new ListaEnlazadaSimple<>();
    

    @Test
    void testRemover() {
        otraLista.agregar("Hola");
        otraLista.agregar("Mundo");
        otraLista.agregar(null); // Agregamos un elemento nulo a propósito
        otraLista.agregar("!");

        // Probamos remover un elemento existente en la lista
        assertTrue(otraLista.remover("Mundo")); 
        assertEquals("Lista(Hola, null, !)", otraLista.toString()); 

        // Probamos remover un elemento nulo
        assertTrue(otraLista.remover(null)); 
        assertEquals("Lista(Hola, !)", otraLista.toString());

        // Probamos remover un elemento que no está en la lista
        assertFalse(otraLista.remover("Java")); 
        assertEquals("Lista(Hola, !)", otraLista.toString()); 

        // Probamos remover un elemento que no es nulo
        assertTrue(otraLista.remover("!")); 
        assertEquals("Lista(Hola)", otraLista.toString()); 

        // Probamos remover un elemento que no es nulo y está en la lista
        assertTrue(otraLista.remover("Hola"));
        assertEquals("Lista()", otraLista.toString());
    }
    
    @Test
    void testToString() {
        assertEquals("Lista()", lista.toString());
        lista.agregar(1);
        assertEquals("Lista(1)", lista.toString());
        lista.agregar(2);
        lista.agregar(3);
        assertEquals("Lista(1, 2, 3)", lista.toString());
    }
    
    @Test
    void testTamayoConUnaListaVacia() {
    	assertEquals(0,lista.tamanyo());
    }
    @Test
    void testValidarAgregarIndice() {
        lista.agregar(12);
        lista.agregar(14);
        lista.agregar(16);
        //ValidarAgregarIndice
        assertThrows(IndexOutOfBoundsException.class, () -> lista.agregar(-1, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.agregar(10, 5));
        assertDoesNotThrow(() -> lista.agregar(lista.tamanyo(), 20));
    }

    @Test
    void testLinkearPrimeroyMedio() {
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(0, 99);     
        lista.agregar(2, 99);
        assertEquals(99, lista.get(0));

    }

    @Test
    void testTamayoConUnaListaConAlgunosElementoss() {
    	lista.agregar(12);
    	lista.agregar(0,12);
    }

    @Test
    void testEsVacioLaListaInicialEsVacio() {
    	assertTrue(lista.esVacio());
    	lista.agregar(0, null);
    }
    
    @Test
    void testEsVacioLaListaConAlgunosElementosNoEsVacio() {
    	assertEquals(0,lista.tamanyo());
    }
    
	@Test
	void testTamanyo() {
    	lista.agregar(12);
    	lista.agregar(14);
    	lista.agregar(16);
    	assertEquals(3,lista.tamanyo());
	}

	@Test
	void testEsVacio() {
		assertTrue(lista.esVacio());
		lista.agregar(5);
		assertFalse(lista.esVacio());
	}

	@Test
	void testContiene() {
	    lista.agregar(5);
	    lista.agregar(10);
	    lista.agregar(15);

	    assertTrue(lista.contiene(10));
	    assertTrue(lista.contiene(5));
	    assertTrue(lista.contiene(15));
	    assertFalse(lista.contiene(20)); // Elemento no presente en la lista

	    ListaEnlazadaSimple<Integer> listaVacia = new ListaEnlazadaSimple<>();
	    assertFalse(listaVacia.contiene(5)); // La lista está vacía
	    listaVacia.agregar(null);
	    assertTrue(listaVacia.contiene(null)); // Único elemento en la lista es nulo
	}

	@Test
	void testAgregarE() {
		assertTrue(lista.esVacio());
		lista.agregar(5);
		assertFalse(lista.esVacio());
		assertEquals(1, lista.tamanyo());
	}

	@Test
	void testGet() {
		lista.agregar(5);
		lista.agregar(10);
		lista.agregar(15);
		assertEquals(5, lista.get(0));
		assertEquals(10, lista.get(1));
		assertEquals(15, lista.get(2));
		assertThrows(IndexOutOfBoundsException.class, () -> lista.get(4));//Valir el error de el metodo ValidarElementoIndice 
	}

	@Test
	void testSet() {
		lista.agregar(5);
		lista.agregar(10);
		assertEquals(5, lista.set(0, 15));
		assertEquals(15, lista.get(0));			
	}


	@Test
	void testRemoverObject() {
		lista.agregar(null);
		lista.agregar(0,10);
	}

	
	@Test
	void testRemoverInt() {
		assertThrows(IndexOutOfBoundsException.class, () -> lista.remover(0));
		lista.agregar(5);
		lista.agregar(10);
		lista.agregar(15);
		assertEquals(10, lista.remover(1));
		assertEquals(5, lista.get(0));
		assertEquals(15, lista.get(1));
		assertThrows(IndexOutOfBoundsException.class, () -> lista.remover(3));
	}

	@Test
	void testLimpiar() {
		assertTrue(lista.esVacio());
		lista.agregar(5);
		lista.agregar(10);
		assertFalse(lista.esVacio());
		lista.limpiar();
		assertTrue(lista.esVacio());
		assertEquals(0, lista.tamanyo());			
	}

	@Test
	void testIndiceDe() {
	    lista.agregar(5);
	    lista.agregar(10);
	    lista.agregar(15);
	    lista.agregar(null);
	    assertEquals(1, lista.indiceDe(10));
	    assertEquals(0, lista.indiceDe(5));
	    assertEquals(2, lista.indiceDe(15));
	    assertEquals(3, lista.indiceDe(null));
	    assertEquals(-1, lista.indiceDe(20));

	}
}
