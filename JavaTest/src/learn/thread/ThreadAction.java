package learn.thread;

import common.Utils;

/**
 * Created by better on 2017/11/12.
 */
public class ThreadAction {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Executing :" + Thread.currentThread().getName() + "," + Thread.currentThread().getId());
        interruptAction();
        yieldAction();
        sleepAction();
        joinAction();
    }

    private static void joinAction() throws InterruptedException {
        Utils.log("joinAction");
        ThreadActionJoin A = new ThreadActionJoin("A"),
                B = new ThreadActionJoin("B");
        A.start();
        B.start();

        A.join();
        B.join();
        Utils.log("joinAction Over" + A.getI() + "," + B.getI());
    }

    private static void sleepAction() {
        Test t = new Test();
        Thread A = new ThreadActionSleep("AA", t),
                B = new ThreadActionSleep("BB", t);

        A.start();
        B.start();
    }

    private static void yieldAction() throws InterruptedException {
        ThreadActionYield A = new ThreadActionYield("A");
        ThreadActionYield B = new ThreadActionYield("B");
        A.start();
        B.start();
        Thread.sleep(10);
        A.interrupt();
        B.interrupt();
    }

    private static void interruptAction() {
        ThreadActionInterrupt t = new ThreadActionInterrupt();
        t.start();

        try {
            //���߳�ͣ��1���룬��t�߳�ִ��1���롣
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
}

class ThreadActionJoin extends Thread {

    private int i = 0;

    public int getI() {
        return i;
    }

    public ThreadActionJoin(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        for (int i = 1; i < 10; i++) {
            System.out.println(getName() + getId() + "ִ����" + ++this.i + "��");
        }
    }
}

class ThreadActionSleep extends Thread {
    Test mTest;

    public ThreadActionSleep(String name, Test test) {
        super(name);
        mTest = test;
    }

    @Override
    public void run() {
        super.run();
        mTest.test();
    }
}

class Test {
    public synchronized void test() {
        Utils.log(Thread.currentThread().getName() + "__׼��test��������1000");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Utils.log(Thread.currentThread().getName() + "__�ָ�");
    }
}


class ThreadActionYield extends Thread {
    int i = 0;
    String name;

    public ThreadActionYield(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        while (!isInterrupted()) {
            Utils.log(name + ",ִ�У�" + ++i);
            if (i % 10 == 0) {
                yield();
            }
        }
    }
}

class ThreadActionInterrupt extends Thread {
    int i = 0;

    @Override
    public void run() {
        Utils.log("Interrupt? " + Thread.currentThread().getName() + "," + Thread.currentThread().getId());
        while (!isInterrupted()) {
            Utils.log("_wait_Interrupt:" + i);
            i++;
        }
        Utils.log("Interrupted��" + isInterrupted() + "," + interrupted() + "��" + interrupted());
    }
}
