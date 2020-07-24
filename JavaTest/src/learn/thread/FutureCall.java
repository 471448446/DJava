package learn.thread;

import java.util.concurrent.*;

public class FutureCall {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(() -> {
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            Object o = future.get();
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Callable<Integer> callable = () -> {
            Thread.sleep(1_000);
            return 2 * 3;
        };
        Future<Integer> future1 = executorService.submit(callable);
        try {
            Integer r = future1.get();
            System.out.println("get result:" + r);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
