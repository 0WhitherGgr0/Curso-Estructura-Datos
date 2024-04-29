package cursoED.semana06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircularArrayQueueTest {

	private Queue<Integer> q = new CircularArrayQueue<>();
	private Queue<Integer> qa = new CircularArrayQueue<>(5);

	@Test
	void testOffer() {
		q.offer(15);
		assertTrue(q.offer(25));
	}	
	@Test
	void testOfferException() {
		assertThrows(NullPointerException.class,() -> q.offer(null));
	}
	@Test
	void testOfferLleno() {
		qa.offer(10);
		qa.offer(20);
		qa.offer(30);
		qa.offer(40);
		qa.offer(50);
		assertFalse(qa.offer(10));
	}
	
	
	@Test
	void testPoll() {
		qa.offer(10);
		qa.offer(20);
		qa.offer(30);
		qa.offer(40);
		qa.offer(50);
		assertEquals(10, qa.poll());
		assertEquals(20, qa.poll());
		assertEquals(30, qa.poll());
		assertEquals(40, qa.poll());
	}
	@Test
	void testPollEmpty() {
		assertNull( qa.poll());
	}
	
	@Test
	void testPeek() {
		qa.offer(10);
		qa.offer(20);
		qa.offer(30);
		qa.offer(40);
		qa.offer(50);
		assertEquals(10,qa.peek());
		qa.poll();
		assertEquals(20,qa.peek());
	}
	@Test
	void testPeekConUnaPilaVacia() {
		assertNull(qa.peek());
	}


	@Test
	void testToString() {
		assertEquals("[]", q.toString());
		q.offer(10);
		assertEquals("[10]", q.toString());
		q.offer(20);
		q.offer(30);
		assertEquals("[10, 20, 30]", q.toString());
	}

}
