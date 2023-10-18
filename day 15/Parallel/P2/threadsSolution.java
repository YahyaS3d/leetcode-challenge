import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n);
        int[] prereq = new int[n];

        for (int[] r : relations) {
            int prevCourse = r[0] - 1;
            int nextCourse = r[1] - 1;
            prereq[nextCourse] |= 1 << prevCourse;
        }

        dp[0] = 0;

        AtomicInteger result = new AtomicInteger(dp[(1 << n) - 1]);
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < dp.length; ++i) {
            int coursesCanBeTaken = 0;
            for (int j = 0; j < n; ++j) {
                if ((i & prereq[j]) == prereq[j]) {
                    coursesCanBeTaken |= 1 << j;
                }
            }
            coursesCanBeTaken &= ~i;

            if (Integer.bitCount(coursesCanBeTaken) <= k) {
                int remainingCourses = coursesCanBeTaken;
                while (remainingCourses > 0) {
                    int course = Integer.lowestOneBit(remainingCourses);
                    remainingCourses ^= course;
                    int nextMask = i | course;

                    Callable<Integer> task = () -> {
                        int newResult = dp[i] + 1;
                        return Math.min(dp[nextMask], newResult);
                    };

                    Future<Integer> future = executor.submit(task);
                    int newResult;
                    try {
                        newResult = future.get();
                    } catch (Exception e) {
                        newResult = dp[nextMask];
                    }

                    dp[nextMask] = newResult;
                    result.set(Math.min(result.get(), newResult));
                }
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            // Handle the interruption if needed.
        }

        return result.get();
    }
}


//use an ExecutorService to execute each subproblem concurrently as a callable task.
// The AtomicInteger is used to keep track of the result to ensure thread safety

