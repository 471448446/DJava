package learn.load;

import common.Utils;

/**
 * 先加载（赋默认值），在初始化
 * Created by better on 2018/4/11.
 */
public class LoadInit1Main {
    public static void main(String[] args) {
        LoadInit1 loadInit1 = LoadInit1.getInstance();
        Utils.log("LoadInit1Main A=" + loadInit1.A);
        Utils.log("LoadInit1Main B=" + loadInit1.B);
    }
}
