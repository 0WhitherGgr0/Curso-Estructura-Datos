package cursoED.semana05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;

class LinkedListStackTest {
    
    private LinkedListStack<Integer> stack= new LinkedListStack<>();

    @Test
    void testLinkedListStack() {
        assertTrue(stack.empty());
    }

    @Test
    void testPush() {
        stack.push(10);
        assertEquals(false, stack.empty());
        assertEquals(10, stack.peek());
    }

    @Test
    void testPop() {
        stack.push(20);
        stack.push(30);
        assertEquals(30, stack.pop());// Pop debería retornar el último elemento insertado.
        assertEquals(20, stack.peek());//La cima de la pila debería ser el siguiente elemento después de un pop.
    }

    @Test
    void testPopEmpty() {
    	//Lanza la excepcion EmptyStackException al intentar pop de una pila vacía. 	
    	assertThrows(EmptyStackException.class, () -> stack.pop());
        stack.push(40);
        stack.pop();
        assertThrows(EmptyStackException.class, () -> stack.pop());   
    }

    @Test
    void testPeek() {
        stack.push(40);
        stack.push(50);
        assertEquals(50, stack.peek());//Peek debería retornar el último elemento insertado sin removerlo.
        stack.pop();
        assertEquals(40, stack.peek());//Peek después de un pop debe mostrar el nuevo elemento en la cima.
    }

    @Test
    void testPeekEmpty() {
    	//Lanza la excepcion EmptyStackException al intentar peek en una pila vacía.       	
    	assertThrows(EmptyStackException.class, () -> stack.peek());	    	
    }

    @Test
    void testEmpty() {
    	//La pila debería estar vacía inicialmente.
        assertTrue(stack.empty()); 
        stack.push(60);
        //La pila no debería estar vacía después de push.
        assertEquals(false,stack.empty()); 
        stack.pop();
        assertTrue(stack.empty());//La pila debería estar vacía de nuevo después de pop de todos los elementos.
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
