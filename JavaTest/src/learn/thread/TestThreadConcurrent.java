package learn.thread;

import common.Utils;

public class TestThreadConcurrent {
    public static void main(String[] args) {
        TestClass A = new TestClass();

        for (int i = 0; i < 6; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (TestClass.class) {
                        A.funcA();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    A.funcB();

                }
            }).start();

        }
    }

    static class TestClass {
        public void funcA() {
            Utils.log("funcA Enter " + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Utils.log("funcA Out " + System.currentTimeMillis());
        }

        public synchronized void funcB() {
            Utils.log("funcB E" + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Utils.log("funcB O" + System.currentTimeMillis());
        }


    }
}
