class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length()); //sort the words depending in word length 

        // Create a map to store the length of the longest chain ending with each word
        HashMap<String, Integer> chainLength = new HashMap<>();
        int maxChainLength = 1; // Initialize with a minimum length of 1

        // Iterate through each word in the sorted order
        for (String word : words) {
            int currentChainLength = 1; //(the word itself --> set it to 1)

            // Generate all possible predecessors by removing one character at a time
            for (int i = 0; i < word.length(); i++) {
                StringBuilder predecessor = new StringBuilder(word);
                predecessor.deleteCharAt(i);
                String predecessorStr = predecessor.toString();

                // Check if the predecessor exists in the map and update the chain length
                if (chainLength.containsKey(predecessorStr)) {
                    currentChainLength = Math.max(currentChainLength, chainLength.get(predecessorStr) + 1);
                }
            }

            // Update the chain length for the current word
            chainLength.put(word, currentChainLength);

            // Update the maximum chain length
            maxChainLength = Math.max(maxChainLength, currentChainLength);
        }

        return maxChainLength;
    }
}
