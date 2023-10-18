class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n);
        int[] prereq = new int[n];

        for (int[] r : relations) {
            int prevCourse = r[0] - 1;
            int nextCourse = r[1] - 1;
            prereq[nextCourse] |= 1 << prevCourse;
        }

        dp[0] = 0;

        for (int i = 0; i < dp.length; ++i) {
            int coursesCanBeTaken = 0;
            for (int j = 0; j < n; ++j) {
                if ((i & prereq[j]) == prereq[j]) {
                    coursesCanBeTaken |= 1 << j;
                }
            }
            coursesCanBeTaken &= ~i;

            for (int s = coursesCanBeTaken; s > 0; s = (s - 1) & coursesCanBeTaken) {
                if (Integer.bitCount(s) <= k) {
                    dp[i | s] = Math.min(dp[i | s], dp[i] + 1);
                }
            }
        }

        return dp[(1 << n) - 1];
    }
}
//-->O(2^n *n)