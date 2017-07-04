package learn.j18.demo;

/**
 * Created by better on 2017/6/14.
 */
public class Persion {
    private String name;
    private int age;
    private double money;

    public Persion(String name, int age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    @Override
    public String toString() {
        return name + ", " + age +
                ", " + money;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
