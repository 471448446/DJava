package learn.collections;

public class BeanB {
    int count;

    BeanB(int count) {
        this.count = count;
    }

    int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "count=" + count +
                '}';
    }

}
