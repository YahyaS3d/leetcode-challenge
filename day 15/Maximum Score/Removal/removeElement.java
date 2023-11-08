class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Initialize the count of elements not equal to val
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                // If the current element is not equal to val, copy it to the k-th position
                nums[k] = nums[i];
                k++;
            }
        }
        
        return k; // k is the count of elements not equal to val
    }
}
// TC --> O(n)