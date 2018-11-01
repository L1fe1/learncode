package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThread {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4));
        for (int i = 1; i <= 6; i++) {
            TaskThred t1 = new TaskThred("任务" + i);
            executor.execute(t1);
        }
        executor.shutdown();
    }

}

class TaskThred implements Runnable {
    private String taskName;

    public TaskThred(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + taskName);
    }
}
