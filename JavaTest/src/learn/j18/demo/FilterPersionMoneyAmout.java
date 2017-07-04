package learn.j18.demo;

/**
 * Created by better on 2017/6/14.
 */
public class FilterPersionMoneyAmout implements IFilterPsersion {
    @Override
    public boolean filter(Persion persion) {
        return persion.getMoney() > 5000;
    }
}
