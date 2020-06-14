package learn.gc;

/**
 * Created by better on 2020/5/17.
 */
public class GcRootClassVariable {
    private static final int _10M = 10 * 1024 * 1024;
    private byte[] memory;
    private GcRootClassVariable instance;

    public GcRootClassVariable(int size) {
        memory = new byte[size * _10M];
    }

    public static void main(String[] args) {
        System.out.println("---gc classVariable start---");
        GCRootUtils.printMemory();
        // 40M
        GcRootClassVariable g = new GcRootClassVariable(4);
        g.instance = new GcRootClassVariable(8);
        g = null;
        System.gc();
        GCRootUtils.printMemory();
        System.out.println("---gc classVariable end---");
    }
}
