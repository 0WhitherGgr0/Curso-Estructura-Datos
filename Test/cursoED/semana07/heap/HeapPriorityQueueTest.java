package cursoED.semana07.heap;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cursoED.semana07.comun.PriorityQueue;
import cursoED.semana07.list.Estudiante;


class HeapPriorityQueueTest {
	PriorityQueue<Estudiante> pq = new HeapPriorityQueue<>();

	@Test
	void testIsEmpty() {
		assertTrue(pq.isEmpty());
		pq.offer(new Estudiante("21000001", "Perez", "Juan", 17.5F));
		assertFalse(pq.isEmpty());
	}
	@Test
	void testOffer() {
		assertThrows(NullPointerException.class, () -> pq.offer(null));
		assertTrue(pq.offer(new Estudiante("21000001", "Arias", "Alex", 17.5F)));
		assertTrue(pq.offer(new Estudiante("21000002", "Bellido", "Betty", 17.5F)));
		assertTrue(pq.offer(new Estudiante("21000003", "Zeta", "Jones", 17.5F)));
		assertTrue(pq.offer(new Estudiante("21000004", "Diaz", "Diana", 17.5F)));
		assertTrue(pq.offer(new Estudiante("21000005", "Bellido", "Eva", 17.5F)));
		assertEquals("21000001", pq.poll().getCodigo());
		assertEquals("21000002", pq.poll().getCodigo());
		assertEquals("21000005", pq.poll().getCodigo());
		assertEquals("21000004", pq.poll().getCodigo());
		assertEquals("21000003", pq.poll().getCodigo());
	}
	@Test
	void testOfferInvert() {
		assertTrue(pq.offer(new Estudiante("21000001", "Zeta", "Jones", 17.5F)));
		assertTrue(pq.offer(new Estudiante("21000002", "Diaz", "Diana", 17.5F)));
		assertTrue(pq.offer(new Estudiante("21000003", "Bellido", "Eva", 17.5F)));
		assertTrue(pq.offer(new Estudiante("21000004", "Bellido", "Betty", 17.5F)));
		assertTrue(pq.offer(new Estudiante("21000005", "Arias", "Alex", 17.5F)));
		assertEquals("21000005", pq.poll().getCodigo());
		assertEquals("21000004", pq.poll().getCodigo());
		assertEquals("21000003", pq.poll().getCodigo());
		assertEquals("21000002", pq.poll().getCodigo());
		assertEquals("21000001", pq.poll().getCodigo());
}
	@Test
	void testOfferWithSamePriorities() {
		assertThrows(NullPointerException.class, () -> pq.offer(null));
		Estudiante e1 = new Estudiante("21000001", "Arias", "Alex", 17.5F);
		Estudiante e2 = new Estudiante("21000002", "Bellido", "Betty", 17.5F);
		Estudiante e3 = new Estudiante("21000003", "Arias", "Alex", 17.5F);
		Estudiante e4 =new Estudiante("21000004", "Diaz", "Diana", 17.5F);
		Estudiante e5 =new Estudiante("21000005", "Arias", "Alex", 17.5F); 		
		
		assertTrue(pq.offer(e1));
		assertTrue(pq.offer(e2));
		assertTrue(pq.offer(e3));
		assertTrue(pq.offer(e4));
		assertTrue(pq.offer(e5));
		//assertEquals("[21000001, 21000003, 21000005, 21000002, 21000004]", pq.toString());
		System.out.println(pq);
		assertEquals (e1, pq.poll());
		assertEquals (e3, pq.poll());
		assertEquals (e5, pq.poll());
		assertEquals (e2, pq.poll());
		assertEquals (e4, pq.poll());
	}
	/*
	@Test
	void testOfferUsingApellidoComparator() {
		PriorityQueue<Estudiante> pq = new ListPriorityQueue<>((e1, e2) -> e1.getApellido().compareTo(e2.getApellido()));
		assertTrue(pq.offer(new Estudiante("21000001", "Arias", "Alex", 17.5F)));
		assertTrue(pq.offer(new Estudiante("21000002", "Bellido", "Betty", 17.5F)));
		assertTrue(pq.offer(new Estudiante("21000003", "Arias", "Alex", 17.5F)));
		assertTrue(pq.offer(new Estudiante("21000004", "Diaz", "Diana", 17.5F)));
		assertTrue(pq.offer(new Estudiante("21000005", "Arias", "Alex", 17.5F)));
		assertEquals("[21000001, 21000003, 21000005, 21000002, 21000004]", pq.toString());
	}	
	@Test
	void testOfferUsingPonderadoComparator() {
		PriorityQueue<Estudiante> pq = new ListPriorityQueue<>(new PonderadoComparador());
		assertTrue(pq.offer(new Estudiante("21000001", "Arias", "Alex", 12.0F)));
		assertTrue(pq.offer(new Estudiante("21000002", "Bellido", "Betty", 18.5F)));
		assertTrue(pq.offer(new Estudiante("21000003", "Arias", "Alex", 13.5F)));
		assertTrue(pq.offer(new Estudiante("21000004", "Diaz", "Diana", 17.5F)));
		assertTrue(pq.offer(new Estudiante("21000005", "Arias", "Alex", 15.0F)));
		assertEquals("[21000001, 21000003, 21000005, 21000004, 21000002]", pq.toString());
	}	
*/
	@Test
	void testPoll() {
		Estudiante e1 = new Estudiante("21000001", "Arias", "Alex", 17.5F);
		Estudiante e2 = new Estudiante("21000002", "Bellido", "Betty", 17.5F);
		Estudiante e3 = new Estudiante("21000003", "Casas", "Carlos", 17.5F);
		Estudiante e4 = new Estudiante("21000004", "Diaz", "Diana", 17.5F);
		Estudiante e5 = new Estudiante("21000005", "Elias", "Eva", 17.5F);
		pq.offer(e1);
		pq.offer(e2);
		pq.offer(e3);
		pq.offer(e4);
		pq.offer(e5);
		assertEquals(e1, pq.poll());
		assertEquals(e2, pq.poll());
		assertEquals(e3, pq.poll());
		assertEquals(e4, pq.poll());
		assertEquals(e5, pq.poll());
		assertNull(pq.poll());
		assertTrue(pq.isEmpty());
	}

	@Test
	void testPeek() {
		Estudiante e1 = new Estudiante("21000001", "Arias", "Alex", 17.5F);
		Estudiante e2 = new Estudiante("21000002", "Bellido", "Betty", 17.5F);
		Estudiante e3 = new Estudiante("21000003", "Casas", "Carlos", 17.5F);
		Estudiante e4 = new Estudiante("21000004", "Diaz", "Diana", 17.5F);
		Estudiante e5 = new Estudiante("21000005", "Elias", "Eva", 17.5F);
		pq.offer(e1);
		pq.offer(e2);
		pq.offer(e3);
		pq.offer(e4);
		pq.offer(e5);
		assertEquals(e1, pq.peek());
		assertEquals(e1, pq.peek());
		pq.poll();
		assertEquals(e2, pq.peek());
		pq.poll();
		assertEquals(e3, pq.peek());
		pq.poll();
		pq.poll();
		pq.poll();
		assertNull(pq.peek());
	}
}
