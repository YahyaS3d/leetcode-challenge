class Solution {
    public int getWinner(int[] arr, int k) {
        int current = arr[0]; // Initialize the current winner as the first element
        int consecutiveWins = 0; // Initialize consecutive wins counter
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > current) {
                current = arr[i];
                consecutiveWins = 1; // Reset consecutive wins count
            } else {
                consecutiveWins++;
            }
            if (consecutiveWins == k) {
                return current; // If the current integer wins k consecutive rounds, return it as the winner
            }
        }
        return current; // If we reach this point, the last integer in the array is the winner
    }
}
// TC --> O(n)