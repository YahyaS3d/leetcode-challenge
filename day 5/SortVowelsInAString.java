import java.util.ArrayList;
import java.util.List;

class Solution {
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        List<Character> vowels = new ArrayList<>();

        // Collect vowels and update the string with non-vowel placeholders
        for (char c : chars) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        // Sort the vowels
        vowels.sort(null);

        // Place the sorted vowels back into the original string at their respective indices
        int vowelIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                chars[i] = vowels.get(vowelIndex++);
            }
        }

        return new String(chars);
    }

    // Helper method to check if a character is a vowel
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
