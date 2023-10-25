class Solution(object):
    def kthGrammar(self, n, k):
        k -= 1  # Adjust k to be zero-indexed
        result = 0

        for i in range(n - 1):
            if k & 1:
                result = 1 - result
            k >>= 1  # Right shift k to simulate the row above

        return result