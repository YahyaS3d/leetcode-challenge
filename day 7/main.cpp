#include <iostream>
#include "Solution.h" // Include the header file with the solution class

int main() {
    Solution solution;

    // Test cases
    int poured1 = 1, query_row1 = 1, query_glass1 = 1;
    double result1 = solution.champagneTower(poured1, query_row1, query_glass1);
    std::cout << "Test Case 1: " << result1 << std::endl;

    int poured2 = 2, query_row2 = 1, query_glass2 = 1;
    double result2 = solution.champagneTower(poured2, query_row2, query_glass2);
    std::cout << "Test Case 2: " << result2 << std::endl;

    int poured3 = 100000009, query_row3 = 33, query_glass3 = 17;
    double result3 = solution.champagneTower(poured3, query_row3, query_glass3);
    std::cout << "Test Case 3: " << result3 << std::endl;

    return 0;
}