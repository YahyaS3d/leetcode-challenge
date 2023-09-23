import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length()); //sort words array by every word length

        HashMap<String, Integer> chainLength = new HashMap<>();
        int maxChainLength = 1; //the word itself will return 1 

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
//check init.txt for viewing time complexity issue!! 