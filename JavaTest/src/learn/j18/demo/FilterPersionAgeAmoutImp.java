package learn.j18.demo;

/**
 * Created by better on 2017/6/14.
 */
public class FilterPersionAgeAmoutImp implements IFilterPsersion {
    @Override
    public boolean filter(Persion persion) {
        return persion.getAge() > 20;
    }
}
