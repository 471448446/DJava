package learn.thread;

import common.Utils;

/**
 * Created by better on 2017/12/14.
 */
public class JSBySynchronizedObject {
    public static void main(String[] args) {
        TestRunnable runnable = new TestRunnable("张三");
        TestRunnable runnable2 = new TestRunnable("阿狗");
        new Thread(() -> {
            synchronized (runnable) {
                runnable.add();
                runnable.reduce();
                runnable2.reduce();
                runnable2.add();
            }
        }, "ThreadA").start();

        new Thread(() -> {
            //这个地方如果锁runnable2就不会同步。
            synchronized (runnable) {
                runnable.add();
                runnable.reduce();
                runnable2.add();
                runnable2.reduce();
            }
        }, "ThreadB").start();
    }

    static class TestRunnable {

        int money;
        String name;

        public TestRunnable(String name) {

            this.name = name;
        }

        public void add() {
            for (int i = 0; i < 10000; i++) {
                money++;
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            Utils.log(Thread.currentThread().getName() + " " + name + ":add() " + money);
        }

        public void reduce() {
            for (int i = 0; i < 10000; i++) {
                money--;
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            Utils.log(Thread.currentThread().getName() + " " + name + ":reduce() " + money);
        }
    }
}
