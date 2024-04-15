package cursoED.semana02.ejercicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import cursoED.util.Complejo;

class ArrayDeObjectosTest {

    @Test
    void testContarRepeticion() {
        Complejo[] datos = {new Complejo(1, 2), new Complejo(5, 7), new Complejo(6, 3)};
        Complejo dato = new Complejo(1, 2);
        assertEquals(1, ArrayDeObjectos.contarRepeticion(datos, dato));
        // Se espera que devuelva 1, ya que el complejo (1,2) está presente una vez en el array.
    }

    @Test
    void testContarRepeticionConDatoNoPresente() {
        Complejo[] datos = {new Complejo(1, 2), new Complejo(5, 7), new Complejo(6, 3)};
        Complejo dato = new Complejo(10, 10);
        assertEquals(0, ArrayDeObjectos.contarRepeticion(datos, dato));
        // Se espera que devuelva 0, ya que el complejo (10,10) no está presente en el array.
    }

    @Test
    void testContarRepeticionConArrayVacio() {
        Complejo[] datos = {};
        Complejo dato = new Complejo(1, 2);
        assertEquals(0, ArrayDeObjectos.contarRepeticion(datos, dato));
        // Se espera que devuelva 0, ya que el array está vacío y no contiene ningún complejo.
    }
}