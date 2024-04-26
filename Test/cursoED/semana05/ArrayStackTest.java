package cursoED.semana05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayStackTest {
	ArrayStack stack= new ArrayStack();
	
	@Test
	void testPush() {
		stack.push(3);
		assertEquals(false,stack.empty());
        assertEquals(3, stack.peek());
	}	
	@Test
	void testPushParaArrayStackLlenoyTamayoDefinido() {
		ArrayStack<Integer> stacks = new ArrayStack<>(1);
		stacks.push(3);
		assertThrows(RuntimeException.class, () -> stacks.push(4));
	}

	
		
	@Test
	void testPop() {
		assertEquals("[]", stack.toString());
		stack.push(1);
		stack.push(2);
		stack.pop();
		assertEquals("[1]", stack.toString());
	}
	@Test
	void testPopVacio() {
		assertEquals("[]", stack.toString());	
        assertThrows(RuntimeException.class, () -> stack.pop());
	}
	
	
	
	@Test
	void testPeek() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
	}
	@Test
	void testPeekArrayStackVacio() {
		assertEquals("[]", stack.toString());
		assertThrows(RuntimeException.class, () -> stack.peek());
	}
		
	
	@Test
	void testEmpty() {
		assertEquals(true,stack.empty());
	}

	@Test
	void testToString() {
		assertEquals("[]", stack.toString());
		stack.push(1);
		assertEquals("[1]", stack.toString());
		stack.push(2);
		assertEquals("[2, 1]", stack.toString());
	}
}