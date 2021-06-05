package learn.course11executeservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by better on 2020/6/14.
 */
public class NewFixedThreadPool {
    public static void main(String[] args) {
        // 创建一个固定数目的、可重用的线程池。
        ExecutorService executorService = Executors.newFixedThreadPool(
                3
        );
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread name:" + Thread.currentThread().getName() + ",execute index:" + finalI);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
