#include <vector>
#include <algorithm>

class Solution {
public:
    int largestSubmatrix(vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix.front().size();
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        
        int ans = 0;
        
        for (int i = 0; i < m; i++) {
            sort(matrix[i].begin(), matrix[i].end(), std::greater<int>());
            
            for (int w = 0; w < n; w++) {
                ans = max(ans, (w + 1) * matrix[i][w]);
            }
        }
        
        return ans;
    }
};
