import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // Remove elements that are out of the window
            while (!deque.isEmpty() && deque.getFirst() < i - k) {
                deque.pollFirst();
            }

            // Calculate the maximum sum up to index i
            dp[i] = Math.max(nums[i], nums[i] + (deque.isEmpty() ? 0 : dp[deque.getFirst()]));

            // Remove elements that are less than dp[i]
            while (!deque.isEmpty() && dp[i] >= dp[deque.getLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
