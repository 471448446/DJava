package algorithm.queue;

import java.util.Queue;

/**
 * Created by better on 2017/4/27.
 */
public interface IQueue {
    void clear();

    void add(Object o);

    /**
     * ���ض���Ԫ�ز��Ƴ�
     */
    Object remve();

    /**
     * ����Ԫ��
     */
    Object element();

    boolean isEmpty();

}
