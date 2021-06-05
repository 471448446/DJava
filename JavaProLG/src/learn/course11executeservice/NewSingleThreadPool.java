package learn.course11executeservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by better on 2020/6/14.
 */
public class NewSingleThreadPool {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread name:" + Thread.currentThread().getName() + ",execute index:" + finalI);
                }
            });
            // wait all end
            Thread.sleep(500);
        }
        // exit
        executorService.shutdown();
    }
}
