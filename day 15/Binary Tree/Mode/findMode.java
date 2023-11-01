class Solution {
    private int currentVal; // Current element being processed
    private int currentCount = 0; // Count of the current element
    private int maxCount = 0; // Maximum count found so far
    private List<Integer> modes = new ArrayList<>(); // List to store modes

    private void handleValue(int val) {
        if (val == currentVal) {
            currentCount++;
        } else {
            currentVal = val;
            currentCount = 1;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(currentVal);
        } else if (currentCount == maxCount) {
            modes.add(currentVal);
        }
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        handleValue(node.val);
        inOrderTraversal(node.right);
    }

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }
}
