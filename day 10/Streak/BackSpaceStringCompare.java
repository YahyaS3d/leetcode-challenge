class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }
    
    private String buildString(String str) {
        StringBuilder result = new StringBuilder();
        int backspaceCount = 0;
        
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == '#') {
                backspaceCount++;
            } else if (backspaceCount > 0) {
                backspaceCount--;
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}
//-->O(n)