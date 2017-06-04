package algorithm.stack;

import common.Utils;

/**
 * Created by better on 2017/4/26.
 */
public class Main {
    public static void main(String[] args) {
        LinkStack linkStack = new LinkStack();
        linkStack.push("AAA");
        Utils.log(linkStack.toString());
        linkStack.push("BBB");
        linkStack.push("CC");
        linkStack.push("D");
        Utils.log(linkStack.toString());
        linkStack.pop();
        Utils.log(linkStack.toString());
        linkStack.clear();
        Utils.log(linkStack.toString());
    }
}
