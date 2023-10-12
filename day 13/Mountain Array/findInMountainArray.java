//--> O(log n)

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // Binary search to find the peak element
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            int nextVal = mountainArr.get(mid + 1);
            
            if (midVal < nextVal) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        int peakIndex = left;
        
        // Binary search in the increasing sequence
        int index = binarySearchIncreasing(target, mountainArr, 0, peakIndex);
        if (index != -1) {
            return index;
        }
        
        // Binary search in the decreasing sequence
        return binarySearchDecreasing(target, mountainArr, peakIndex, n - 1);
    }
    
    private int binarySearchIncreasing(int target, MountainArray mountainArr, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    private int binarySearchDecreasing(int target, MountainArray mountainArr, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
