package learn.thread;

import common.Utils;

/**
 * 按次序执行
 * 生产消费者
 * Created by better on 2017/12/13.
 */
public class MultiThreadCommunicationByWaitNotify {
    public static void main(String[] args) {

        LockObject lockObject = new LockObject();
        // 方式一 默认就开启
        lockObject.status = 1;

        Thread threadA = new Thread(new RunnableA(lockObject)),
                threadB = new Thread(new RunnableB(lockObject)),
                threadC = new Thread(new RunnableC(lockObject));

        threadA.start();
        threadB.start();
        threadC.start();
        /*
            错误，没有获取到同步锁，就是没有加锁这样调用时错误的
            Exception in thread "main" java.lang.IllegalMonitorStateException
            http://blog.csdn.net/qianshangding0708/article/details/48290937

            lockObject.status = 1;
            lockObject.notify();
         */

        //方式二 手动开启
//        synchronized (lockObject){
//            lockObject.status = 1;
//            lockObject.notifyAll();
//        }


    }

    static class LockObject {
        int status;
    }

    static class RunnableA implements Runnable {
        private LockObject lockObject;

        private int something = 0;

        public RunnableA(LockObject lockObject) {
            this.lockObject = lockObject;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lockObject) {
                    while (lockObject.status != 1) {
                        try {
                            lockObject.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    something++;
                    if (something % 10 == 0) {
                        Utils.log("A:" + something);
                        lockObject.status = 2;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lockObject.notifyAll();
                    }
                }
            }
        }
    }

    static class RunnableB implements Runnable {
        private LockObject lockObject;
        private int something = 0;

        public RunnableB(LockObject lockObject) {
            this.lockObject = lockObject;
        }

        @Override
        public void run() {
            while (true) {

                synchronized (lockObject) {
                    while (lockObject.status != 2) {
                        try {
                            lockObject.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    something++;
                    if (something % 20 == 0) {
                        Utils.log("B:" + something);
                        lockObject.status = 3;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lockObject.notifyAll();
                    }
                }
            }
        }
    }

    static class RunnableC implements Runnable {
        private LockObject lockObject;
        private int something = 0;

        public RunnableC(LockObject lockObject) {
            this.lockObject = lockObject;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lockObject) {
                    while (lockObject.status != 3) {
                        try {
                            lockObject.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    something++;
                    if (something % 30 == 0) {
                        Utils.log("C:" + something);
                        lockObject.status = 1;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lockObject.notifyAll();
                    }
                }
            }
        }
    }
}
