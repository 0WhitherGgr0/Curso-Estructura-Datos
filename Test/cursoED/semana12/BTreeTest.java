package cursoED.semana12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BTreeTest {
    BTree tree = new BTree(3);

    @Test
    void testBTree() {
        assertNotNull(tree);
        assertEquals("", tree.display());
    }

    @Test
    void testInsert() {
        tree.insert(10);
        assertEquals("10", tree.display());
        tree.insert(20);
        assertEquals("10 20", tree.display());
        tree.insert(5);
        assertEquals("5 10 20", tree.display());
        tree.insert(6);
        assertEquals("5 6 10 20", tree.display());
        tree.insert(12);
        assertEquals("5 6 10 12 20", tree.display());
        tree.insert(30);
        assertEquals("5 6 30 10 12 20", tree.display());
        tree.insert(7);
        assertEquals("5 6 7 30 10 12 20", tree.display());
        tree.insert(17);
        assertEquals("5 6 7 30 10 12 17 20", tree.display());
    }

    @Test
    void testDisplay() {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        String expected = "1 2 3 4 5";
        assertEquals(expected, tree.display());

        tree = new BTree(3);
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(30);
        tree.insert(7);
        tree.insert(17);
        expected = "5 6 7 30 10 12 17 20";
        assertEquals(expected, tree.display());
    }

    @Test
    void testSearch() {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        assertNotNull(tree.search(1));
        assertNotNull(tree.search(2));
        assertNotNull(tree.search(3));
        assertNotNull(tree.search(4));
        assertNotNull(tree.search(5));
        assertNull(tree.search(6));

        tree = new BTree(3);
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(30);
        tree.insert(7);
        tree.insert(17);

        assertNotNull(tree.search(10));
        assertNotNull(tree.search(20));
        assertNotNull(tree.search(5));
        assertNotNull(tree.search(6));
        assertNotNull(tree.search(12));
        assertNotNull(tree.search(7));
        assertNotNull(tree.search(17));
        assertNull(tree.search(100));
    }
}
