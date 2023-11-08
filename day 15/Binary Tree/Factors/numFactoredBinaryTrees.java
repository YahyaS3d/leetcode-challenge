import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1000000007;
        Arrays.sort(arr); // Sort the array
        int N = arr.length;
        long[] dp = new long[N]; // Initialize a dynamic programming array

        Arrays.fill(dp, 1); // Initialize all elements to 1 since each element itself can be a valid tree

        Map<Integer, Integer> index = new HashMap<>(); // Create a map to store the index of each element in the array
        for (int i = 0; i < N; i++) {
            index.put(arr[i], i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int otherFactor = arr[i] / arr[j];
                    if (index.containsKey(otherFactor)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(otherFactor)]) % MOD;
                    }
                }
            }
        }

        long total = 0;
        for (long num : dp) {
            total = (total + num) % MOD;
        }

        return (int) total;
    }
}
