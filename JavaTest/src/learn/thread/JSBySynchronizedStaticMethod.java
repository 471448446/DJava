package learn.thread;

import common.Utils;

/**
 * 对该类的所有对象都有用
 * Created by better on 2017/12/14.
 */
public class JSBySynchronizedStaticMethod {
    public static void main(String[] args) {
        new Thread(() -> new TestRunnable().talk(), "ThreadA").start();
        new Thread(() -> new TestRunnable().talk(), "ThreadB").start();
    }

    static class TestRunnable {

        public synchronized static void talk() {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Utils.log(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
