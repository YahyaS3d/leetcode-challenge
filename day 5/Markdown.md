# Subsequence Check

Given two strings `s` and `t`, determine if `s` is a subsequence of `t`.

A subsequence of a string is a new string formed by deleting some (possibly none) characters from the original string without changing the relative order of the remaining characters.

## Example

### Input
s = "abc", t = "ahbgdc"

### Output
true


### Explanation
String "abc" is a subsequence of "ahbgdc" because we can obtain "abc" by deleting some characters from "ahbgdc" (e.g., delete 'h', 'b', 'g', and 'd') without changing the relative order of the remaining characters.

## Constraints
- 0 <= s.length <= 100
- 0 <= t.length <= 10^4
- `s` and `t` consist only of lowercase English letters.

## Solution

To solve this problem efficiently, we use a two-pointer approach:
- Initialize two pointers, one for each string, and iterate through both strings.
- Check if the characters at the two pointers match.
- If they match, increment both pointers.
- If they don't match, increment only the pointer for the longer string.
- Continue this process until you reach the end of `s` or `t`.
- If you successfully traverse all characters in `s`, then `s` is a subsequence of `t`, and you return `true`; otherwise, return `false`.

Notes
The time complexity of this solution is O(min(s.length(), t.length())), making it efficient.
The two-pointer approach is an optimal strategy for this problem and doesn't require constructing additional data structures.
The code terminates as soon as it finds that s cannot be a subsequence of t, optimizing the runtime.