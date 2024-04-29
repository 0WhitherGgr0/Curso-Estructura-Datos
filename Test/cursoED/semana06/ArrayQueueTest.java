package cursoED.semana06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayQueueTest {
	Queue<Integer> q = new ArrayQueue<Integer>(5); 
	Queue<Integer> qd = new ArrayQueue<Integer>(); 
	ArrayQueue<Integer> aq=new ArrayQueue<Integer>(5);
	
	@Test
	void testOfferDentroDeLaCapacidad() {
		assertTrue(q.offer(10));
		assertTrue(q.offer(20));
		assertTrue(q.offer(30));
		assertTrue(q.offer(40));
		assertTrue(q.offer(50));
		
	}	
	@Test
	void testOfferExcediendoCapacidad() {
		q.offer(10);
		q.offer(20);
		q.offer(30);
		q.offer(40);
		q.offer(50);
		assertFalse(q.offer(10));
	}
	@Test
	void testOfferExecption() {
		assertThrows(NullPointerException.class,()-> q.offer(null));
	}
	
	@Test
	void testArrayQueue() {
		q.offer(10);
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
	void testPollColaVacia() {
		assertNull(q.poll());
	}
	@Test
	void testPeek() {
		q.offer(10);
		q.offer(20);
		assertEquals(10,q.peek());
		q.poll();
		assertEquals(20,q.peek());		
		assertEquals(20,q.peek());
	}
	@Test
	void testPeekVacio() {
		assertNull(q.peek());		
	}	
	@Test
	void testIsEmpty() {
		assertTrue(q.isEmpty());
	}

	@Test
	void testIsFull() {
		aq.offer(10);
		aq.offer(20);
		aq.offer(30);
		aq.offer(40);
		aq.offer(50);
		assertFalse(aq.offer(60));
		assertTrue(aq.isFull());
	}

}
