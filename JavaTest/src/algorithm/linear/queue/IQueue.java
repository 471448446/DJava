package algorithm.linear.queue;

/**
 * Created by better on 2017/4/27.
 */
public interface IQueue {
    void clear();

    void add(Object o);

    /**
     * 返回队首元素并移除
     */
    Object remve();

    /**
     * 队首元素
     */
    Object element();

    boolean isEmpty();

}
