import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        
        // Step 1: Sort the input array nums
        Arrays.sort(nums);
        
        // Step 2: Remove duplicates and keep track of the new array length m
        int m = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[m++] = nums[i];
            }
        }
        
        // Step 3: Initialize the answer to the worst-case scenario (n operations)
        int ans = n;
        
        // Step 4: Iterate through the unique elements in the array
        for (int i = 0; i < m; ++i) {
            // Step 5: Use binary search to efficiently find the largest continuous subarray
            int j = search(nums, nums[i] + n - 1, i, m);
            
            // Step 6: Calculate the number of operations needed
            ans = Math.min(ans, n - (j - i));
        }
        
        // Step 7: Return the minimum number of operations
        return ans;
    }

    // Binary search function
    private int search(int[] nums, int x, int left, int right) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
