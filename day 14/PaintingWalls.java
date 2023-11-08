class Solution {
    public int paintWalls(int[] cost, int[] time) {
        final int n = cost.length;
        int[][] dp = new int[n][n + 1];
        int kMax = 500_000_000;

        return findMinimumCost(cost, time, dp, 0, n, kMax);
    }

    private int findMinimumCost(int[] cost, int[] time, int[][] dp, int i, int walls, int kMax) {
        if (walls <= 0){
            return 0;
        }
        if (i == cost.length){
            return kMax;
        }
            
        if (dp[i][walls] > 0){
           return dp[i][walls];
        }
            

        final int pick = cost[i] + findMinimumCost(cost, time, dp, i + 1, walls - time[i] - 1, kMax);
        final int skip = findMinimumCost(cost, time, dp, i + 1, walls, kMax);

        return dp[i][walls] = Math.min(pick, skip);
    }
}

//--> O(n^2) 