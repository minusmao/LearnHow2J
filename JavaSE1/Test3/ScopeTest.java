/**
 * 文件名：ScopeTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> JAVA基础 -> 变量 -> 作用域
 */

public class ScopeTest {
    /* 对象属性 */
    private int num1 = 1;
    private int num2 = 3;

    /* 对象方法 */
    public void method1() {
        System.out.println(this.num1);
    }
    public void method2(String num2) {
        System.out.println(num2);    // 方法的形参 num2 会覆盖对象的 num2
    }
    public void method3(final int a) {
        final int b;    // 被 final 修饰，只能被赋值一次
        //a = 1111;     // 编译报错，形参被 final 修饰，调用方法就已经赋值一次
        b = 2222;
    }

    /* 程序入口 */
    public static void main(String[] args) {
        ScopeTest scopeTest = new ScopeTest();

        scopeTest.method1();
        scopeTest.method2("Hello");
    }
}