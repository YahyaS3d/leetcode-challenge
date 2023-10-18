
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class MyRecursiveTask extends RecursiveTask<Integer> {
    private int[] array;
    private int start;
    private int end;

    public MyRecursiveTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 2) {
            // Do the computation directly
            return array[start] + array[start + 1];
        } else {
            // Split the task into smaller subtasks
            int middle = (start + end) / 2;
            MyRecursiveTask leftTask = new MyRecursiveTask(array, start, middle);
            MyRecursiveTask rightTask = new MyRecursiveTask(array, middle, end);

            leftTask.fork();
            int rightResult = rightTask.compute();
            int leftResult = leftTask.join();

            return leftResult + rightResult;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        ForkJoinPool pool = new ForkJoinPool();
        int result = pool.invoke(new MyRecursiveTask(array, 0, array.length));
        System.out.println("Result: " + result);
    }
}
