package learn.thread;

import common.Utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by better on 2017/12/19.
 */
public class JSByReentrantLock {

    public static void main(String[] args) throws InterruptedException {
        useReentrant();
        Thread.sleep(1000);
        useTime();

    }

    private static void useTime() {
        //没有限时两个都执行了
        TimeRunnable runnable = new TimeRunnable();
        new Thread(runnable, "ThreadA").start();
        new Thread(runnable, "ThreadB").start();
        //限时只执行一个
        /**
         * 两个线程同时都延时1秒获取锁，先获取的后面的就获取不到了。
         */
        TimeTryRunnable runnableTry = new TimeTryRunnable();
        new Thread(runnableTry, "ThreadATry").start();
        new Thread(runnableTry, "ThreadBTry").start();
    }

    private static void useReentrant() {
        TestRunnable runnable = new TestRunnable();
        for (int i = 0; i < 10; i++) {
            new Thread(runnable, "Thread" + i).start();
        }
    }

    static class TimeTryRunnable implements Runnable {
        private ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            try {
                if (lock.tryLock(1, TimeUnit.SECONDS)) {
                    Utils.logThread(",sleep");
                    Thread.sleep(3000);
                } else {
                    Utils.logThread(" Lock Failed");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    Utils.logThread(",Finished");
                    lock.unlock();
                }
            }
        }
    }

    static class TimeRunnable implements Runnable {

        @Override
        public void run() {
            try {
                Utils.log(Thread.currentThread().getName() + ",sleep");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Utils.log(Thread.currentThread().getName() + ",Finished");
        }
    }

    static class TestRunnable implements Runnable {
        private int i = 0;
        private ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            for (int i1 = 0; i1 < 10000; i1++) {
                lock.lock();
                //可重入
                lock.lock();
                try {
                    i++;
                } finally {
                    lock.unlock();
                    lock.unlock();
                }
            }
            Utils.log(Thread.currentThread().getName() + ",Finished:" + i);
        }
    }
}
