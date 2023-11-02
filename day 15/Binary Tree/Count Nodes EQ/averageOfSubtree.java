/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int averageOfSubtree(TreeNode root) {
        int[] count = {0}; // To keep track of the count of nodes with the required property
        dfs(root, count);
        return count[0];
    }
    
    private int[] dfs(TreeNode node, int[] count) {
        if (node == null) {
            return new int[]{0, 0}; // [sum, count]
        }
        
        int sum = node.val;
        int nodeCount = 1;
        
        int[] left = dfs(node.left, count);
        int[] right = dfs(node.right, count);
        
        sum += left[0] + right[0];
        nodeCount += left[1] + right[1];
        
        int avg = sum / nodeCount;
        
        if (node.val == avg) {
            count[0]++;
        }
        
        return new int[]{sum, nodeCount};
    }
}

