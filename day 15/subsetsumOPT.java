class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxSum = nums[0];
        dp[0] = nums[0];

        SegmentTree tree = new SegmentTree(n);
        tree.update(0, dp[0]);

        for (int i = 1; i < n; i++) {
            int maxInWindow = tree.query(Math.max(0, i - k), i - 1);
            dp[i] = Math.max(maxInWindow + nums[i], nums[i]);
            tree.update(i, dp[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}

class SegmentTree {
    int[] tree;
    int size;

    public SegmentTree(int n) {
        size = n;
        tree = new int[4 * n];
    }

    public void update(int index, int value) {
        update(0, 0, size - 1, index, value);
    }

    public void update(int node, int left, int right, int index, int value) {
        if (left == right) {
            tree[node] = value;
            return;
        }

        int mid = (left + right) / 2;
        if (index <= mid) {
            update(2 * node + 1, left, mid, index, value);
        } else {
            update(2 * node + 2, mid + 1, right, index, value);
        }

        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    public int query(int left, int right) {
        return query(0, 0, size - 1, left, right);
    }

    public int query(int node, int nodeLeft, int nodeRight, int left, int right) {
        if (left > nodeRight || right < nodeLeft) {
            return Integer.MIN_VALUE;
        }

        if (left <= nodeLeft && right >= nodeRight) {
            return tree[node];
        }

        int mid = (nodeLeft + nodeRight) / 2;
        int leftQuery = query(2 * node + 1, nodeLeft, mid, left, right);
        int rightQuery = query(2 * node + 2, mid + 1, nodeRight, left, right);

        return Math.max(leftQuery, rightQuery);
    }
}
