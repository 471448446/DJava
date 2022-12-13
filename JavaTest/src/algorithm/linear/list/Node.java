package algorithm.linear.list;

/**
 * Created by better on 2017/4/18.
 */
public class Node {
    /* 数据  --better 2017/4/18 22:14. */
    private Object data;
    /* 下一个节点信息  --better 2017/4/18 22:14. */
    private Node next;

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
