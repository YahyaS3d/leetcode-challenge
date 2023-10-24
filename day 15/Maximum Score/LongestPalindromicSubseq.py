class Solution(object):
    def longestPalindromeSubseq(self, s):
        n = len(s)
        
        # Initialize a 2D DP array to store the lengths of the longest palindromic subsequence
        dp = [[0] * n for _ in range(n)]
        
        # Each character in the string is a palindrome by itself, so initialize the diagonal elements to 1
        for i in range(n):
            dp[i][i] = 1
        
        # Loop through the string and fill in the DP table
        for cl in range(2, n + 1):
            for i in range(n - cl + 1):
                j = i + cl - 1
                if s[i] == s[j]:
                    dp[i][j] = dp[i + 1][j - 1] + 2
                else:
                    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
        
        # The top-right element of the DP table stores the length of the longest palindromic subsequence
        return dp[0][n - 1]
