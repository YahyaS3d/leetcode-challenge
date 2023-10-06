class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        // Initialize variables to store the maximum product
        int maxProduct = 1;

        while (n > 4) {
            maxProduct *= 3;
            n -= 3;
        }

        // Multiply the remaining n by maxProduct
        return maxProduct * n;
    }
}
//--> O(n) 