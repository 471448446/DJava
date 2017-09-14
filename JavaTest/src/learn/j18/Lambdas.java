package learn.j18;

import common.Utils;

/**
 * 接口里面只能有一个method
 * https://www.youtube.com/watch?v=nL7H4F_ly_k&list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3&index=5
 * Created by better on 2017/6/14.
 */

public class Lambdas {
    interface Action {
        void onTalk();
    }
    @FunctionalInterface
    interface Action2 {
        void onTalk(String msg);
    }

    interface Action3 {
        String onTalk(String msg);
    }
    public static abstract class Action4{
        public abstract void onTalk();
    }
    static class Man {
        void setTalkAction(Action action) {
            action.onTalk();
        }

        void setTalkAction2(Action2 action) {
            action.onTalk("老板找你谈话");
        }

        void setTalkAction3(Action3 action) {
            Utils.log("返回:" + action.onTalk("老板找你谈话"));
        }
        void setTalkAction4(Action4 action){

        }
    }

    public static void main(String[] args) {
        System.out.print(false);
        Man man = new Man();
        man.setTalkAction(new Action() {
            @Override
            public void onTalk() {
                Utils.log("=>无参数，无返回值");
            }
        });
        man.setTalkAction2(new Action2() {
            @Override
            public void onTalk(String msg) {
                Utils.log("=>有参数，无返回值" + "；" + msg);

            }
        });
        man.setTalkAction3(new Action3() {
            @Override
            public String onTalk(String msg) {
                Utils.log("=>有参数，有返回值" + "；" + msg);
                return msg;
            }
        });
//        ()->{}
        Man man1 = new Man();
        man1.setTalkAction(() -> Utils.log("=>无参数，无返回值"));
        man1.setTalkAction2((String msg) -> Utils.log("=>有参数，无返回值" + "；" + msg));
        man1.setTalkAction3((String msg) -> {
            Utils.log("=>有参数，有返回值" + "；" + msg);
            return msg;
        });
//        man1.setTalkAction4(()-> Utils.log("ok"));
    }
}
