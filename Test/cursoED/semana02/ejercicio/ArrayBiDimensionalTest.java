package cursoED.semana02.ejercicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ArrayBiDimensionalTest {

    @Test
    void testContarRepeticion() {
        int[][] datos = {{10, 12, 14, 15},
                         {10, 13, 14},
                         {17, 10, 12, 10}};
        assertEquals(4, ArrayBiDimensional.contarRepeticion(datos, 10));
        assertEquals(0, ArrayBiDimensional.contarRepeticion(datos, 20));
    }

    @Test
    void testContarNumerosPrimos() {
        int[][] datos = {{10, 12, 14, 15},
                         {10, 13, 14},
                         {17, 10, 12, 10}};
        assertEquals(2, ArrayBiDimensional.contarNumerosPrimos(datos));
        assertEquals(3, ArrayBiDimensional.contarNumerosPrimos(new int[][] {{10, 11, 12, 13}, {14, 15, 16, 17}}));
    }
}