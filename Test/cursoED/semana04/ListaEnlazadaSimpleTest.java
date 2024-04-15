package cursoED.semana04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListaEnlazadaSimpleTest {

    ListaEnlazadaSimple<Integer> lista = new ListaEnlazadaSimple<>();

    @Test
    void testToString() {
        assertEquals("Lista()", lista.toString());
        lista.agregar(1);
        assertEquals("Lista(1)", lista.toString());
        lista.agregar(2);
        lista.agregar(3);
        assertEquals("Lista(1, 2, 3)", lista.toString());
    }

}