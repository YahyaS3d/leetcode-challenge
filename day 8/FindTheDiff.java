// Initialize an array count to keep track of the count of each lowercase letter.
// Iterate through string s and decrement the count for each character.
// Iterate through string t and increment the count for each character.
// Finally, iterate through the count array and find the character with a count greater than 0.

//--> That character is the extra character added to string t.

// we know that t is greater than s. so we can use this algorithm 
//the time complexity is linear with respect to the length of string t, which is the longer of the two strings

//--->  O(n), where n is the length of string t.

class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26]; // Assuming lowercase English letters
        //run for every letter in s
        for (char ch : s.toCharArray()) {
            count[ch - 'a']--;
        }
        //run for every letter in t
        for (char ch : t.toCharArray()) {
            count[ch - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                return (char) ('a' + i);
            }
        }
        
        return ' '; // This line should not be reached if input is valid
    }
}