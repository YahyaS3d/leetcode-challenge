//--> O(log n)
//   This is MountainArray's API interface.
//    You should not implement it, or speculate about its implementation
//   interface MountainArray {
//       public int get(int index) {}
//       public int length() {}
//   }
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        int peakIndex = findPeakIndex(mountainArr, n);
        
        int index = binarySearch(target, mountainArr, 0, peakIndex, true);
        if (index != -1) {
            return index;
        }
        
        return binarySearch(target, mountainArr, peakIndex, n - 1, false);
    }
    
    private int findPeakIndex(MountainArray mountainArr, int n) {
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
        return left;
    }
    
    private int binarySearch(int target, MountainArray mountainArr, int left, int right, boolean increasing) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                if (increasing) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (increasing) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
