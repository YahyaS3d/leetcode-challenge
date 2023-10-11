
---

# Full Bloom Flowers

This repository contains a Java solution for the "Full Bloom Flowers" problem. The problem is about determining the number of flowers that have fully bloomed at a given day for a list of persons.

## Problem Description

You are given an array of flowers with each flower represented as a pair of integers `[start, end]`, where `start` is the start day and `end` is the end day for the flower to bloom. Additionally, you are provided with an array of days, where each day represents the day a person wants to see flowers in full bloom.

The task is to find, for each person's desired day, how many flowers have fully bloomed on that day. A flower is considered to be in full bloom if its `start` day is less than or equal to the person's desired day, and its `end` day is greater than or equal to the person's desired day.

## Solution

The provided Java solution efficiently calculates the number of fully bloomed flowers for each person's desired day using a preprocessed data structure that allows for faster lookups.

## Usage

1. Clone the repository to your local machine.

2. Open the project in your Java development environment (e.g., IntelliJ IDEA, Eclipse, etc.).

3. Run the `fullBloomFlowers` method with your own input data or use the sample data provided.

4. The solution will return an array that represents the number of fully bloomed flowers for each person's desired day.

## Example

```java
int[][] flowers = {{1, 4}, {2, 3}, {4, 6}, {5, 8}};
int[] persons = {2, 3, 5};
int[] result = fullBloomFlowers(flowers, persons);

// Output: [3, 4, 4]
```