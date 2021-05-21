package algorithm.lt.array;

/**
 * 螺旋矩阵
 * 题目地址：https://leetcode-cn.com/problems/spiral-matrix-ii/
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class PArraySpiral {
    public static void main(String[] args) {
        /*
         1, 2, 3
         8, 9, 4
         7, 6, 5
         */
        testSpiral(3);
        /*
         1, 2, 3, 4
        12,13,14, 5
        11,16,15, 6
        10, 9, 8, 7
         */
        testSpiral(4);
        /*
         1, 2, 3, 4, 5
        16,17,18,19, 6
        15,24,25,20, 7
        14,23,22,21, 8
        13,12,11,10, 9
         */
        testSpiral(5);
        /*
         1, 2, 3, 4, 5, 6, 7, 8, 9
        32,33,34,35,36,37,38,39,10
        31,56,57,58,59,60,61,40,11
        30,55,72,73,74,75,62,41,12
        29,54,71,80,81,76,63,42,13
        28,53,70,79,78,77,64,43,14
        27,52,69,68,67,66,65,44,15
        26,51,50,49,48,47,46,45,16
        25,24,23,22,21,20,19,18,17
         */
        testSpiral(9);
    }

    private static void testSpiral(int n) {
        int[][] array = spiralArray(n);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != 0) {
                    builder.append(",");
                }
                builder.append(array[i][j] > 9 ? array[i][j] : " " + array[i][j]);
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }

    /**
     * 二维数组的访问
     * 解题思路，按照圈层来填充
     * 不要局限于二维数据每次循环，访问一行或者一列的思维（比如打印数据时），也可以跳起访问嘛
     */
    private static int[][] spiralArray(int n) {
        //先申明结果
        int[][] array = new int[n][n];
        /*
           左右、上下、右左、下上
           的方式填充数据算一圈
           每一层的最后一个是下一层起点[)左闭右开
         */
        int circle = n / 2;
        int x = 0, y = 0;
        // 第一层少一个，第二层少三个
        int offset = 1;
        // 当前的数字
        int number = 1;
        int j, k;
        // 二位数组的访问方式array[第几行][第几列]
        for (int i = 0; i < circle; i++) {
            for (j = x; j < x + n - offset; j++) { //x + n - offset 这一行最后一个放弃
                //首行
                array[x][j] = number++;
            }
            for (k = y; k < y + n - offset; k++) {
                // 尾列
                array[k][n - y - 1] = number++;
            }
            for (; j > x; j--) {//j>x 而不是 j>0
                // 尾行
                array[n - x - 1][j] = number++;
            }
            for (; k > y; k--) {
                // 首列
                array[k][y] = number++;
            }
            x++;
            y++;
            offset += 2;
        }
        if (n % 2 != 0) {
            array[n / 2][n / 2] = number;
        }
        return array;
    }
}
