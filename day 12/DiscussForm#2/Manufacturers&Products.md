
```markdown
# Manufacturers and Products

This program determines how many manufacturers produce a given product ID based on their product ID ranges.

## Problem Statement

You are given information about several manufacturers and the ranges of product IDs they produce. Given a product ID, your task is to find out how many manufacturers produce that product.

### Input Format

- The first line contains an integer `T` - the number of test cases.
- For each test case:
  - The first line contains an integer `M` - the number of manufacturers.
  - The next `M` lines contain the ranges of product IDs each manufacturer produces. Each line contains two integers `S` and `E` (1-based) representing the starting and ending product ID (inclusive) for that manufacturer.
  - The next line contains an integer `Q` - the number of queries.
  - The next `Q` lines contain a single integer `ID` representing the product ID for each query.

### Output Format

- For each query in each test case, print the number of manufacturers producing the given product ID.

## Constraints

**20 points**
- 1 <= `T` <= 100
- 1 <= `M`, `Q` <= 1000
- 1 <= `S` <= `E` <= 10^4
- 1 <= `ID` <= 10^4

**30 points**
- 1 <= `T` <= 100
- 1 <= `M`, `Q` <= 10,000
- 1 <= `S` <= `E` <= 10^4
- 1 <= `ID` <= 10^4

**50 points**
- 1 <= `T` <= 100
- 1 <= `M`, `Q` <= 10,000
- 1 <= `S` <= `E` <= 10^9
- 1 <= `ID` <= 10^9

## Sample Input/Output

**Input:**
```
1
4
1 3
1 6
3 5
5 9
4
3
8
6
10
```

**Output:**
```
3
1
2
0
```

## How to Run

To run the program, you can use the following command:

```
python manufacturers_and_products.py
```

Replace `manufacturers_and_products.py` with the name of your source code file.

## Authors

- Yahya Saad

## Acknowledgments

This problem was sourced from https://leetcode.com/discuss/interview-question/4129985/Help-me-with-a-problem.
```

