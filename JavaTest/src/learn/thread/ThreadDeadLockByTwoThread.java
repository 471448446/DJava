package learn.thread;

import common.Utils;

import java.util.Objects;

/**
 * Created by better on 2018/3/6.
 */
public class ThreadDeadLockByTwoThread {
    public static void main(String[] args) {

        Object a = new Object();
        Object b = new Object();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (a) {
                        try {
                            Utils.log(Thread.currentThread().getName() + "ThreadA get A Lock");
                            Thread.sleep(500);
                            Utils.log(Thread.currentThread().getName() + " after sleep 500ms!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Utils.log(Thread.currentThread().getName() + "need lock waiting");

                        synchronized (b) {
                            Utils.log(Thread.currentThread().getName() + "ThreadA get B Lock");
                        }
                    }
                }

            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (b) {
                        try {
                            Utils.log(Thread.currentThread().getName() + "threadB get B Lock");
                            Thread.sleep(500);
                            Utils.log(Thread.currentThread().getName() + " after sleep 500ms!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Utils.log(Thread.currentThread().getName() + "need lock waiting");

                        synchronized (a) {
                            Utils.log(Thread.currentThread().getName() + "threadB get A Lock");
                        }
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
