package learn.thread;

import common.Utils;

/**
 * Created by better on 2017/12/20.
 */
public class JSByThreadLock {
    public static void main(String[] args) {
        TestRunnableLocal runnableLocal = new TestRunnableLocal();
        TestRunnable runnable = new TestRunnable();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                // money=10000
                runnableLocal.add();
                // money=0
                runnableLocal.reduce();
                /*------*/
                // money =未知
                runnable.add();
                // money =未知
                runnable.reduce();
            }, "Thread" + i).start();
        }
    }

    static class TestRunnableLocal {
        private ThreadLocal<Integer> money = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return 0;
            }
        };

        public void add() {
            for (int i = 0; i < 10000; i++) {
                this.money.set(money.get() + 1);
            }
            Utils.log(Thread.currentThread().getName() + ":add() " + money.get());
        }

        public void reduce() {
            for (int i = 0; i < 10000; i++) {
                this.money.set(money.get() - 1);
            }
            Utils.log(Thread.currentThread().getName() + ":reduce() " + money.get());
        }
    }

    static class TestRunnable {
        private int money;

        public void add() {
            for (int i = 0; i < 10000; i++) {
                money++;
            }
            Utils.log(Thread.currentThread().getName() + "TestRunnable:add() " + money);
        }

        public void reduce() {
            for (int i = 0; i < 10000; i++) {
                money--;
            }
            Utils.log(Thread.currentThread().getName() + "TestRunnable:reduce() " + money);
        }
    }

}
