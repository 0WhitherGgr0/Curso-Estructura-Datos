package cursoED.semana13.MatrizAd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrafoMatrizTest {

    GrafoMatriz grafo;

    @BeforeEach
    void setUp() {
        grafo = new GrafoMatriz(5); // Inicializamos el grafo con un tamaño de 5 vértices.
    }

    @Test
    void testGrafoMatriz() {
        GrafoMatriz g = new GrafoMatriz();
        assertNotNull(g);
        assertEquals(0, g.numeroDeVertices());
    }

    @Test
    void testGrafoMatrizInt() {
        GrafoMatriz g = new GrafoMatriz(10);
        assertNotNull(g);
        assertEquals(0, g.numeroDeVertices());
    }

    @Test
    void testNuevoVertice() {
        grafo.nuevoVertice("A");
        assertEquals(1, grafo.numeroDeVertices());
        assertEquals(0, grafo.numVertice("A"));
    }

    @Test
    void testNumVertice() {
        grafo.nuevoVertice("A");
        grafo.nuevoVertice("B");
        assertEquals(0, grafo.numVertice("A"));
        assertEquals(1, grafo.numVertice("B"));
        assertEquals(-1, grafo.numVertice("C"));
    }

    @Test
    void testNuevoArco() {
        grafo.nuevoVertice("A");
        grafo.nuevoVertice("B");
        grafo.nuevoArco("A", "B");
        try {
            assertTrue(grafo.adyacente("A", "B"));
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    void testAdyacenteStringString() {
        grafo.nuevoVertice("A");
        grafo.nuevoVertice("B");
        grafo.nuevoArco("A", "B");
        try {
            assertTrue(grafo.adyacente("A", "B"));
            assertFalse(grafo.adyacente("B", "A"));
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    void testAdyacenteIntInt() {
        grafo.nuevoVertice("A");
        grafo.nuevoVertice("B");
        grafo.nuevoArco("A", "B");
        try {
            assertTrue(grafo.adyacente(0, 1));
            assertFalse(grafo.adyacente(1, 0));
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    void testNumeroDeVertices() {
        grafo.nuevoVertice("A");
        grafo.nuevoVertice("B");
        assertEquals(2, grafo.numeroDeVertices());
    }

    @Test
    void testRecorrerAnchura() {
        grafo.nuevoVertice("A");
        grafo.nuevoVertice("B");
        grafo.nuevoVertice("C");
        grafo.nuevoArco("A", "B");
        grafo.nuevoArco("B", "C");

        try {
            int[] recorrido = GrafoMatriz.recorrerAnchura(grafo, "A");
            assertEquals(0, recorrido[0]); // A visitado primero
            assertEquals(1, recorrido[1]); // B visitado después
            assertEquals(2, recorrido[2]); // C visitado después
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }
}
