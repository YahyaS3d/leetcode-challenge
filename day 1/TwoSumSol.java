import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store numbers and their indices.
        Map<Integer, Integer> numIndices = new HashMap<>();

        // Iterate through the array.
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement is already in the map.
            if (numIndices.containsKey(complement)) {
                // If found, return the indices of the two numbers.
                return new int[]{numIndices.get(complement), i};
            }

            // Otherwise, add the current number and its index to the map.
            numIndices.put(nums[i], i);
        }

        // If no solution is found, return an empty array or handle it as needed.
        return new int[]{};
    }
}
