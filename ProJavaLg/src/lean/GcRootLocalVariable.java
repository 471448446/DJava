package lean;

class GcRootLocalVariable {
    private static final int _10M = 10 * 1024 * 1024;
    // 80M no static
    private byte[] memory = new byte[8 * _10M];

    public static void main(String[] args) {
        printMemory();
        method();
        System.gc();
        System.out.println("gc 2 done");
        printMemory();
    }

    private static void method() {
        GcRootLocalVariable g = new GcRootLocalVariable();
        System.gc();
        System.out.println("gc 1 done");
        printMemory();
    }

    private static void printMemory() {
        System.out.print("current Mem: " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
        System.out.println(",total Mem: " + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
    }
}