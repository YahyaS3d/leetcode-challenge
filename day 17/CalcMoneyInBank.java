class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int week = 0;
        int day = 1;

        while (day <= n) {
            total += week + (day % 7 == 0 ? 7 : day % 7);
            day++;

            if (day % 7 == 1) {
                week++;
            }
        }

        return total;
    }
}
