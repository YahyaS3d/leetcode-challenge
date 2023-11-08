class Solution(object):
    def numOfArrays(self, n, m, k):
        MOD = 10**9 + 7
        
        # Create a 3D DP array dp[i][j][cost]:
        # dp[i][j][cost] represents the number of ways to build an array of length i
        # where the maximum element is j and the search cost is cost.
        dp = [[[0] * (k + 1) for _ in range(m + 1)] for _ in range(n + 1)]
        
        # Initialize dp array for base cases
        for j in range(1, m + 1):
            dp[1][j][1] = 1
        
        # Calculate dp array using dynamic programming
        for i in range(2, n + 1):
            for j in range(1, m + 1):
                for cost in range(1, k + 1):
                    dp[i][j][cost] = (j * dp[i - 1][j][cost] + sum(dp[i - 1][prev_max][cost - 1] for prev_max in range(1, j))) % MOD
        
        # Sum up the results for different maximum elements
        result = sum(dp[n][j][k] for j in range(1, m + 1)) % MOD
        
        return result
