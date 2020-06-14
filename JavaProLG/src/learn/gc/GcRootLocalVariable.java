package learn.gc;

class GcRootLocalVariable {
    private static final int _10M = 10 * 1024 * 1024;
    // 80M no static
    private byte[] memory = new byte[8 * _10M];

    public static void main(String[] args) {
        System.out.println("---gc local start---");
        GCRootUtils.printMemory();
        method();
        System.gc();
        System.out.println("gc 2 done");
        GCRootUtils.printMemory();
        System.out.println("---gc local end---");
    }

    private static void method() {
        GcRootLocalVariable g = new GcRootLocalVariable();
        System.gc();
        System.out.println("gc 1 done");
        GCRootUtils.printMemory();
    }

}