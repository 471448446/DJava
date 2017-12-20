package learn.thread;

import common.Utils;

/**
 * Created by better on 2017/12/18.
 */
public class JSByVolatile {

    public static void main(String[] args) {
        // 由于volatile 不具备原子性操作，只能保证可见性
        fakeSynchronized();
        // Java 对于基本数据的写和读是原子性的（直接赋值）
        volatileUseOne();
    }

    private static void volatileUseOne() {
        //作为状态标志使用
        TestRunnable runnable = new TestRunnable();
        new Thread(() -> {
            Utils.log(Thread.currentThread().getName() + " 按下电源键");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            runnable.money = 10;
        }, "A").start();
        new Thread(() -> {
            while (runnable.money != 10) {
                Utils.log(Thread.currentThread().getName() + " 系统响应中 ing");
            }
            Utils.log(Thread.currentThread().getName() + " 开机成功");
        }, "B").start();
    }

    private static void fakeSynchronized() {
        TestRunnable runnable = new TestRunnable();
        for (int i = 0; i < 10; i++) {
            final String name = "_Thread" + i + "_";
            new Thread(() -> {
                runnable.add();
                runnable.reduce();
                Utils.log(name + " Finish:" + runnable.getMoney());
            }, name).start();
        }
    }

    static class TestRunnable {

        private volatile int money;

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public void add() {
            for (int i = 0; i < 10000; i++) {
                money++;
//                Utils.log(Thread.currentThread().getName() + ":add() " + money);
            }
        }

        public void reduce() {
            for (int i = 0; i < 10000; i++) {
                money--;
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Utils.log(Thread.currentThread().getName() + ":reduce() " + money);
            }
        }

    }
}
