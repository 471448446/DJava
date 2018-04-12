package learn;

import common.Utils;

/**
 * 基本数据类型 ==和equal区别
 * Created by better on 2018/3/26.
 */
public class BasicDataTypeTest {
    public static void main(String[] args) {
        Float fa = new Float(0.1);
        Float fb = new Float(0.1);
        Utils.log("Float ==:" + (fa == fb));
        Utils.log("Float equal:" + (fa.equals(fb)));
        Double da = new Double(0.1);
        Double db = new Double(0.1);
        Utils.log("Double ==:" + (da == db));
        Utils.log("Double equal:" + (da.equals(db)));
        Integer ia = new Integer(1);
        Integer ib = new Integer(1);
        Utils.log("Integer ==:" + (ia == ib));
        Utils.log("Integer equal:" + (ia.equals(ib)));

    }
}
