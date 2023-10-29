class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int testsPerPig = minutesToTest / minutesToDie + 1;
        int pigs = 0;
        
        while (Math.pow(testsPerPig, pigs) < buckets) {
            pigs++;
        }
        
        return pigs;
    }
}
