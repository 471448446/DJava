package learn.thread;

import common.Utils;

/**
 * Java Synchronized
 * Created by better on 2017/12/14.
 */
public class JSBySynchronizedBlock {
    public static void main(String[] args) {
        TestRunnable runnable = new TestRunnable();
        Thread A = new Thread(runnable, "A");
        Thread B = new Thread(runnable, "B");

        A.start();
        B.start();

    }

    static class TestRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                Utils.log("randomBefore��" + Thread.currentThread().getName() + "," + i);
            }
            synchronized (TestRunnable.this) {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Utils.log(Thread.currentThread().getName() + ":" + i);
                }
            }
            for (int i = 0; i < 3; i++) {
                Utils.log("randomAfter��" + Thread.currentThread().getName() + "," + i);
            }
        }
    }
}
