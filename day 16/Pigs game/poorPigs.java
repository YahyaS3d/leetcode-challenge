class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int testsPerPig = minutesToTest / minutesToDie + 1;
        int pigs = 0;
        int totalTests = 1;

        while (totalTests < buckets) {
            totalTests *= testsPerPig;
            pigs++;
        }

        return pigs;
    }
}
// TC --> O(log(buckets) / log(testsPerPig))