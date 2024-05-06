package cursoED.semana07.heap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HeapTest {
	Heap<Integer> heap = new Heap<>();

	@Test
	void testInsert() {
		heap.insert(26);
		heap.insert(42);
		heap.insert(35);
		heap.insert(55);
		heap.insert(64);
		heap.insert(40);
		heap.insert(39);
		heap.insert(70);
		assertEquals("[26, 42, 35, 55, 64, 40, 39, 70]", heap.toString());
		heap.insert(23);
		assertEquals("[23, 26, 35, 42, 64, 40, 39, 70, 55]", heap.toString());
	}
	@Test
	void testInsert2() {
		heap.insert(1);
		heap.insert(3);
		heap.insert(5);
		heap.insert(7);
		heap.insert(9);
		heap.insert(10);
		heap.insert(8);
		assertEquals("[1, 3, 5, 7, 9, 10, 8]", heap.toString());
		heap.insert(6);
		assertEquals("[1, 3, 5, 6, 9, 10, 8, 7]", heap.toString());
		heap.insert(4);
		assertEquals("[1, 3, 5, 4, 9, 10, 8, 7, 6]", heap.toString());
		heap.insert(2);
		assertEquals("[1, 2, 5, 4, 3, 10, 8, 7, 6, 9]", heap.toString());
	}
	@Test
	void testInsert3() {
		heap.insert(1);
		heap.insert(3);
		heap.insert(5);
		heap.insert(7);
		heap.insert(9);
		assertEquals("[1, 3, 5, 7, 9]", heap.toString());
		heap.insert(2);
		assertEquals("[1, 3, 2, 7, 9, 5]", heap.toString());
		heap.insert(4);
		assertEquals("[1, 3, 2, 7, 9, 5, 4]", heap.toString());
		heap.insert(6);
		assertEquals("[1, 3, 2, 6, 9, 5, 4, 7]", heap.toString());
		heap.insert(8);
		assertEquals("[1, 3, 2, 6, 9, 5, 4, 7, 8]", heap.toString());
	}

	@Test
	void testElement() {
		heap.insert(26);
		heap.insert(42);
		heap.insert(35);
		heap.insert(55);
		heap.insert(64);
		heap.insert(40);
		heap.insert(39);
		heap.insert(70);
		assertEquals(26, heap.element());
		heap.insert(23);
		assertEquals(23, heap.element());
	}

	@Test
	void testRemove() {
		heap.insert(7);
		heap.insert(19);
		heap.insert(22);
		heap.insert(26);
		heap.insert(33);
		heap.insert(29);
		heap.insert(41);
		assertEquals("[7, 19, 22, 26, 33, 29, 41]", heap.toString());
		assertEquals(7, heap.remove());
		assertEquals("[19, 26, 22, 41, 33, 29]", heap.toString());
	}


	@Test
	void testToString() {
		assertEquals("[]", heap.toString());
		heap.insert(7);
		assertEquals("[7]", heap.toString());
		heap.insert(9);
		assertEquals("[7, 9]", heap.toString());
		heap.insert(12);
		assertEquals("[7, 9, 12]", heap.toString());
	}

	@Test
	void testToString2() {
		Heap<Integer> pq = heap;
		assertEquals("[]", pq.toString());
		pq.insert(15);
		assertEquals("[15]", pq.toString());
		pq.insert(39);
		assertEquals("[15, 39]", pq.toString());
		pq.insert(18);
		assertEquals("[15, 39, 18]", pq.toString());
		pq.insert(41);
		assertEquals("[15, 39, 18, 41]", pq.toString());
	}

}
