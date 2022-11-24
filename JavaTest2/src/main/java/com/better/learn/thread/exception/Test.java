package com.better.learn.thread.exception;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run");
                int i = 0;
                loop1(i);
                /*
                 * 如果打印下面的日志说明：
                 * 前面发生的异常，跳出了while循环，线程恢复执行了，就是跳过了loop1方法，继续执行
                 * 然而并不是，说明发生异常的地方，后面的代码没有直接
                 */
                System.out.println("run continue:" + System.currentTimeMillis());
                loop2(i);
            }
        });
        thread0.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                // 日志上可以看出，这个方法还是运行在某个线程中，这里就是当前设置了CrashHandler的线程
                System.out.println(threadName() + " crash start------------");
                System.out.println(threadName() + e.getMessage());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(threadName() + " crash end------------");
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(threadName() + "!!!!!!!!crash start------------");
                System.out.println(threadName() + e.getMessage());
                System.out.println(threadName() + "!!!!!!!crash end------------");
            }
        });
        thread0.start();
        thread0.join();
        System.out.println(threadName() + "------------main exit");
    }

    private static String threadName() {
        return "Thread[" + Thread.currentThread().getName() + "] ";
    }

    private static void loop2(int i) {
        long s = System.currentTimeMillis();
        while (true) {
            long l = System.currentTimeMillis() - s;
            if (l < 1000) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            s = System.currentTimeMillis();
            i++;
            System.out.println(threadName() + "------" + i + "," + System.currentTimeMillis());
            if (i > 5) {
                break;
            }
        }
    }

    private static void loop1(int i) {
        long s = System.currentTimeMillis();
        while (true) {
            long l = System.currentTimeMillis() - s;
            if (l < 1000) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            s = System.currentTimeMillis();
            i++;
            System.out.println(threadName() + i + "," + System.currentTimeMillis());
            if (i > 2) {
                throw new RuntimeException("!!! crash " + i);
            }
        }
    }
}
