public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            wordDeque.addLast((char) tmp);
        }
        return wordDeque;
    }

    public boolean isPalindrome(Deque<Character> d) {
        while (d.size() > 1) {
            return d.removeFirst() == d.removeLast() && isPalindrome(d);
        }
        return true;
    }

    public boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindrome(wordToDeque(word), cc);
    }

    public boolean isPalindrome(Deque<Character> d, CharacterComparator cc) {
        while (d.size() > 1 ) {
            return cc.equalChars(d.removeFirst(), d.removeLast()) && isPalindrome(d, cc);
        }
        return true;
    }

    
//        Deque<Character> PalindromeOne = wordToDeque(word);
//        Deque<Character> PalindromeTwo = new ArrayDeque<>();
//        for (int i = 0; i < word.length(); i++) {
//            char tmp = word.charAt(i);
//            PalindromeTwo.addFirst((char) tmp);
//        }
//        for (int i = 0; i < word.length(); i++) {
//            if (PalindromeOne.removeFirst() != PalindromeTwo.removeFirst()) {
//                return false;
//            }
//        }
//        return true;
//    }

//    public boolean isPalindrome(String word, CharacterComparator cc) {
//        if (word.length() == 0 || word.length() == 1) {
//            return true;
//        }
//        Deque<Character> PalindromeOne = wordToDeque(word);
//        Deque<Character> PalindromeTwo = new ArrayDeque<>();
//        for (int i = 0; i < word.length(); i++) {
//            char tmp = word.charAt(i);
//            PalindromeTwo.addFirst((char) tmp);
//        }
//        for (int i = 0; i < word.length(); i++) {
//            if (!cc.equalChars((char) PalindromeOne.removeFirst(), (char) PalindromeTwo.removeFirst())) {
//                return false;
//            }
//        }
//        return true;
//    }


}
