import java.util.Arrays;

class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int operations = 0;
        int currentOperations = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                currentOperations++;
            }
            operations += currentOperations;
        }

        return operations;
    }
}
