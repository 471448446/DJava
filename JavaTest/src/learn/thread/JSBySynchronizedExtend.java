package learn.thread;

import common.Utils;

/**
 * Created by better on 2017/12/14.
 */
public class JSBySynchronizedExtend {
    public static void main(String[] args) {
        B b = new B();
        new Thread(new Runnable() {
            @Override
            public void run() {
                b.one();
                b.two();
            }
        }, "ThreadA").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                b.one();
                b.two();
            }
        }, "ThreadB").start();
    }

    static class A {
        public synchronized void one() {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Utils.log(Thread.currentThread().getName() + " A one():" + i);
            }
        }

        public synchronized void two() {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Utils.log(Thread.currentThread().getName() + " A two():" + i);
            }
        }
    }

    static class B extends A {
        @Override
        public synchronized void one() {
            super.one();
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Utils.log(Thread.currentThread().getName() + " son override one():" + i);
            }
        }

        public void two() {
            super.two();
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Utils.log(Thread.currentThread().getName() + " son override two():" + i);
            }
        }
    }
}
