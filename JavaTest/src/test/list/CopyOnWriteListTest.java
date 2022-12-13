package test.list;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListTest {
    private static final CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    private static volatile boolean start = false;

    public static void main(String[] args) {
        put();
    }

    private static void put() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("----produce----start----");
                for (int i = 0; i < 5; i++) {
                    list.add(String.valueOf(i));
                    System.out.println("----produce--------" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (!start) {
                        System.out.println("----produce--------call consume");
                        get();
                    }
                }
            }
        }).start();
    }

    private static void get() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                start = true;
                System.out.println("consume----start----");
                for (String s : list) {
                    list.remove(s);
                    System.out.println("consume--------" + s);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("consume----end----");
                start = false;
            }
        }).start();
    }
}
