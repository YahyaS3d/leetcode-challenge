class Solution(object):
    def longestPalindromeSubseq(self, s):
        n = len(s)
        
        # Initialize a 1D DP array to store the lengths of the longest palindromic subsequence
        dp = [0] * n
        
        for i in range(n - 1, -1, -1):
            # Initialize the diagonal element to 1
            dp[i] = 1
            prev = 0  # Stores the value of dp[i+1][j-1]
            for j in range(i + 1, n):
                temp = dp[j]  # Stores the value of dp[i][j-1]
                if s[i] == s[j]:
                    dp[j] = prev + 2
                else:
                    dp[j] = max(dp[j], dp[j - 1])
                prev = temp
        
        # The last element of the DP array stores the length of the longest palindromic subsequence
        return dp[n - 1]
