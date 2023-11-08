class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // Initialize arrays to keep track of visited nodes and their parents.
        boolean[] visited = new boolean[n];
        int[] parentCount = new int[n];

        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];

            if (left != -1) {
                // Check if the left child already has a parent.
                if (parentCount[left] > 0) {
                    return false;
                }
                parentCount[left]++;
            }

            if (right != -1) {
                // Check if the right child already has a parent.
                if (parentCount[right] > 0) {
                    return false;
                }
                parentCount[right]++;
            }
        }

        // Find the root node (a node with no parent).
        int rootCount = 0;
        int rootNode = -1;
        for (int i = 0; i < n; i++) {
            if (parentCount[i] == 0) {
                rootCount++;
                rootNode = i;
            }
        }

        // Check if there is exactly one root and no cycles.
        return rootCount == 1 && isTreeValid(rootNode, leftChild, rightChild, visited) && countNodes(visited) == n;
    }

    // DFS to check for cycles and visit all nodes.
    private boolean isTreeValid(int node, int[] leftChild, int[] rightChild, boolean[] visited) {
        if (node == -1) {
            return true; // Null nodes are valid.
        }

        if (visited[node]) {
            return false; // Cycle detected.
        }

        visited[node] = true;

        return isTreeValid(leftChild[node], leftChild, rightChild, visited)
            && isTreeValid(rightChild[node], leftChild, rightChild, visited);
    }

    // Count the number of visited nodes.
    private int countNodes(boolean[] visited) {
        int count = 0;
        for (boolean v : visited) {
            if (v) {
                count++;
            }
        }
        return count;
    }
}
