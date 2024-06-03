package cursoED.semana11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HuffmanTreeTest {
	char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
	int[] charfreq = { 45, 13, 12, 16, 9, 5 };

	HuffmanTree h = new HuffmanTree(charArray, charfreq);

	//	  100
	//	 0/	 \1
	//	45	  55	
	//		0/	\1
	//	  25	  30			
	//   0/	\1	 0/	\1
	//	12	13	14	16
	//		   0/ \1	
	//		   5   9	 
	
	
	// Por completar y cubrir todos los casos.
	@Test
	void testHuffmanTree() {
		assertNotNull(h.root);
		assertEquals(100, h.root.freq);
	}
	
	@Test
	void testGetCodificadoExistentes() {
		assertEquals("0", h.getCodificado('a'));
		assertEquals("100", h.getCodificado('c'));
		assertEquals("101", h.getCodificado('b'));
		assertEquals("1100", h.getCodificado('f'));
		assertEquals("1101", h.getCodificado('e'));
		assertEquals("111", h.getCodificado('d'));
	}

	@Test
	void testGetDesCodificado() {
		assertEquals("a", h.getDesCodificado("0"));
		assertEquals("c", h.getDesCodificado("100"));
		assertEquals("b", h.getDesCodificado("101"));
		assertEquals("f", h.getDesCodificado("1100"));
		assertEquals("e", h.getDesCodificado("1101"));
		assertEquals("d", h.getDesCodificado("111"));
	}
	@Test
	void testGetDesCodificadoCadema() {
		assertEquals("acf", h.getDesCodificado("01001100"));
		assertEquals("efb", h.getDesCodificado("11011100101"));
	}
	@Test
	void testGetDesCodificadoNull() {
		assertNull(h.getDesCodificado(null));
	}

	@Test
	void testBuildTree() {
		assertNotNull(h.root);
		assertEquals(100, h.root.freq);
		
		assertNotNull(h.root.left);
		assertNotNull(h.root.right);
		
		HuffmanNode left = h.root.left;
		HuffmanNode right = h.root.right;
		
		assertEquals(45, left.freq);
		assertEquals(55, right.freq);
		
		assertNotNull(right.left);
		assertNotNull(right.right);
		
		HuffmanNode rightLeft = right.left;
		HuffmanNode rightRight = right.right;
		
		assertEquals(25, rightLeft.freq);
		assertEquals(30, rightRight.freq);	}

}

