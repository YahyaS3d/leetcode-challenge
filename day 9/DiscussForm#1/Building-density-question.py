def longestContiguousSegment(queries):
left_boundary = {}
right_boundary = {}
max_length = 0
results = [] #store the result here

for q in queries:
    left_boundary[q] = q
    right_boundary[q] = q

    if q - 1 in left_boundary:
        left_boundary[q] = left_boundary[q - 1]

    if q + 1 in right_boundary:
        right_boundary[q] = right_boundary[q + 1]

    current_length = right_boundary[q] - left_boundary[q] + 1
    max_length = max(max_length, current_length)
    results.append(max_length)

return results