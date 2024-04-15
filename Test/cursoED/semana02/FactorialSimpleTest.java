package cursoED.semana02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FactorialSimpleTest {
	@Test
	void testFactorialConNumerosPequeños() {
		
	assertEquals(1, FactorialSimple.factorial(1));
	assertEquals(2, FactorialSimple.factorial(2));
	assertEquals(6, FactorialSimple.factorial(3));
	assertEquals(24, FactorialSimple.factorial(4));
	assertEquals(120, FactorialSimple.factorial(5));
	
	}
	
	@Test
	void testFactorialConNumerosMedianos() {
		
	assertEquals(1307674368000L, FactorialSimple.factorial(15));
	assertEquals(2432902008176640000L, FactorialSimple.factorial(20));
	
	}
	
	@Test
	void testFactorialConNumerosQueExcedeAlRangoPermitido() {
		
	assertThrows(RuntimeException.class, () -> FactorialSimple.factorial(21));
	}
}
