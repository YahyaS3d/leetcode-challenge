//same answer as before 
// trying to fix up run time and memory usage! 


class Solution {
    public String smallestSubsequence(String s) {
        int[] lastOccurrence = new int[26];
        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack<>();
        
        // Record the last occurrence index of each character.
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // Skip characters that are already in the stack or already used.
            if (used[c - 'a']) {
                continue;
            }
            
            // Pop characters from the stack if they are greater than the current character
            // and there are more occurrences of them later in the string.
            while (!stack.isEmpty() && c < stack.peek() && i < lastOccurrence[stack.peek() - 'a']) {
                used[stack.pop() - 'a'] = false;
            }
            
            // Push the current character onto the stack and mark it as used.
            stack.push(c);
            used[c - 'a'] = true;
        }
        
        // Build the result string from the characters in the stack.
        StringBuilder result = new StringBuilder(stack.size());
        for (char c : stack) {
            result.append(c);
        }
        
        return result.toString();
    }
}
