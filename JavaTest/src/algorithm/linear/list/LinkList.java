package algorithm.linear.list;

/**
 * 链试存储结构 java中 ArrayList是用的一个数组来维护，顺序存储结构
 * Created by better on 2017/4/18.
 */
public class LinkList implements IList {
    /* 头节点  --better 2017/4/18 22:10. */
    private Node headNode;

    public LinkList() {
        headNode = new Node(0);
        headNode.setNext(null);
    }

    @Override
    public boolean isEmpty() {
        return (int) headNode.getData() != 0;
    }

    @Override
    public void clear() {
        int size = (int) headNode.getData();
        Node p, q;
        p = headNode.getNext();
        for (int i = 0; i < size; i++) {
            q = p.getNext();
            p.setNext(null);
            p = q;
        }
        headNode.setNext(null);
        headNode.setData(0);
    }

    @Override
    public Object getElem(int p) {
        return null;
    }

    @Override
    public boolean insert(int p, Object o) {
        /* 要在p位置插入,那么应该找到p-1的位置 --better 2017/4/18 23:06. */
        checkIndex(p);
        Node pBefor = index(p - 1);
        Node insert = new Node(o);
        insert.setNext(pBefor.getNext());
        pBefor.setNext(insert);
        headNode.setData(size() + 1);
        return true;
    }

    @Override
    public boolean delete(int p) {
        checkDelete(p);
        Node pBefor = index(p - 1);
        Node pNode = index(p);

        pBefor.setNext(pNode.getNext());
        headNode.setData((int) headNode.getData() - 1);
        return false;
    }

    private void checkDelete(int p) {
        if (p < 0 || (int) headNode.getData() <= p) {
            throw new IndexOutOfBoundsException("链表长度不够 " + outOfBoundsMsg(p));
        }
    }

    @Override
    public int size() {
        return (int) headNode.getData();
    }

    private Node index(int p) {
        Node current = headNode;
        int i = -1;
        while (null != current) {
            if (i == p) break;
            current = current.getNext();
            i++;
        }
        /* 操作头指针，即null链表的时候  --better 2017/4/18 23:04. */
        if (i == -1) {
            current = headNode;
        }
        return current;
    }

    /**
     * 操作位置p是否合法
     *
     * @param p 位置
     */
    private void checkIndex(int p) {
        if (p < 0 || (int) headNode.getData() < p) {
            throw new IndexOutOfBoundsException("链表长度不够 " + outOfBoundsMsg(p));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + headNode.getData();
    }

    @Override
    public String toString() {
        return "LinkList{" +
                "headNode=" + headNode +
                '}';
    }

}
