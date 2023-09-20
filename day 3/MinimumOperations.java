class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int targetSum = Arrays.stream(nums).sum() - x; // Find the target sum to reach

        if (targetSum == 0)
            return n; // If the target sum is 0, it means we need to remove all elements

        int left = 0;
        int minOperations = Integer.MAX_VALUE;
        int currentSum = 0;

        for (int right = 0; right < n; right++) {
            currentSum += nums[right];

            while (currentSum > targetSum && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            if (currentSum == targetSum) {
                int operations = n - (right - left + 1); // Calculate the number of operations
                minOperations = Math.min(minOperations, operations);
            }
        }

        return minOperations == Integer.MAX_VALUE ? -1 : minOperations;
    }
}
