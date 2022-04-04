package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String input = "AlgoExpert is the best!";
        System.out.println(new ReverseWordsInString().reverseWordsInString(input));
    }

    public String reverseWordsInString(String string) {
        List<String> words = new ArrayList<>();
        int startOfWord = 0;

        for (int idx = 0; idx < string.length(); idx++) {
            char character = string.charAt(idx);

            if (character == ' ') {
                words.add(string.substring(startOfWord, idx));
                startOfWord = idx;
            } else if (string.charAt(startOfWord) == ' '){
               words.add(" ");
               startOfWord=idx;
            }
        }
        words.add(string.substring(startOfWord));
        Collections.reverse(words);
        // Write your code here.
        return String.join("", words);
    }
}
