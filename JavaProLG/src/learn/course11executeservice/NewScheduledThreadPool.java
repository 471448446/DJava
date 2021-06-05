package learn.course11executeservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by better on 2020/6/14.
 */
public class NewScheduledThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread name:" + Thread.currentThread().getName());
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);

        Thread.sleep(5000);

        executorService.shutdown();
    }
}
