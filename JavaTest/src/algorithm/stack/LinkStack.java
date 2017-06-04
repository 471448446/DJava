package algorithm.stack;

/**
 * 链试栈
 * 头指针当做栈顶元素，这样进出栈减少了遍历。
 * Created by better on 2017/4/26.
 */
public class LinkStack implements IStack {
    Node top;
    int size;

    @Override
    public boolean push(Object o) {
        Node temp = new Node(o);
        if (isEmpty()) {
            top = temp;
        } else {
            temp.setNext(top);
            top = temp;
        }
        size++;

        return true;
    }

    @Override
    public boolean pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("空栈出栈");
        }
        Node temp = top.getNext();
        top.setNext(null);
        top = temp;
        size--;
        return true;
    }

    @Override
    public void clear() {
        if (null == top) return;
        Node current = top;
        Node next;
        while (null != current) {
            next = current.getNext();
            current.setNext(null);
            current = next;
            size--;
        }
        // 头指针
        pop();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    @Override
    public String toString() {
        return "LinkStack{" +
                "top=" + top +
                ", size=" + size +
                '}';
    }
}
