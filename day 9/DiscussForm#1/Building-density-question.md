You are monitoring the builiding density in a district of houses. The district is represented as a number line, where a house can be built in each numbered point on the line if at least one of the neighbours points is not occupied. Initially no house in district.
You are given queries an array of int representing the locations of new houses in the order in which they were built. After each house is built your task is to find the longest segment of contiguos houses in the district.
Return an array of int representing longest segment of contiguous houses after each respective house from queries is built.
Guaranteed all queries are unique and no house built at point with existing house on both left and right adjacent points.
Sample
queries = [1,4,2,5] output = [1,1,2,2]
queries = [3,6,1,2,5,4] output = [1,1,1,3,3,,6]
Constraints
0<=queries[i]<10^9
1<=queries.length <10^5

How to solve this question in O(n) time? I tried binary indexed tree but couldn't get to solution.

Link in discussion form: https://leetcode.com/discuss/interview-question/4090407/Building-density-question

==README== 

---

# House Building Problem

## Problem Statement

You are monitoring the building density in a district of houses. The district is represented as a number line, where a house can be built at each numbered point on the line if at least one of the neighboring points is not occupied. Initially, there are no houses in the district.

You are given an array of integers representing the locations of new houses in the order in which they were built. After each house is built, your task is to find the longest segment of contiguous houses in the district. You need to return an array of integers representing the longest segment of contiguous houses after each respective house from the queries is built.

## Example

**Input**
```python
queries = [1, 4, 2, 5]
```

**Output**
```python
[1, 1, 2, 2]
```

**Input**
```python
queries = [3, 6, 1, 2, 5, 4]
```

**Output**
```python
[1, 1, 1, 3, 3, 6]
```

## Constraints

- 0 <= queries[i] < 10^9
- 1 <= queries.length < 10^5
- Guaranteed that all queries are unique, and no house is built at a point with existing houses on both left and right adjacent points.

## Solution

The problem can be solved efficiently in O(n) time complexity using a variation of the "Two Pointers" technique. The algorithm involves keeping track of left and right boundaries for each house as new houses are added to the district. The maximum segment length is also updated after each house is built.

The detailed solution and a Python implementation can be found in the provided code.

## How to Use the Code

1. Copy the `longestContiguousSegment` function from the provided code.

2. Use the function to solve the problem by passing an array of queries as an argument.

3. The function will return an array containing the longest segment of contiguous houses after each respective house from the queries is built.

## Example Usage

```python
queries = [1, 4, 2, 5]
results = longestContiguousSegment(queries)
print(results)  # Output: [1, 1, 2, 2]
```

---

