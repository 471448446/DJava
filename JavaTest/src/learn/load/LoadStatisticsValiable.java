package learn.load;

public class LoadStatisticsValiable {
    public static String NAME = "fucker";

    public LoadStatisticsValiable() {
        System.out.println("LoadStatistics class load constructor LoadStatistics{} block");
    }

    static {
        System.out.println("load statistic{} block");
    }


}
