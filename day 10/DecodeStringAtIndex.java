class Solution {
    public String decodeAtIndex(String s, int k) {
        long decodedLength = 0; // Track the length of the decoded string as a long to handle large values.
        
        // Calculate the decoded length without actually decoding the string.
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = c - '0';
                decodedLength *= digit;
            } else {
                decodedLength++;
            }
        }
        
        // Traverse the string in reverse order to find the k-th character.
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = c - '0';
                decodedLength /= digit; // Reduce the decoded length.
                k %= decodedLength; // Adjust k to the corresponding position in the repeated sequence.
            } else {
                if (k == 0 || k == decodedLength) {
                    return String.valueOf(c); // Found the k-th character.
                }
                decodedLength--;
            }
        }
        
        return ""; // Should not reach here.
    }
}
