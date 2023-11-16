import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
        arr[0] = 1; // Set the first element to 1

        // Iterate through the array and update each element
        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }

        return arr[n - 1]; // Return the maximum element in the updated array
    }
}


