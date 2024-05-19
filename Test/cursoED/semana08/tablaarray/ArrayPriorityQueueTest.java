package cursoED.semana08.tablaarray;
import cursoED.semana07.comun.PriorityQueue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayPriorityQueueTest {  
    PriorityQueue<Estudiante> pq = new ArrayPriorityQueue<>(3);
    
	   @Test
	   public void testNegativePriorityNumberException() {
	       assertThrows(RuntimeException.class, () -> new ArrayPriorityQueue<>(-1));
	   }
	   @Test
	   public void testOffer() {
	       assertThrows(NullPointerException.class, () -> pq.offer(null));
	       assertFalse(pq.offer(new Estudiante("21000001", "Perez", "Juan", 17.5F, 4)));
	       assertTrue(pq.offer(new Estudiante("21000001", "Arias", "Alex", 17.5F, 0)));
	       assertTrue(pq.offer(new Estudiante("21000002", "Bellido", "Betty", 17.5F, 1)));
	       assertTrue(pq.offer(new Estudiante("21000003", "Casas", "Carlos", 17.5F, 3)));
	       assertTrue(pq.offer(new Estudiante("21000004", "Diaz", "Diana", 17.5F, 0)));
	       assertTrue(pq.offer(new Estudiante("21000005", "Elias", "Eva", 17.5F, 1)));
	       assertEquals("[21000001, 21000004][21000002, 21000005][][21000003]", pq.toString());
	   } 

	    
	    @Test
	    public void testPoll() {
	        assertNull(pq.poll());
	        pq.offer(new Estudiante("21000001", "Arias", "Alex", 17.5F, 0));
	        pq.offer(new Estudiante("21000002", "Bellido", "Betty", 17.5F, 1));
	        pq.offer(new Estudiante("21000003", "Casas", "Carlos", 17.5F, 3));
	        pq.offer(new Estudiante("21000004", "Diaz", "Diana", 17.5F, 0));
	        pq.offer(new Estudiante("21000005", "Elias", "Eva", 17.5F, 1));
	        
	        assertEquals(new Estudiante("21000001", "Arias", "Alex", 17.5F, 0), pq.poll());
	        assertEquals(new Estudiante("21000004", "Diaz", "Diana", 17.5F, 0), pq.poll());
	        assertEquals(new Estudiante("21000002", "Bellido", "Betty", 17.5F, 1), pq.poll());
	        assertEquals(new Estudiante("21000005", "Elias", "Eva", 17.5F, 1), pq.poll());
	        assertEquals(new Estudiante("21000003", "Casas", "Carlos", 17.5F, 3), pq.poll());
	        
	        assertNull(pq.poll());
	    }

	    @Test
	    public void testPeek() {
	        assertNull(pq.peek());
	        pq.offer(new Estudiante("21000001", "Arias", "Alex", 17.5F, 0));
	        pq.offer(new Estudiante("21000002", "Bellido", "Betty", 17.5F, 1));
	        pq.offer(new Estudiante("21000003", "Casas", "Carlos", 17.5F, 3));
	        pq.offer(new Estudiante("21000004", "Diaz", "Diana", 17.5F, 0));
	        pq.offer(new Estudiante("21000005", "Elias", "Eva", 17.5F, 1));
	        assertEquals(new Estudiante("21000001", "Arias", "Alex", 17.5F, 0), pq.peek());
	        pq.poll();
	        assertEquals(new Estudiante("21000004", "Diaz", "Diana", 17.5F, 0), pq.peek());
	        pq.poll();
	        assertEquals(new Estudiante("21000002", "Bellido", "Betty", 17.5F, 1), pq.peek());
	        pq.poll();
	        assertEquals(new Estudiante("21000005", "Elias", "Eva", 17.5F, 1), pq.peek());
	        pq.poll();
	        assertEquals(new Estudiante("21000003", "Casas", "Carlos", 17.5F, 3), pq.peek());
	        pq.poll();
	        assertNull(pq.peek());
	    }
	    @Test
	    public void testToString() {
	        pq.offer(new Estudiante("21000001", "Arias", "Alex", 17.5F, 0));
	        pq.offer(new Estudiante("21000002", "Bellido", "Betty", 17.5F, 1));
	        pq.offer(new Estudiante("21000003", "Casas", "Carlos", 17.5F, 3));
	        pq.offer(new Estudiante("21000004", "Diaz", "Diana", 17.5F, 0));

	        // Verificar la representación en cadena
	        assertEquals("[21000001, 21000004][21000002][][21000003]", pq.toString());
	    }
	    @Test
	    public void isEmptyTest() {
	    	assertTrue(pq.isEmpty());	    	
	        pq.offer(new Estudiante("21000001", "Arias", "Alex", 17.5F, 0));
	        pq.offer(new Estudiante("21000002", "Bellido", "Betty", 17.5F, 1));
	        pq.offer(new Estudiante("21000003", "Casas", "Carlos", 17.5F, 3));
	        pq.offer(new Estudiante("21000004", "Diaz", "Diana", 17.5F, 0));

	        pq.poll();
	        pq.poll();
	        pq.poll();
	        pq.poll();
	        
	        assertEquals("[][][][]", pq.toString());
	    }
	    
	    
}
 