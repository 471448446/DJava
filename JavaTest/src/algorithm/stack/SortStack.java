package algorithm.stack;

/**
 * 栈的顺序存储结构。
 * 内部用数组来维护其数据元素。
 * 用一个指针来只是当前的栈顶元素
 * 栈低是在第一个位置即头部;
 * Created by better on 2017/4/25.
 */
public class SortStack implements IStack {
    public final int MAX_LENGTH = 20;
    int top = -1;
    private Object[] objects = new Object[MAX_LENGTH];

    @Override
    public boolean push(Object o) {
        if (top == MAX_LENGTH - 1) {
            throw new IllegalArgumentException("栈已满:" + objects.length + ",当前," + top);
        }
        top++;
        objects[top] = o;
        return true;
    }

    @Override
    public boolean pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("空栈");
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
