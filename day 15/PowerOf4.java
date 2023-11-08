public class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }

        // Check if n is a power of 2
        if ((n & (n - 1)) != 0) {
            return false;
        }

        // Check if the number of trailing zeros is even
        int count = 0;
        while ((n & 1) == 0) {
            n >>= 1;
            count++;
        }

        return count % 2 == 0;
    }
}
