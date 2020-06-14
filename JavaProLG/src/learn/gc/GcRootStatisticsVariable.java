package learn.gc;

/**
 * statistic bianliang
 * Created by better on 2020/5/17.
 */
public class GcRootStatisticsVariable {
    private static final int _10M = 10 * 1024 * 1024;
    private byte[] memory;
    private static GcRootStatisticsVariable instance;

    public GcRootStatisticsVariable(int size) {
        memory = new byte[size * _10M];
    }

    public static void main(String[] args) {
        System.out.println("---gc statistics start---");
        GCRootUtils.printMemory();
        // 40M
        GcRootStatisticsVariable g = new GcRootStatisticsVariable(4);
        g.instance = new GcRootStatisticsVariable(8);
        g = null;
        System.gc();
        GCRootUtils.printMemory();
        System.out.println("---gc statistics end---");
    }
}
