import java.util.Arrays;

class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int max1 = nums[n - 1];
        int max2 = nums[n - 2];
        int min1 = nums[0];
        int min2 = nums[1];

        return (max1 * max2) - (min1 * min2);
    }
}


//O(n log n) due to the sorting operation