import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("abba"));
        assertTrue(palindrome.isPalindrome("madam"));
        assertFalse(palindrome.isPalindrome("abatement"));
    }

    @Test
    public void testWhetherPalindrome() {
        OffByOne obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertTrue(palindrome.isPalindrome("", obo));
        assertTrue(palindrome.isPalindrome("c", obo));
        assertFalse(palindrome.isPalindrome("abba", obo));
    }


//    Uncomment this class once you've created your Palindrome class.
}
