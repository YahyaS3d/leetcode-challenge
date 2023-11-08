class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        DotProductCalculatorFactory factory = new DotProductCalculatorFactory();
        DotProductCalculator calculator = factory.getDotProductCalculator();
        
        int[][] dp = new int[m][n];
        
        dp[0][0] = calculator.calculateDotProduct(nums1[0], nums2[0]);
        
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.max(calculator.calculateDotProduct(nums1[i], nums2[0]), dp[i - 1][0]);
        }
        
        for (int j = 1; j < n; j++) {
            dp[0][j] = Math.max(calculator.calculateDotProduct(nums1[0], nums2[j]), dp[0][j - 1]);
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int currentProduct = calculator.calculateDotProduct(nums1[i], nums2[j]);
                dp[i][j] = Math.max(currentProduct, Math.max(dp[i - 1][j], dp[i][j - 1]));
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + currentProduct);
            }
        }
        
        return dp[m - 1][n - 1];
    }
}