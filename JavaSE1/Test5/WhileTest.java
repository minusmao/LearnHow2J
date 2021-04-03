/**
 * 文件名：WhileTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 流程控制 -> while
 * 时间：2021-4-3
 */
import java.util.Scanner;

public class WhileTest {
    /* 程序入口 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字：");
        int a = scanner.nextInt();
        int b = 1;

        // 计算阶乘
        while(a > 1) {
            b *= a--;
        }

        System.out.println("它的阶乘为：" + b);
    }
}