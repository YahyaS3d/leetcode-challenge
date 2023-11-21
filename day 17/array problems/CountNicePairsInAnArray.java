import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countNicePairs(int[] nums) {
        final int MOD = 1_000_000_007;
        int count = 0;

        // Map to store the frequency of differences
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            // Calculate the difference between the number and its reverse
            int diff = num - reverse(num);

            // Count the nice pairs for the current difference
            count = (count + frequencyMap.getOrDefault(diff, 0)) % MOD;

            // Update the frequency map
            frequencyMap.put(diff, frequencyMap.getOrDefault(diff, 0) + 1);
        }

        return count;
    }

    // Helper function to reverse a number
    private int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}
