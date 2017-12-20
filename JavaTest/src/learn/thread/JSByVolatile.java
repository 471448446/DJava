package learn.thread;

import common.Utils;

/**
 * Created by better on 2017/12/18.
 */
public class JSByVolatile {

    public static void main(String[] args) {
        // ����volatile ���߱�ԭ���Բ�����ֻ�ܱ�֤�ɼ���
        fakeSynchronized();
        // Java ���ڻ������ݵ�д�Ͷ���ԭ���Եģ�ֱ�Ӹ�ֵ��
        volatileUseOne();
    }

    private static void volatileUseOne() {
        //��Ϊ״̬��־ʹ��
        TestRunnable runnable = new TestRunnable();
        new Thread(() -> {
            Utils.log(Thread.currentThread().getName() + " ���µ�Դ��");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            runnable.money = 10;
        }, "A").start();
        new Thread(() -> {
            while (runnable.money != 10) {
                Utils.log(Thread.currentThread().getName() + " ϵͳ��Ӧ�� ing");
            }
            Utils.log(Thread.currentThread().getName() + " �����ɹ�");
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
