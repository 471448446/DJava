package better.kotlin.learn.type;

import better.kotlin.UtilsKt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by better on 2017/8/11.
 */
public class TypeJava {
    static class EatThing<A extends Food> {
        public A someTing;

        public EatThing(A someTing) {
            this.someTing = someTing;
        }
    }

    interface Food {
        String getShape();
    }

    interface CircleFood extends Food {
    }

    public static class Pear implements CircleFood {
        @Override
        public String getShape() {
            return "圆形的梨子";
        }
    }

    public static class WhitePear extends Pear {
        @Override
        public String getShape() {
            return "白色，" + super.getShape();
        }
    }

    public static class SugerWhitePear extends WhitePear {
        @Override
        public String getShape() {
            return "甜的，" + super.getShape();
        }
    }

    public static class WaterMelon implements CircleFood {

        @Override
        public String getShape() {
            return "圆西瓜";
        }
    }


    /**
     * 通配符下，只能是某类或其子类
     * Create By better on 2017/8/11 11:34.
     */
    public static void eatFoodChild(EatThing food) {
        UtilsKt.log("吃:" + food.someTing.getShape());
    }

    public static void eatFoodParent(EatThing food) {
        UtilsKt.log("吃:" + food.someTing.getShape());
    }

    public static void main(String[] args) {
        eatFoodChild(new EatThing<>(new WhitePear()));
        eatFoodParent(new EatThing<>(new WhitePear()));
        List<? extends WhitePear> listPearChild = new ArrayList<>();
        List<? super WhitePear> listWhitePearParent = new ArrayList<>();

        //报错
//        listPearChild.add(new SugerWhitePear());
//        listPearParent.add(new Pear());
        // 例外
//        listPearChild.add(null);

        // 取
        List<SugerWhitePear> listSuger = new ArrayList<>();
        listSuger.add(new SugerWhitePear());
        listPearChild = listSuger;

        UtilsKt.log("取值：" + listPearChild.get(0).getShape());

        //放
        List<Pear> list = new ArrayList<>();
        list.add(new Pear());
        listWhitePearParent = list;

        UtilsKt.log("取不出具体的值：" + listWhitePearParent.get(0));
    }
}
