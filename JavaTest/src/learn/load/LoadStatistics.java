package learn.load;

public class LoadStatistics {
    public static final String NAME = "fucker";

    public LoadStatistics() {
        System.out.println("LoadStatistics class load constructor LoadStatistics{} block");
    }

    static {
        System.out.println("load statistic{} block");
    }


}
