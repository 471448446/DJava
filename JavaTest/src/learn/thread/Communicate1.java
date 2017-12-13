package learn.thread;

import common.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ͬ�̲߳���ͳһ��Դ�����Ƕ�����ͬ��
 * ����һ��������棬���ϵ����������������п��˲��ϵĽ������ߡ����������������ͼ��ı仯
 * ���з����кܶ���Ϣ
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
                station.addBook("ͼ�飺" + System.currentTimeMillis());
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
                Utils.log("������");
            }
        }
    }
}
