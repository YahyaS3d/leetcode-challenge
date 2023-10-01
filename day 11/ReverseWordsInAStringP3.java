class Solution {
    public String reverseWords(String s) {
        // Split the input string into words using space as the delimiter
        String[] words = s.split(" ");
        
        // Initialize a StringBuilder to store the result
        StringBuilder result = new StringBuilder();
        
        // Iterate through the words
        for (String word : words) {
            // Reverse each word and append it to the result
            String reversedWord = reverseWord(word);
            result.append(reversedWord).append(" ");
        }
        
        // Remove the trailing space and return the result
        return result.toString().trim();
    }
    
    // Helper function to reverse a word
    private String reverseWord(String word) {
        char[] wordChars = word.toCharArray();
        int left = 0;
        int right = wordChars.length - 1;
        
        while (left < right) {
            char temp = wordChars[left];
            wordChars[left] = wordChars[right];
            wordChars[right] = temp;
            left++;
            right--;
        }
        
        return new String(wordChars);
    }
}
