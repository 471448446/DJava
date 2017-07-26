package algorithm.linear.list;

/**
 * ���Դ洢�ṹ java�� ArrayList���õ�һ��������ά����˳��洢�ṹ
 * Created by better on 2017/4/18.
 */
public class LinkList implements IList {
    /* ͷ�ڵ�  --better 2017/4/18 22:10. */
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
        /* Ҫ��pλ�ò���,��ôӦ���ҵ�p-1��λ�� --better 2017/4/18 23:06. */
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
            throw new IndexOutOfBoundsException("�����Ȳ��� " + outOfBoundsMsg(p));
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
        /* ����ͷָ�룬��null�����ʱ��  --better 2017/4/18 23:04. */
        if (i == -1) {
            current = headNode;
        }
        return current;
    }

    /**
     * ����λ��p�Ƿ�Ϸ�
     *
     * @param p λ��
     */
    private void checkIndex(int p) {
        if (p < 0 || (int) headNode.getData() < p) {
            throw new IndexOutOfBoundsException("�����Ȳ��� " + outOfBoundsMsg(p));
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
