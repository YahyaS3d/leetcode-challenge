class Solution {
    public String removeDuplicateLetters(String s) {
        // Initialize a stack to store characters.
        Stack<Character> stack = new Stack<>();
        
        // Initialize an array to keep track of the count of each character in the string.
        int[] count = new int[26];
        
        // Initialize a boolean array to keep track of characters in the stack.
        boolean[] inStack = new boolean[26];
        
        // Count the occurrences of each character in the string.
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // Iterate through the string.
        for (char c : s.toCharArray()) {
            // Decrement the count of the current character.
            count[c - 'a']--;
            
            // If the character is already in the stack, skip it.
            if (inStack[c - 'a']) {
                continue;
            }
            
            // While there are characters in the stack, the current character is smaller than the character
            // at the top of the stack, and there are more occurrences of the character ahead in the string,
            // pop characters from the stack to maintain lexicographical order.
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }
            
            // Push the current character onto the stack and mark it as in the stack.
            stack.push(c);
            inStack[c - 'a'] = true;
        }
        
        // Build the result string from the characters in the stack.
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop()); // Insert characters at the beginning to maintain order.
        }
        
        return result.toString();
    }
}
//---> O(n)