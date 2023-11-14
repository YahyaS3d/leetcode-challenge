class Solution {
    public int countPalindromicSubsequence(String s) {
        int result = 0;

        // Iterate through each unique character in the string
        for (char c = 'a'; c <= 'z'; c++) {
            int firstOccurrence = s.indexOf(c);
            int lastOccurrence = s.lastIndexOf(c);

            // Check if the character appears at least twice in the string
            if (firstOccurrence != -1 && firstOccurrence < lastOccurrence) {
                // Find unique characters between the first and last occurrence
                Set<Character> uniqueChars = new HashSet<>();
                for (int i = firstOccurrence + 1; i < lastOccurrence; i++) {
                    uniqueChars.add(s.charAt(i));
                }

                // Count the unique characters, which form palindromic subsequences of length three
                result += uniqueChars.size();
            }
        }

        return result;
    }
}
