package cursoED.semana12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SplayTreeTest {

	SplayTree st = new SplayTree();

	@Test
	void testSplayTree() {
		SplayTree STree = new SplayTree();
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

		assertEquals(11, st.root.key);
		assertEquals(10, st.root.left.key);
		assertEquals(20, st.root.right.key);
		assertEquals(40, st.root.right.right.key);
		assertEquals(5, st.root.left.left.key);

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

		assertEquals("B", st.root.key);
		assertEquals("A", st.root.left.key);
		assertEquals("N", st.root.right.key);
		assertEquals("P", st.root.right.right.key);
		assertEquals("Q", st.root.right.right.right.key);
		
	}

	@Test
	void testInsertTreeDuplicate() {
		st.insert(20);
		st.insert(10);
		st.insert(10);
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

		assertEquals(10, st.root.key);
		assertEquals(5, st.root.left.key);
		assertEquals(20, st.root.right.key);
		st.remove(20);
		//Tree:
		// 10
		// / 
		// 5 

		assertEquals(10, st.root.key);
		assertEquals(5, st.root.left.key);

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
		//Tree:
		// C
		//   \ 
		//    P
		//    	\
		//		 X
		assertEquals("C", st.root.key);
		assertEquals("P", st.root.right.key);
		assertEquals("X", st.root.right.right.key);
		
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

		assertEquals("C", st.root.key);
		assertEquals("A", st.root.left.key);
		assertEquals("M", st.root.right.key);
		st.remove("M");
		//Tree:
		// C
		// / 
		// A 

		assertEquals("C", st.root.key);
		assertEquals("A", st.root.left.key);		
		
		st.remove("M");
		//Tree:
		// C
		// / 
		// A 

		
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
		st.find("A");
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

	/*@Test
	void testmoveToRoot() {
		st.insert(20);
		st.insert(10);
		st.insert(5);
		st.insert(11);
		st.insert(40);
		st.insert(25);
		st.insert(30);

		// Initial Tree:
		// 30
		// / \
		// 11 40
		// / \
		// 5 25
		// \ /
		// 10 20

		// Move 25 to root
		st.moveToRoot(25);
		// Expected Tree after moving 25 to root:
		// 25
		// / \
		// 11 30
		// / \ \
		// 5 20 40
		// \
		// 10
		assertEquals(25, st.root.key);
	}

	@Test
	void testmoveToRootEqualsKey() {
		st.insert(20);
		st.moveToRoot(20);
	}

	@Test
	void testmoveToRootMenor() {
		st.insert(20);
		st.insert(5);
		st.insert(10);

		// Initial Tree:
		// 10
		// / \
		// 5 20

		assertEquals(10, st.root.key);
		assertEquals(5, st.root.left.key);
		assertEquals(20, st.root.right.key);
		st.moveToRoot(5);
		// Tree:
		// 5
		// \
		// 10
		// \
		// 20
		assertEquals(5, st.root.key);
		assertEquals(10, st.root.right.key);
		assertEquals(20, st.root.right.right.key);

		st.moveToRoot(20);

		assertEquals(20, st.root.key);
		assertEquals(5, st.root.left.key);
		assertEquals(10, st.root.left.right.key);
		// Tree:
		// 20
		// /
		// 5
		// \
		// 10
		st.moveToRoot(10);

		// Tree:
		// 10
		// / \
		// 5 20
		assertEquals(10, st.root.key);
		assertEquals(5, st.root.left.key);
		assertEquals(20, st.root.right.key);

		st.moveToRoot(20);
		// Tree:
		// 20
		// /
		// 10
		// /
		// 5
		assertEquals(20, st.root.key);
		assertEquals(10, st.root.left.key);
		assertEquals(5, st.root.left.left.key);

		st.moveToRoot(10);

	}
*/
}
