package learn;

import common.Utils;

/**
 * finally����ȷ�������������飬�������쳣
 * Created by better on 2018/3/27.
 */
public class TryException {
    public static void main(String[] args) {
        try {
            int i = 100 / 0;
            Utils.log("" + i);
        } catch (Exception e) {
            Utils.log("" + 1);
            throw new RuntimeException();
        } finally {
            Utils.log("" + 2);
        }
        Utils.log("" + 3);
    }
}
