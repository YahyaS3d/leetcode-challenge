import java.util.ArrayList;
import java.util.List;

class Solution {
    public String reverseWords(String s) {
        // Split the input string into words using space as the delimiter
        String[] words = s.split(" ");
        
        // Initialize a List to store the result
        List<String> result = new ArrayList<>();
        
        // Iterate through the words
        for (String word : words) {
            // Reverse each word using object cloning and add it to the result
            String reversedWord = reverseWord(word);
            result.add(reversedWord);
        }
        
        // Join the reversed words with spaces and return the result
        return String.join(" ", result);
    }
    
    // Helper function to reverse a word using object cloning
    private String reverseWord(String word) {
        StringBuilder reversed = new StringBuilder(word.length());
        
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed.append(word.charAt(i));
        }
        
        return reversed.toString();
    }
}
