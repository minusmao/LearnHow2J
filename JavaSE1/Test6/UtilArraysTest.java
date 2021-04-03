/**
 * 文件名：UtilArraysTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 数组 -> 测试 java.util.Arrays 工具类
 * 时间：2021-4-3
 */
import java.util.Arrays;
import java.lang.Math;

public class UtilArraysTest {
    /* 类方法 */
    // 遍历数组
    public static void showArray(int[] array) {
        System.out.printf("{");
        // 使用 for-each（增强型 for 虚幻）
        for(int i : array) {
            System.out.printf("%d, ", i);
        }
        System.out.printf("\b\b}\n");    // 退格转义字符 -> '\b'
    }

    /* 程序入口 */
    public static void main(String[] args) {
        int[] a = {34, 25, 67, 12, 46};
        int[] b;

        UtilArraysTest.showArray(a);

        /* 数组复制 */
        b = Arrays.copyOfRange(a, 0, 3);    // copyOfRange(源数组, 起始（包括）, 末尾（不包括）)
        UtilArraysTest.showArray(b);

        /* 转化为字符串 */
        String str = Arrays.toString(a);
        System.out.println(str);

        /* 排序 */
        System.out.println("数组 a 排序前：");
        UtilArraysTest.showArray(a);
        Arrays.sort(a);
        System.out.println("数组 a 排序后：");
        UtilArraysTest.showArray(a);

        /* 搜索 */
        //使用binarySearch之前，必须先使用sort进行排序
        System.out.println("数字 12 出现的位置:" + Arrays.binarySearch(a, 12));

        /* 判断是否相同 */
        int[] arr1 = new int[] {1, 2, 3};
        int[] arr2 = new int[] {1, 2, 3};
        System.out.println("数组 arr1 与 arr2 是否相同：" + Arrays.equals(arr1, arr2));
        
        /* 填充 */
        System.out.println("数组 a 全填充 5 后：");
        Arrays.fill(a, 5);
        UtilArraysTest.showArray(a);

        /* 练习排序二维数组 */
        int[][] arrayDouble = new int[3][5];
        System.out.println("数组 arrayDouble 第一维的长度：" + arrayDouble.length);
        System.out.println("数组 arrayDouble[0] 的长度：" + arrayDouble[0].length);
        for(int i = 0; i < arrayDouble.length; i++) {
            for(int j = 0; j < arrayDouble[i].length; j++) {
                arrayDouble[i][j] = (int)(Math.random()*100);    // 生成随机数
            }
        }
        System.out.println("排序前的数组 arrayDouble：");
        for(int i = 0; i < arrayDouble.length; i++) {
            UtilArraysTest.showArray(arrayDouble[i]);
        }
        // 排序
        int[] arrayDoubleOne = new int[3 * 5];
        // 复制到一维数组
        for(int i = 0; i < arrayDouble.length; i++) {
            System.arraycopy(arrayDouble[i], 0, arrayDoubleOne, i*5, arrayDouble[i].length);
        }
        Arrays.sort(arrayDoubleOne);
        // 复制回二维数组
        for(int i = 0; i < arrayDouble.length; i++) {
            System.arraycopy(arrayDoubleOne, i*5, arrayDouble[i], 0, arrayDouble[i].length);
        }
        System.out.println("排序后的数组 arrayDouble：");
        for(int i = 0; i < arrayDouble.length; i++) {
            UtilArraysTest.showArray(arrayDouble[i]);
        }
    }
}