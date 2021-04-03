/**
 * 文件名：HelloWorld.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> JAVA基础 -> 操作符
 * 时间：2021-4-3
 */
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        //====== 算术操作符 ======//
        /* 用 Scanner 获取输入，并加法计算 */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个整数：");
        int a = scanner.nextInt();    // 获取输入
        System.out.println("请输入第二个整数：");
        int b = scanner.nextInt();
        System.out.println("它们的和为：" + (a + b));
        // 读取字符串
        scanner.nextLine();    // 获取上一次输入时，留下的回车
        System.out.println("请输入字符串");
        String str = scanner.nextLine();
        System.out.println("您输入的是：" + str);

        /* 计算 BMI 值 */
        System.out.println("请输入身高（m）：");
        float height = scanner.nextFloat();    // 获取输入
        System.out.println("请输入体重（kg）：");
        float width = scanner.nextFloat();
        System.out.println("当前的 BMI 值是：" + (width/(height*height)));

        //====== 关系操作符 ======//
        /* 比较 */
        System.out.println("a > b: " + (a>b));

        //====== 逻辑操作符 ======//
        /* 长路与（&）  和   短路与（&&） */
        // 短路与：第一个为 false，则不会执行第二个

        /* 长路或（|）  和   短路与（||） */
        // 短路或：第一个为 true，则不会执行第二个

        /* 取反（前缀!）*/
        boolean bool = true;
        System.out.println(!bool);

        /* 异或（^）不同为真 */
        boolean bool2 = false;
        System.out.println(bool ^ bool2);

        //====== 位操作符 ======//
        /* 与 C 语言类似，包括：位与（&）、位或（|）、位异或（^）、取非（~） */
        /* 还有：左移（<<）、右移（>>）、无符号右移（>>>），无符号右移即前面只补零 */
        System.out.println("1024/16 = " + (1024/16) + "\n1024>>4 = " + (1024>>4));    // 数字除以 16 等于其二进制右移 4 位

        //====== 赋值操作符 ======//
        /* 与 C 语言类似，包括 +=、-= 等 */

        //====== 三元操作符 ======//
        System.out.println(2 > 3? 4 : 5);    // 与 C 语言一样
    }
}