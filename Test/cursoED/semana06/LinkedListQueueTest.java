package cursoED.semana06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListQueueTest {
	private Queue<Integer> q = new LinkedListQueue<>();
	
	@Test
	void testOffer() {
		assertTrue(q.offer(10));
		assertTrue(q.offer(20));
		assertTrue(q.offer(30));
	}
	@Test
	void testOfferExeption() {		
		assertThrows(NullPointerException.class,() -> q.offer(null));
	}
	
	
	
	@Test
	void testPoll() {
		q.offer(10);
		q.offer(20);
		q.offer(30);
		assertEquals(10,q.poll());
		assertEquals(20,q.poll());
		assertEquals(30,q.poll());
	
	}
	@Test
	void testPollEmpty() {
		assertNull(q.poll());
	}

	
	@Test
	void testPeek() {
		q.offer(10);
		q.offer(20);
		q.offer(30);
		assertEquals(10,q.peek());
	}
	
	@Test
	void testPeekEmpty() {
		assertNull(q.peek());
	}

	@Test
	void testIsEmpty() {
		assertTrue(q.isEmpty());
	}

	@Test
	void testToString() {
		q.offer(10);
		q.offer(20);
		q.offer(30);
		assertEquals("Lista(10, 20, 30)",q.toString());
		
	}

}
