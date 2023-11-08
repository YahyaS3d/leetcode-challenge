import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int targetIdx = 0;

        for (int num = 1; num <= n; num++) {
            if (targetIdx == target.length) {
                // We've already built the target array, no need to continue.
                break;
            }

            if (num == target[targetIdx]) {
                // Current number from the stream matches the target value.
                operations.add("Push");
                targetIdx++;
            } else {
                // Push the current number to the stack and pop it immediately.
                operations.add("Push");
                operations.add("Pop");
            }
        }

        return operations;
    }
}
