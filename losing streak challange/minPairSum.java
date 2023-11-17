import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        // Sort the array in ascending order
        Arrays.sort(nums);

        int n = nums.length;
        int maxPairSum = Integer.MIN_VALUE;

        // Pair up the elements from the two ends of the sorted array
        for (int i = 0; i < n / 2; i++) {
            int pairSum = nums[i] + nums[n - 1 - i];
            // Update the maximum pair sum if the current pair sum is greater
            maxPairSum = Math.max(maxPairSum, pairSum);
        }

        return maxPairSum;
    }
}
