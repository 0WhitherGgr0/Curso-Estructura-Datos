package cursoED.semana13.GrafoAd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrafoAdciaTest {

    GrafoAdcia grafo;

    @BeforeEach
    void setUp() {
        grafo = new GrafoAdcia(5); // Inicializamos el grafo con un tamaño de 5 vértices.
    }

    @Test
    void testGrafoAdcia() {
        GrafoAdcia g = new GrafoAdcia(10);
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
    void testInsertarArco() {
        grafo.nuevoVertice("A");
        grafo.nuevoVertice("B");
        grafo.insertarArco(0, 1, 2.5);
        assertTrue(grafo.adyacente(0, 1));
    }

    @Test
    void testEliminarArco() {
        grafo.nuevoVertice("A");
        grafo.nuevoVertice("B");
        grafo.insertarArco(0, 1, 2.5);
        grafo.eliminarArco(0, 1);
        assertFalse(grafo.adyacente(0, 1));
    }

    @Test
    void testAdyacente() {
        grafo.nuevoVertice("A");
        grafo.nuevoVertice("B");
        grafo.insertarArco(0, 1, 2.5);
        assertTrue(grafo.adyacente(0, 1));
        assertFalse(grafo.adyacente(1, 0));
    }

    @Test
    void testEliminarVertice() {
        grafo.nuevoVertice("A");
        grafo.nuevoVertice("B");
        grafo.nuevoVertice("C");
        grafo.insertarArco(0, 1, 1.0);
        grafo.insertarArco(0, 2, 2.0);
        grafo.eliminarVertice(1);
        assertEquals(2, grafo.numeroDeVertices());
        assertFalse(grafo.adyacente(0, 1));
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
    void testNumeroDeVertices() {
        grafo.nuevoVertice("A");
        grafo.nuevoVertice("B");
        assertEquals(2, grafo.numeroDeVertices());
    }

    @Test
    void testRecorrerProf() throws Exception {
        grafo.nuevoVertice("A");
        grafo.nuevoVertice("B");
        grafo.nuevoVertice("C");
        grafo.insertarArco(0, 1, 1.0);
        grafo.insertarArco(1, 2, 1.0);

        int[] recorrido = GrafoAdcia.recorrerProf(grafo, "A");
        assertEquals(0, recorrido[0]); // A visitado primero
        assertEquals(1, recorrido[1]); // B visitado después
        assertEquals(1, recorrido[2]); // C visitado después
    }
}
