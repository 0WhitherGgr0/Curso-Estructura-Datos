package cursoED.semana02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayCopiaTest {
	int[] origen;
	
	@BeforeEach
	public void setup() {
		origen = new int[]{1,3,5,7,9};
	}

	@Test
	void testArrayCopiaIntArray() {
		int[] expected ={1,3,5,7,9};
		assertArrayEquals(expected, ArrayCopia.arrayCopia(origen));
	}

	@Test
	void testArrayCopiaIntArrayIntArray() {
		int[] expected = {1,3,5,7,9};
		int[] destino = new int[origen.length];
		ArrayCopia.arrayCopia(origen, destino);
		assertArrayEquals(expected, destino);
	}
	@Test
	void testArrayCopiaUsandoSystem_arraycopy() {
		int[] expected = {1,3,5,7,9};
		int[] destino = new int[origen.length];
		System.arraycopy(origen, 0, destino, 0, origen.length);
		assertArrayEquals(expected, destino);
	}
	@Test
	void testArrayCopiaUsandoArrays_copyOf() {
		int[] expected = {1,3,5,7,9};
		int[] destino = Arrays.copyOf(origen, origen.length);
		assertArrayEquals(expected, destino);
	}
	@Test
	void testArrayCopiaUsandoArrays_copyOfRange() {
		int[] expected = {1,3,5,7,9};
		int[] destino = Arrays.copyOfRange(origen, 0, origen.length);
		assertArrayEquals(expected, destino);
	}

}