/**
 * 文件名：HelloWorld.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 数组
 * 时间：2021-4-3
 */
import java.lang.Math;

public class HelloWorld {
    /* 类方法 */
    // 找最小值
    public static int findMin(int[] a) {
        int min = a[0];
        for(int i = 0; i < a.length; i++) {
            if(a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }
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
        /* 找最小值 */
        int[] a = new int[5];
        int[] b = new int[] {1, 2, 3, 4, 5, 6, 6, 6, 6, 6};
        int[] c = {7, 8, 9};
        System.out.println(a[2]);                      // 默认填充 0
        a[0] = (int) (Math.random() * 100);
        a[1] = (int) (Math.random() * 100);
        a[2] = (int) (Math.random() * 100);
        a[3] = (int) (Math.random() * 100);
        a[4] = (int) (Math.random() * 100);
        
        System.out.println("数组长度:" + a.length);    // 返回数组长度
        System.out.println("数组中的各个随机数是:");
        HelloWorld.showArray(a);
         
        System.out.println("本练习的目的是，找出最小的一个值: " + HelloWorld.findMin(a));

        /* 选择排序：升序 */
        System.out.println("\n选择排序：升序");
        for(int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length; j++) {
                if(a[i] > a[j]) {
                    // 交换
                    a[i] += a[j];
                    a[j] = a[i] - a[j];
                    a[i] = a[i] - a[j];
                }
            }
        }
        HelloWorld.showArray(a);

        /* 冒泡排序：降序 */
        System.out.println("\n冒泡排序：降序");
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length-i-1; j++) {
                if(a[j] < a[j+1]) {
                    // 交换
                    a[j] += a[j+1];
                    a[j+1] = a[j] - a[j+1];
                    a[j] = a[j] - a[j+1];
                }
            }
        }
        HelloWorld.showArray(a);

        /* 复制数组 */
        System.out.println("\n复制数组：将数组 a 前 5 位复制给数组 b");
        System.arraycopy(a, 0, b, 0, a.length);   // System.arraycopy(源数组，源起始位，目标数组，目标起始位，复制的长度)
        HelloWorld.showArray(b);

        /* 二维数组 */
        int[][] arr1 = new int[2][3];
        int[][] arr2 = new int[2][];
        arr2[0] = new int[3];    // 可分配不同长度
        arr2[1] = new int[6];
        int[][] arr3 = {{2, 2, 3}, {2, 3}, {2, 3, 3, 3}};
    }
}