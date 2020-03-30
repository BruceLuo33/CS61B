//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    //    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    // This test is to verify whether equalCharts works.

    @Test
    public void testOffByone() {
        char var1 = 'a';
        char var2 = 'b';
        boolean isequal = offByOne.equalChars(var1, var2);
        assertTrue(isequal);
    }



//    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
}
