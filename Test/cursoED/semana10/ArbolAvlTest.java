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
	//*****************************************

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
		
		
	}
	@Test
    void testInsercionSubarbolIzquierdoRamaIzquierdaRotacionII() {
        ArbolAvl<Integer> a = new ArbolAvl<>();
        Logical h = new Logical(false); 
        a.insertar(3);  
        a.insertar(2);  
        a.insertar(1);  
        
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

	}


	//*****************************************
	@Test
    void testInsercionSubarbolIzquierdoRamaIzquierdaRotacionIDFeCero() {
        ArbolAvl<Integer> a = new ArbolAvl<>();
        Logical h = new Logical(false); 
        a.insertar(10);  
        a.insertar(5);  
        a.insertar(7);  

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
	///***************************************************
		
	@Test
    void testInsercionSubarbolIzquierdoRamaIzquierdaRotacionDIFeCero() {
        ArbolAvl<Integer> a = new ArbolAvl<>();
        Logical h = new Logical(false); 
        a.insertar(10);  
        a.insertar(15);  
        a.insertar(13);  

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

	
	
	///***************************************************

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
	
	

	
}