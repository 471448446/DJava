package test;

import java.util.concurrent.*;

public class ThreadPoolMaxSize {
    public static void main(String[] args) {
        /**
         * ThreadPool 中最大的就是5,也就是 maximumPoolSize 决定。并不是 corePoolSize + maximumPoolSize。
         * maximumPoolSize 决定了线程池中最多能创建的线程个数
         *  Executors.newSingleThreadExecutor() corePoolSize 和 maximumPoolSize都是1 ，固定是1个线程的
         */
        ExecutorService executorService = new ThreadPoolExecutor(
                2, 5, 0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(2)
        );

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("now " + Thread.currentThread().getName() + " execute task:" + finalI);
                    try {
                        Thread.sleep(1_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("ThreadPool queue size:" + ((ThreadPoolExecutor) executorService).getQueue().size());
        }
        executorService.shutdown();
    }
}
