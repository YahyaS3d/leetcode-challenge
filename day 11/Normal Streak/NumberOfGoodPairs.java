class Solution {
    public int numIdenticalPairs(int[] nums) {
        // Initialize a hashmap to store the count of each number
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Initialize a variable to store the total number of good pairs
        int totalGoodPairs = 0;
        
        // Iterate through the array and update the countMap
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Calculate the number of good pairs for each number and sum them up
        for (int count : countMap.values()) {
            totalGoodPairs += count * (count - 1) / 2;
        }
        
        return totalGoodPairs;
    }
}
