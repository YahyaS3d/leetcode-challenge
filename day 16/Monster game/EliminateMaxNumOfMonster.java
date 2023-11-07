class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = (dist[i] + speed[i] - 1) / speed[i]; // Calculate the time to reach the city
        }

        Arrays.sort(times);

        int eliminations = 0;
        int timeToCharge = 0;

        for (int i = 0; i < n; i++) {
            if (timeToCharge >= times[i]) {
                // You lose if a monster reaches the city when the weapon is charged
                break;
            } else {
                eliminations++;
                timeToCharge++;
            }
        }

        return eliminations;
    }
}
