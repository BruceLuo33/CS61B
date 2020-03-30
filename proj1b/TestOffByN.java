import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offBy5 = new OffByN(5);

    @Test
    public void testOffByN() {
        char var1 = 'a';
        char var2 = 'f';
        boolean isequal = offBy5.equalChars(var1, var2);
        assertTrue(isequal);
    }
}
