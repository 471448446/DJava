package lean;

import java.io.Serializable;

class Test implements Cloneable, Serializable {
    private int num = 10;

    public int add(int i) {
        int j = 10;
        num = num + i;
        return num;
    }
}