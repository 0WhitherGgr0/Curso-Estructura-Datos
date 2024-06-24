package cursoED.semana12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

class SplayTreeTest {

    SplayTree<Integer> st = new SplayTree<>();
    SplayTree<String> STree = new SplayTree<>();

    @Test
    void testSplayTree() {
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
    	STree.insert("P");
    	STree.insert("N");
        STree.insert("Q");
        STree.insert("A");
        STree.insert("B");

        // Initial Tree after insertions:
        //   B
        // /  \
        // A   N
        // 	    \
        //    	 P
        // 	      \
        // 	       Q

        assertEquals("B", STree.getRoot().key);
        assertEquals("A", STree.getRoot().left.key);
        assertEquals("N", STree.getRoot().right.key);
        assertEquals("P", STree.getRoot().right.right.key);
        assertEquals("Q", STree.getRoot().right.right.right.key);
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
    	STree.insert("P");
    	STree.insert("X");
    	STree.insert("C");
    	STree.insert("A");
    	STree.insert("B");

    	STree.remove("A");
    	STree.remove("B");

        // Tree:
        // C
        //   \ 
        //    P
        //    	\
        //		 X
        assertEquals("C", STree.getRoot().key);
        assertEquals("P", STree.getRoot().right.key);
        assertEquals("X", STree.getRoot().right.right.key);

    }

    @Test
    void testRemoveObjectNotFind() {
    	STree.insert("M");
    	STree.insert("A");
    	STree.insert("C");

        // Initial Tree:
        //   C
        // / \
        // A  M

        assertEquals("C", STree.getRoot().key);
        assertEquals("A", STree.getRoot().left.key);
        assertEquals("M", STree.getRoot().right.key);
        STree.remove("M");

        // Tree:
        // C
        // / 
        // A 

        assertEquals("C", STree.getRoot().key);
        assertEquals("A", STree.getRoot().left.key);

        assertThrows(NoSuchElementException.class, () -> STree.remove("M"));
    }

    @Test
    void testFindMin() {
    	STree.insert("P");
    	STree.insert("X");
    	STree.insert("C");
    	STree.insert("A");
    	STree.insert("B");

        // Initial Tree after insertions:
        //   P
        // /  \
        // C   X
    //    /    \
    //    A    	 P
        // \      \
        // 	B       Q
        assertEquals("A", STree.findMin());
        
        assertEquals("A", STree.getRoot().key);
        assertEquals("B", STree.getRoot().right.key);
        assertEquals("C", STree.getRoot().right.right.key);
        assertEquals("P", STree.getRoot().right.right.right.key);
        assertEquals("X", STree.getRoot().right.right.right.right.key);
      
        // Initial Tree after insertions:
        // 		 A
        // 		  \
        // 	       B
    	//           \
    	//            C
        // 		       \
        // 		        P
    	//				  \
        //					X
        String expected = "A B C P X";
        assertEquals(expected,STree.display());

    }

    @Test
    void testFindMinNull() {
        assertNull(st.findMin());
    }


    @Test
    void testFindMax() {
    	STree.insert("P");
    	STree.insert("X");
    	STree.insert("C");
    	STree.insert("A");
    	STree.insert("B");
  
        // Initial Tree after insertions:
        // 		  B
        // 		/  \
        // 	    A   C
    	//           \
    	//            P
        // 		       \
        // 		        X
    	
        assertEquals("B", STree.getRoot().key);
        assertEquals("C", STree.getRoot().right.key);
        assertEquals("P", STree.getRoot().right.right.key);
        assertEquals("A", STree.getRoot().left.key);
        assertEquals("X", STree.getRoot().right.right.right.key);

        
        assertEquals("X", STree.findMax());
     // Initial Tree after insertions:
        // 		  X
        // 		/  
        // 	   C   
    	//    / \    
    	//   B   P    
        // 	/	
        // A	
        assertEquals("X", STree.getRoot().key);
        assertEquals("C", STree.getRoot().left.key);
        assertEquals("P", STree.getRoot().left.right.key);
        assertEquals("A", STree.getRoot().left.left.left.key);
        assertEquals("B", STree.getRoot().left.left.key);

        String expected = "A B C P X";
        assertEquals(expected,STree.display());
   
    }

    @Test
    void testFindMaxNull() {
        assertNull(st.findMax());
    }

    @Test
    void testFind() {
    	STree.insert("P");
    	STree.insert("X");
    	STree.insert("C");
    	STree.insert("A");
    	STree.insert("B");
    	
        // Initial Tree after insertions:
        // 		  B
        // 		/  \
        // 	    A   C
    	//           \
    	//            P
        // 		       \
        // 		        X
    	
        assertEquals("B", STree.getRoot().key);
        assertEquals("C", STree.getRoot().right.key);
        assertEquals("P", STree.getRoot().right.right.key);
        assertEquals("A", STree.getRoot().left.key);
        assertEquals("X", STree.getRoot().right.right.right.key);

        
        assertEquals("A", STree.find("A"));
        

        assertEquals("A", STree.getRoot().key);
        assertEquals("B", STree.getRoot().right.key);
        assertEquals("C", STree.getRoot().right.right.key);
        assertEquals("P", STree.getRoot().right.right.right.key);
        assertEquals("X", STree.getRoot().right.right.right.right.key);

        
        String expected = "A B C P X";
        assertEquals(expected,STree.display());
        
        assertNull(STree.find("L"));
    }

    @Test
    void testFindNull() {
        assertNull(st.find(100));
    }

    @Test
    void testIsEmpty() {
        assertTrue(st.isEmpty());
        STree.insert("P");
        STree.insert("C");
        STree.insert("A");
        STree.insert("B");
        assertFalse(STree.isEmpty());
    }

 
}
