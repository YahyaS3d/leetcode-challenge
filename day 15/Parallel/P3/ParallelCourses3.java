import java.util.*;

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];
        int[] earliestTime = new int[n];

        // Initialize the graph and in-degrees
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] relation : relations) {
            int prevCourse = relation[0] - 1;
            int nextCourse = relation[1] - 1;
            graph.get(prevCourse).add(nextCourse);
            inDegree[nextCourse]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int minTime = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            minTime = Math.max(minTime, earliestTime[course] + time[course]);
            for (int nextCourse : graph.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
                earliestTime[nextCourse] = Math.max(earliestTime[nextCourse], earliestTime[course] + time[course]);
            }
        }

        return minTime;
    }
}

//-->O(n)