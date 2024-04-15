package cursoED.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtillTest {

	@Test
	void testPrimosPequeños() {
		assertTrue(MathUtil.esPrimo(2));
		assertTrue(MathUtil.esPrimo(3));
		assertTrue(MathUtil.esPrimo(5));
		assertTrue(MathUtil.esPrimo(6));

	}
	@Test
	void testPrimosMedianos() {
		
		assertEquals(true,MathUtil.esPrimo(13));
		assertEquals(true,MathUtil.esPrimo(29));
		assertEquals(true,MathUtil.esPrimo(43));
		assertEquals(false,MathUtil.esPrimo(55));
		assertEquals(false,MathUtil.esPrimo(75));

	}
	
	@Test
	void testPrimosGrandes() {
		assertEquals(true,MathUtil.esPrimo(113));
		assertEquals(true,MathUtil.esPrimo(241));
		assertEquals(false,MathUtil.esPrimo(524));
		assertEquals(false,MathUtil.esPrimo(888));

	}


}
