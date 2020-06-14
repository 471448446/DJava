package learn.gc;

/**
 * Created by better on 2020/5/17.
 */
public class GcRootThread {
    private static final int _10M = 10 * 1024 * 1024;
    private byte memory[] = new byte[8 * _10M];

    public static void main(String[] args) {
        System.out.println("---gc activeThread start---");
        GCRootUtils.printMemory();
        Run run = new Run(new GcRootThread());
        Thread thread = new Thread(run);
        thread.start();
        System.out.println("thread start now memory");
        System.gc();
        GCRootUtils.printMemory();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("release thread:");
        run = null;
        System.gc();
        GCRootUtils.printMemory();

        System.out.println("---gc activeThread end---");
    }

    private static class Run implements Runnable {
        GcRootThread thread;

        public Run(GcRootThread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("thread done now memory :");
            System.gc();
            GCRootUtils.printMemory();
        }
    }
}
