package learn.course11executeservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by better on 2020/6/14.
 */
public class NewCachedThreadPool {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            int finalI = i;
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("thread name:" + Thread.currentThread().getName() + ",execute index:" + finalI);
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
//        // no create thread run code
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread name:" + Thread.currentThread().getName() + ",execute index:" + finalI);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
    }
}
