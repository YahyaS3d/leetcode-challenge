class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false; // If the string length is odd, it can't be valid.
        }
        
        char[] stack = new char[n];
        int top = 0; // Index to keep track of the top of the stack.

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c;
            } else if (top == 0 || (c == ')' && stack[--top] != '(') || (c == ']' && stack[--top] != '[') || (c == '}' && stack[--top] != '{')) {
                return false;
            }
        }

        return top == 0;
    }
}
