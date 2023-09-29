class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                decreasing = false; // If we find an increasing pair, it's not decreasing
            } else if (nums[i] < nums[i - 1]) {
                increasing = false; // If we find a decreasing pair, it's not increasing
            }
            // If nums[i] == nums[i - 1], we can simply continue
        }
        
        // If both increasing and decreasing are still true, it's monotonic
        return increasing || decreasing;
    }
}
