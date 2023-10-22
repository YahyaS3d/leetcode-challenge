class Solution(object):
    def maximumScore(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        n = len(nums)
        result = 0
        
        # Find the minimum value to the left and right of k
        left_min = nums[k]
        right_min = nums[k]
        
        # Initialize pointers for the sliding window
        left = k
        right = k
        
        while left >= 0 and right < n:
            left_min = min(left_min, nums[left])
            right_min = min(right_min, nums[right])
            
            # Calculate the score for the current subarray
            score = min(left_min, right_min) * (right - left + 1)
            result = max(result, score)
            
            # Expand the subarray by moving the pointers
            if left == 0:
                right += 1
            elif right == n - 1:
                left -= 1
            elif nums[left - 1] >= nums[right + 1]:
                left -= 1
            else:
                right += 1
    
        return result
