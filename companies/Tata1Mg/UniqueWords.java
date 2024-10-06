package companies.mongodb;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class UniqueWords {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "orange", "banana", "grape"};
        List<String> uniqueList = uniqueWords(words);
        System.out.println(uniqueList);
    }
    public static List<String> uniqueWords(String[] words){
        LinkedHashSet<String> uniqueSet = new LinkedHashSet<>();

        for (String word : words) {
            uniqueSet.add(word);
        }

        return new ArrayList<>(uniqueSet);
    }
}
