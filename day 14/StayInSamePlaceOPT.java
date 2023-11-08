class Solution {
    public int numWays(int steps, int arrLen) {
        final int kMod = 1_000_000_007;
        final int n = Math.min(arrLen, steps / 2 + 1);
        Long[][] memo = new Long[steps + 1][n];
        return (int) helper(steps, 0, n, memo, kMod);
    }

    private long helper(int steps, int position, int n, Long[][] memo, int kMod) {
        if (steps == 0) {
            return (position == 0) ? 1 : 0;
        }

        if (memo[steps][position] != null) {
            return memo[steps][position];
        }

        long ways = helper(steps - 1, position, n, memo, kMod);
        if (position > 0) {
            ways += helper(steps - 1, position - 1, n, memo, kMod);
        }
        if (position < n - 1) {
            ways += helper(steps - 1, position + 1, n, memo, kMod);
        }
        ways %= kMod;
        memo[steps][position] = ways;
        return ways;
    }
}
//optimized solution 