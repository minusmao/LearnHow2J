/**
 * 文件名：IfTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 流程控制 -> if
 * 时间：2021-4-3
 */
import java.util.Scanner;

public class IfTest {
    /* 类方法 */
    // 判断 BMI
    public static void BMI() {
        float bmi;
        Scanner scanner = new Scanner(System.in);
        /* 计算 BMI 值 */
        System.out.println("请输入身高（m）：");
        float height = scanner.nextFloat();    // 获取输入
        System.out.println("请输入体重（kg）：");
        float width = scanner.nextFloat();
        bmi = width/(height*height);
        System.out.println("当前的 BMI 值是：" + bmi);

        // 判断身体状态
        if(bmi < 18.5) {
            System.out.println("体重过轻");
        } else if(bmi < 24) {
            System.out.println("正常范围");
        } else if(bmi < 27) {
            System.out.println("体重过重");
        } else if(bmi < 30) {
            System.out.println("轻度肥胖");
        } else if(bmi < 35) {
            System.out.println("中度肥胖");
        } else {
            System.out.println("重度肥胖");
        }
    }
    // 判断闰年
    public static void yearIs(int year) {
        if((year%400 == 0) || ((year%4==0) && (year%100!=0))) {
            System.out.println(year + "是闰年");
        } else {
            System.out.println(year + "不是闰年");
        }
    }
    public static void main(String[] args) {
        IfTest.BMI();
        IfTest.yearIs(1600);
        IfTest.yearIs(1700);
        IfTest.yearIs(1704);
    }
}