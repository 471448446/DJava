package algorithm.linear.list;

import java.util.Arrays;

/**
 * 顺序存储:值在一个连续的地址里面->数组里面。
 * 插入、删除元素的时候要移动位置，保证值连续。
 * 但是我在插入数据的时候不选中连续的位置插入，造成的结果是值还是不连续的--bug？？
 * Created by better on 2017/4/18.
 */
public class SortList implements IList {
    public final int MAX_LENGTH = 20;
    private Object[] list;
    private int length = 0;

    public SortList() {
        list = new Object[MAX_LENGTH];
    }

    @Override
    public boolean isEmpty() {
        return length != 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < list.length; i++) {
            list[i] = null;
        }
        length = 0;
    }

    @Override
    public Object getElem(int i) {
        if (i > size() - 1 || 0 > i) {
            return null;
        }
        return list[i];
    }

    @Override
    public boolean insert(int p, Object o) {
        /**
         * 已满或不合法
         */
        if (size() == MAX_LENGTH || 0 > p || p > MAX_LENGTH - 1) return false;
        /* 不在尾部  --better 2017/4/18 21:28. */
        if (p != MAX_LENGTH - 1) {
            for (int i = size(); i > p; i--) {
                list[i] = list[i - 1];
            }
        }
        list[p] = o;
        length++;
        return true;
    }

    @Override
    public boolean delete(int p) {
        if (0 > p || p > MAX_LENGTH - 1) return false;
        if (p != MAX_LENGTH - 1) {
            for (int i = p; i < size() - 1; i++) {
                list[i] = list[i + 1];
            }
        }
        list[p] = null;
        length--;
        return true;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public String toString() {
        return "SortList{" +
                "MAX_LENGTH=" + MAX_LENGTH +
                ", list=" + Arrays.toString(list) +
                ", length=" + length +
                '}';
    }
}
