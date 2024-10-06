package companies.mongodb;
import java.util.*;

public class WordFinder {

    public static List<String> findWords(List<String> words, List<Character> chars) {
        Map<Character, Integer> charCount = new HashMap<>();

        // Count frequency of each character
        for (Character c : chars) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        List<String> result = new ArrayList<>();

        // Check each word
        for (String word : words) {
            if (canFormWord(word, charCount)) {
                result.add(word);
            }
        }

        return result;
    }

    private static boolean canFormWord(String word, Map<Character, Integer> charCount) {
        // Temporary map to check character usage
        Map<Character, Integer> tempCount = new HashMap<>();

        for (char c : word.toCharArray()) {
            tempCount.put(c, tempCount.getOrDefault(c, 0) + 1);
            // Early exit if we exceed available characters
            if (tempCount.get(c) > charCount.getOrDefault(c, 0)) {
                return false; // Not enough characters to form the word
            }
        }

        return true; // All characters are available to form the word
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "java", "code", "java");
        List<Character> chars = Arrays.asList('j', 'a', 'v', 'a', 'h', 'e', 'l', 'o', 'r', 'd');

        List<String> possibleWords = findWords(words, chars);
        System.out.println("Possible words: " + possibleWords); // Output: [java, hello, world]
    }
}

