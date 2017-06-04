package algorithm.stack;

/**
 * ջ��˳��洢�ṹ��
 * �ڲ���������ά��������Ԫ�ء�
 * ��һ��ָ����ֻ�ǵ�ǰ��ջ��Ԫ��
 * ջ�����ڵ�һ��λ�ü�ͷ��;
 * Created by better on 2017/4/25.
 */
public class SortStack implements IStack {
    public final int MAX_LENGTH = 20;
    int top = -1;
    private Object[] objects = new Object[MAX_LENGTH];

    @Override
    public boolean push(Object o) {
        if (top == MAX_LENGTH - 1) {
            throw new IllegalArgumentException("ջ����:" + objects.length + ",��ǰ," + top);
        }
        top++;
        objects[top] = o;
        return true;
    }

    @Override
    public boolean pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("��ջ");
        }
        objects[top] = null;
        top--;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < objects.length; i++) {
            objects[i] = null;
        }
        top = -1;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}
