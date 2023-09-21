class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start with the first string as the prefix candidate
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // Compare the current prefix with the next string
            while (strs[i].indexOf(prefix) != 0) {
                // Reduce the prefix by one character at a time
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}


// public static void main(String[] args) {
//     String[] strs1 = {"flower", "flow", "flight"};
//     String[] strs2 = {"dog", "racecar", "car"};

//     System.out.println(longestCommonPrefix(strs1)); // Output: "fl"
//     System.out.println(longestCommonPrefix(strs2)); // Output: ""
// }