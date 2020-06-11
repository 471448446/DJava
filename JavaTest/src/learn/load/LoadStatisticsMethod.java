package learn.load;

public class LoadStatisticsMethod {
    public static final String NAME = "fucker";

    public LoadStatisticsMethod() {
        System.out.println("LoadStatistics class load constructor LoadStatistics{} block");
    }

    public static String justLoad() {
        return " public statistics method";
    }

    static {
        System.out.println("load statistic{} block");
    }


}
