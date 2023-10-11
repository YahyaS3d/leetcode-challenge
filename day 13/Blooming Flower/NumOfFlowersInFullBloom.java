//O(P * log(F)) 
//P --> Persons number 
//F --> Flowers number 

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int[] ans = new int[persons.length];
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        for (int[] flower : flowers) {
            starts.add(flower[0]);
            ends.add(flower[1]);
        }

        Collections.sort(starts);
        Collections.sort(ends);

        for (int i = 0; i < persons.length; ++i) {
            int started = findFirstGreater(starts, persons[i]);
            int ended = findFirstGreaterEqual(ends, persons[i]);
            ans[i] = calculateDifference(started, ended);
        }

        return ans;
    }

    private int findFirstGreater(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int findFirstGreaterEqual(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int calculateDifference(int started, int ended) {
        return started - ended;
    }
}
