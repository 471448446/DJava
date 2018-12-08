package learn.collections;


class BeanA implements Comparable<BeanA> {
    int count;

    BeanA(int count) {
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

    @Override
    public boolean equals(Object obj) {
        // 只是为了适应replaceAll()
        if (obj instanceof BeanA) {
            return count == ((BeanA) obj).count;
        }
        return super.equals(obj);
    }

    @Override
    public int compareTo(BeanA o) {
        return Integer.compare(count, o.count);
    }
}
