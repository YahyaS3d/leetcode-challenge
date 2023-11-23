import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int[] subarray = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(subarray);
            result.add(isArithmeticSequence(subarray));
        }

        return result;
    }

    private boolean isArithmeticSequence(int[] arr) {
        if (arr.length < 2) {
            return false;
        }

        int commonDifference = arr[1] - arr[0];

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != commonDifference) {
                return false;
            }
        }

        return true;
    }
}
