import java.util.Stack;

class Solution implements Pattern132Finder {
    @Override
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int thirdMax = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < thirdMax) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                thirdMax = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}


//--> O(n)