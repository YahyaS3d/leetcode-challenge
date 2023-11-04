class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTimeLeft = 0;
        int maxTimeRight = 0;

        for (int position : left) {
            maxTimeLeft = Math.max(maxTimeLeft, position);
        }

        for (int position : right) {
            maxTimeRight = Math.max(maxTimeRight, n - position);
        }

        return Math.max(maxTimeLeft, maxTimeRight);
    }
}
//TC --> O( L + R )