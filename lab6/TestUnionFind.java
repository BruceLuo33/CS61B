import org.junit.Test;
import static org.junit.Assert.*;

public class TestUnionFind {

//    @Test
    public void testBasic() {
        UnionFind uf = new UnionFind(10);
        //Test size

        int expected = 1;
        int actural = uf.sizeOf(3);
        assertEquals(expected, actural);

        //Test parent method
        expected = -1;
        actural = uf.parent(2);
        assertEquals(expected, actural);

        // Test connect method
        assertFalse(uf.connected(2,3));

        // Test find method
        expected = 2;
        actural = uf.find(2);
        assertEquals(expected, actural);

    }

    @Test
    public void testUnion() {
        UnionFind uf = new UnionFind(10);

        // Union the disjointed sets with one layer
        uf.union(4,3);
        int expected = 4;
        int actural = uf.find(3);
        assertEquals(expected, actural);

        uf.union(3,8);
        actural = uf.find(8);
        assertEquals(expected,actural);

        uf.union(6,5);
        uf.union(9,4);
        assertEquals(4, uf.find(9));
        uf.union(2,1);
        assertEquals(2, uf.find(1));


        uf.union(8,9);
        int expectedParent = 4;
        int acturalParent = uf.parent(8);
        assertEquals(expectedParent, acturalParent);

        uf.union(5,0);
        uf.union(7,2);
        uf.union(6,1);
        expected = 6;
        actural = uf.find(7);
        assertEquals(expected, actural);

        assertTrue(uf.connected(1,7));



    }

}
