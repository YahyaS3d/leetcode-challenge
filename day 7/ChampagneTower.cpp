class Solution {
public:
    double champagneTower(int poured, int query_row, int query_glass) {
        vector<double> currentRow(101, 0.0);
        currentRow[0] = static_cast<double>(poured);        // Initialize the top glass with poured amount of champagne


        for (int row = 0; row < query_row; ++row) {
            // Create a vector for the next row's champagne levels
            vector<double> nextRow(101, 0.0);
            for (int glass = 0; glass <= row; ++glass) {
                double excess = (currentRow[glass] - 1.0) / 2.0; // Calculate excess champagne that flows to adjacent glasses
                if (excess > 0) {
                    // Distribute excess champagne to the two adjacent glasses
                    nextRow[glass] += excess;
                    nextRow[glass + 1] += excess;
                }
            }
            swap(currentRow, nextRow);
        }
        
        return min(1.0, currentRow[query_glass]); //return the champagne level
    }
};
//TC: O(N^2), where N is the value of query_row