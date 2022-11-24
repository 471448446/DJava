package com.better.learn.thread;

/**
 * 检查sleep() 后线程的状态是啥。TIMED_WAITING
 */
public class TestStatus {
    public static void main(String[] args) throws InterruptedException {
        Thread sleep = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("_________sleep thread run() 0");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("_________sleep thread run() was interrupt");
                }
                System.out.println("_________sleep thread run() 0");
            }
        });
        Thread printer = new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                // 每隔100毫秒检查sleep线程的状态
                while (System.currentTimeMillis() - start < 1_200) {
                    System.out.println("Thread sleep status:" + sleep.getState());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        printer.start();
        sleep.start();
        printer.join();
    }
}
