package learn.thread;

import common.Utils;

/**
 * Created by better on 2017/12/14.
 */
public class JSBySynchronizedClass {
    public static void main(String[] args) {
        new Thread(() -> new TestRunnable().talk(), "ThreadA").start();
        new Thread(() -> new TestRunnable().talk(), "ThreadB").start();
    }

    static class TestRunnable {

        public void talk() {
            synchronized (TestRunnable.class) {
                for (int i = 0; i < 3; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Utils.log(Thread.currentThread().getName() + "," + i);
                }
            }
        }
    }
}
