package cursoED.semana02.ejercicio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayUniDimensionalTest {

	@Test
	void testContarRepeticionConMaximaRepeticion() {
		assertEquals(3, ArrayUniDimensional.contarRepeticion(new int[] {1, 1, 1}, 1));
	}
	@Test
	void testContarRepeticionConCeroRepeticion() {
		assertEquals(0, ArrayUniDimensional.contarRepeticion(new int[] {1, 1, 1}, 2));
	}
	@Test
	void testContarRepeticionConRepeticionAlInicio() {
		assertEquals(1, ArrayUniDimensional.contarRepeticion(new int[] {1, 2, 3}, 1));
	}

	@Test
	void testContarRepeticionConRepeticionAlFinal() {
		assertEquals(1, ArrayUniDimensional.contarRepeticion(new int[] {1, 2, 3}, 3));
	}
	@Test
	void testContarNumerosPrimos() {
		assertEquals(3, ArrayUniDimensional.contarNumerosPrimos(new int[] {1, 2, 3}));
		assertEquals(2, ArrayUniDimensional.contarNumerosPrimos(new int[] {10, 11, 12, 13}));
	}
	@Test
	void testContarNumerosPrimosConNingunNumeroPrimo() {
		assertEquals(0, ArrayUniDimensional.contarNumerosPrimos(new int[] {4,6,8,9}));
	}

}