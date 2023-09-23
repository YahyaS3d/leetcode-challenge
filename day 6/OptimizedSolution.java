import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int longestStrChain(String[] words) {
        HashMap<String, Integer> chainLength = new HashMap<>();
        int maxChainLength = 1;

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word : words) {
            int currentChainLength = 1;

            for (int i = 0; i < word.length(); i++) {
                StringBuilder predecessor = new StringBuilder(word);
                predecessor.deleteCharAt(i);
                String predecessorStr = predecessor.toString();

                if (chainLength.containsKey(predecessorStr)) {
                    currentChainLength = Math.max(currentChainLength, chainLength.get(predecessorStr) + 1);
                }
            }

            chainLength.put(word, currentChainLength);
            maxChainLength = Math.max(maxChainLength, currentChainLength);
        }

        return maxChainLength;
    }
}

// The time complexity is improved to O(N * L^2).