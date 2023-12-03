class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int total_time = 0;
        int n = points.length;

        for (int i = 0; i < n - 1; i++) {
            total_time += calculateTime(points[i], points[i + 1]);
        }

        return total_time;
    }

    private int calculateTime(int[] p1, int[] p2) {
        int dx = Math.abs(p1[0] - p2[0]);
        int dy = Math.abs(p1[1] - p2[1]);
        return Math.max(dx, dy); // diagonal movement takes the maximum of dx and dy
    }
}
