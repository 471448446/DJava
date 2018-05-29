package learn.thread;

import common.Utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        //申请最大并发量，同时运行的数量不会操作这个值
        //这里线程池最多同时运行4，但是规定最大并发是3，所以最终只会同时运行三个
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 7; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        Utils.log("Left:" + semaphore.availablePermits() + ";" + semaphore.getQueueLength());
                        Thread.sleep(2000);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
