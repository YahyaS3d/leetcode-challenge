class Solution {
    public int countHomogenous(String s) {
        final int MOD = 1000000007;
        int ans = 0;
        int count = 0;
        char currentChar = '@';

        for (final char c : s.toCharArray()) {
            count = c == currentChar ? count + 1 : 1;
            currentChar = c;

            // Calculate homogenous substrings and add to the total count
            // ans = (ans + (count * (count + 1) / 2) % MOD) % MOD;
            ans += count;
            ans %= MOD;
        }

        return ans;
    }
}
