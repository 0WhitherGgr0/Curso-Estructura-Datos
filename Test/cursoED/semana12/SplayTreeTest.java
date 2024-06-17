package cursoED.semana12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

class SplayTreeTest {

    SplayTree st = new SplayTree();

    @Test
    void testSplayTree() {
        SplayTree STree = new SplayTree();
        assertNotNull(STree);
    }

    @Test
    void testInsert() {
        st.insert(20);
        st.insert(10);
        st.insert(40);
        st.insert(5);
        st.insert(11);

        // Initial Tree after insertions:
        // 11
        // / \
        // 10 20
        // 	/	\
        // 5	40

        assertEquals(11, st.getRoot().key);
        assertEquals(10, st.getRoot().left.key);
        assertEquals(20, st.getRoot().right.key);
        assertEquals(40, st.getRoot().right.right.key);
        assertEquals(5, st.getRoot().left.left.key);
    }

    @Test
    void testInsertTreeLetters() {
        st.insert("P");
        st.insert("N");
        st.insert("Q");
        st.insert("A");
        st.insert("B");

        // Initial Tree after insertions:
        //   B
        // /  \
        // A   N
        // 	    \
        //    	 P
        // 	      \
        // 	       Q

        assertEquals("B", st.getRoot().key);
        assertEquals("A", st.getRoot().left.key);
        assertEquals("N", st.getRoot().right.key);
        assertEquals("P", st.getRoot().right.right.key);
        assertEquals("Q", st.getRoot().right.right.right.key);
    }

    @Test
    void testInsertTreeDuplicate() {
        st.insert(20);
        st.insert(10);
        assertThrows(IllegalArgumentException.class, () -> st.insert(10));
    }

    @Test
    void testRemoveNumber() {
        st.insert(20);
        st.insert(5);
        st.insert(10);

        // Initial Tree:
        // 10
        // / \
        // 5 20

        assertEquals(10, st.getRoot().key);
        assertEquals(5, st.getRoot().left.key);
        assertEquals(20, st.getRoot().right.key);
        st.remove(20);

        // Tree:
        // 10
        // / 
        // 5 

        assertEquals(10, st.getRoot().key);
        assertEquals(5, st.getRoot().left.key);
    }

    @Test
    void testRemove() {
        st.insert("P");
        st.insert("X");
        st.insert("C");
        st.insert("A");
        st.insert("B");
        st.remove("A");
        st.remove("B");

        // Tree:
        // C
        //   \ 
        //    P
        //    	\
        //		 X
        assertEquals("C", st.getRoot().key);
        assertEquals("P", st.getRoot().right.key);
        assertEquals("X", st.getRoot().right.right.key);
    }

    @Test
    void testRemoveObjectNotFind() {
        st.insert("M");
        st.insert("A");
        st.insert("C");

        // Initial Tree:
        //   C
        // / \
        // A  M

        assertEquals("C", st.getRoot().key);
        assertEquals("A", st.getRoot().left.key);
        assertEquals("M", st.getRoot().right.key);
        st.remove("M");

        // Tree:
        // C
        // / 
        // A 

        assertEquals("C", st.getRoot().key);
        assertEquals("A", st.getRoot().left.key);

        assertThrows(NoSuchElementException.class, () -> st.remove("M"));
    }

    @Test
    void testFindMin() {
        st.insert("P");
        st.insert("X");
        st.insert("C");
        st.insert("A");
        st.insert("B");
        assertEquals("A", st.findMin());
    }

    @Test
    void testFindMinNull() {
        assertNull(st.findMin());
    }

    @Test
    void testFindMaxNumber() {
        st.insert(30);
        st.insert(20);
        st.insert(10);
        st.insert(5);
        assertEquals(30, st.findMax());
    }

    @Test
    void testFindMax() {
        st.insert("P");
        st.insert("X");
        st.insert("C");
        st.insert("A");
        st.insert("B");
        assertEquals("X", st.findMax());
    }

    @Test
    void testFindMaxNull() {
        assertNull(st.findMax());
    }

    @Test
    void testFind() {
        st.insert("P");
        st.insert("X");
        st.insert("C");
        st.insert("A");
        st.insert("B");
        assertEquals("A", st.find("A"));
        assertNull(st.find("L"));
    }

    @Test
    void testFindNull() {
        assertNull(st.find(100));
    }

    @Test
    void testIsEmpty() {
        assertTrue(st.isEmpty());
        st.insert("P");
        st.insert("C");
        st.insert("A");
        st.insert("B");
        assertFalse(st.isEmpty());
    }

 
}
