class Solution {
    public int countVowelPermutation(int n) {
        int MOD = 1000000007;
        
        // Initialize the dp array
        long[][] dp = new long[n + 1][5];
        
        // Initialize the base case (strings of length 1)
        for (int j = 0; j < 5; j++) {
            dp[1][j] = 1;
        }
        
        // Populate the dp array for each length from 2 to n
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % MOD; // 'a'
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD; // 'e'
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % MOD; // 'i'
            dp[i][3] = (dp[i - 1][2]) % MOD; // 'o'
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % MOD; // 'u'
        }
        
        // Sum all valid strings of length n
        long count = 0;
        for (int j = 0; j < 5; j++) {
            count = (count + dp[n][j]) % MOD;
        }
        
        return (int) count;
    }
}
