package learn.thread;

import common.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同线程操作统一资源，但是动作不同。
 * 比如一个书店里面，不断的有人送书来，又有客人不断的将书买走。如果用语言来描述图书的变化
 * 运行发现有很多信息
 * Created by better on 2017/10/18.
 */
public class Communicate1 {
    public static void main(String[] args) {
        BookStation station = new BookStation();
        Thread t1 = new Thread(new AddBook(station));
        Thread t2 = new Thread(new SellBook(station));
        t1.start();
        t2.start();
    }

    static class AddBook implements Runnable {
        BookStation station;

        public AddBook(BookStation station) {
            this.station = station;
        }

        @Override
        public void run() {
            while (true) {
                station.addBook("图书：" + System.currentTimeMillis());
            }
        }
    }

    static class SellBook implements Runnable {
        BookStation station;

        public SellBook(BookStation station) {
            this.station = station;
        }

        @Override
        public void run() {
            while (true) {
                station.sellBook();
            }
        }
    }

    static class BookStation {
        List<String> books = new ArrayList<>();

        public void addBook(String name) {
            books.add(name);
            Utils.log("add:::::" + name);
        }

        public void sellBook() {
            if (books.size() > 0) {
                Utils.log("sell=>" + books.get(0));
                books.remove(0);
            } else {
                Utils.log("已售完");
            }
        }
    }
}
