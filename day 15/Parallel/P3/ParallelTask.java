import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

private class ParallelTask extends RecursiveTask<Integer> {
    private List<List<Integer>> graph;
    private int[] inDegree;
    private int[] earliestTime;
    private int[] time;

    public ParallelTask(List<List<Integer>> graph, int[] inDegree, int[] earliestTime, int[] time) {
        this.graph = graph;
        this.inDegree = inDegree;
        this.earliestTime = earliestTime;
        this.time = time;
    }

    @Override
    protected Integer compute() {
        int maxTime = 0;

        for (int i = 0; i < graph.size(); i++) {
            if (inDegree[i] == 0) {
                ParallelTask task = new ParallelTask(graph, inDegree, earliestTime, time);
                task.earliestTime[i] = earliestTime[i] + time[i];
                task.inDegree[i] = -1;  // Mark the course as completed
                task.fork();
                int result = task.join();
                maxTime = Math.max(maxTime, result);
                task.earliestTime[i] = 0;  // Reset for backtracking
                task.inDegree[i] = 0;
            }
        }

        return maxTime;
    }
}
