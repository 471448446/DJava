package learn.bit;

/**
 * 通过或|操作记录值
 * 通过与&操作取值
 * 通过取反~和与&操作来剔除已设置的值
 */
public class LeftRightMove {
    private static final int flag_0 = 0x00000000;
    // (1<<0)
    private static final int flag_1 = 0x00000001;
    // (1<<1)
    private static final int flag_2 = 0x00000002;
    // (1<<2)
    private static final int flag_4 = 0x00000004;
    // (1<<3)
    private static final int flag_8 = 0x00000008;
    // (1<<4)
    private static final int flag_16 = 0x00000010;
    // (1<<6)
    private static final int flag_64 = 0x00000040;
    // (1<<7)
    private static final int flag_128 = 0x00000080;

    public static void main(String[] args) {
        System.out.println(flag_128);
        // set
        int i = 0;
        i |= flag_8;
        System.out.println("i=" + i);
        // get
        System.out.println("i=" + (i & flag_8));
        // unset
        i &= ~flag_8;
        System.out.println("i=" + i + ",(i & flag_8)=" + (i & flag_8));
        //=====demo
        // 若i本身就没有设置 128 ，若直接走unset会发生什么，并没有什么影响
        i |= flag_1;
        i &= ~flag_16;
        System.out.println("i=" + i + ",get flag_16 =" + (i & flag_16));
        System.out.println("i=" + i + ",get flag_8 =" + (i & flag_8));
        System.out.println("i=" + i + ",get flag_1 =" + (i & flag_1));
        //=====demo
        // 先让j记录一大堆flag，然后取出来判断下，是否包含某个flag
        int j = 0;
        j = j | flag_2;
        j = j | flag_4;
        j = j | flag_8;
        j = j | flag_16;
        j = j | flag_64;
        System.out.println("j=" + j + " if contain flag_2:" + ((j & flag_2) == flag_2));
        System.out.println("j=" + j + " if contain flag_4:" + ((j & flag_4) == flag_4));
        System.out.println("j=" + j + " if contain flag_16:" + ((j & flag_16) == flag_16));
        j &= ~flag_16;
        System.out.println("after unset flag_16 j=" + j + " if contain flag_16:" + ((j & flag_16) == flag_16));
    }
}
