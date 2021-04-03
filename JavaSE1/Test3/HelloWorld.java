/**
 * 文件名：HelloWorld.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> JAVA基础 -> 变量
 * 时间：2021-4-3
 */

public class HelloWorld {
    public static void main(String[] args) {
        /* 整型（字面值默认为 int） */
        byte b = 1;                              // 占用 1 个字节（可以直接用 int 字面值赋值，但不能超过 byte 范围）
        short s = 65;                            // 占用 2 个字节（可以直接用 int 字面值赋值，但不能超过 short 范围）
        int i = 1;                               // 占用 4 个字节
        long l = 1;                              // 占用 8 个字节（可以直接用 int 字面值赋值，但若字面值超过 int 范围时，需要加 L 后缀将字面值改成 long 型）
        //b = 200;                               // 超过范围，编译会报错
        b = (byte)200;                           // 强制类型转换，会丢失前三个字节的数据
        System.out.println("b = " + b);
        // 补充
        int num1 = 255;                          // 十进制
        int num2 = 026;                          // 八进制
        int num3 = 0x26;                         // 十六进制
        int num4 = 0b1001;                       // 二进制，Java7 加入
        // 查看一个整形对应的二进制
        System.out.println(Integer.toBinaryString(num1));
        // 查看两 short 型相加是什么类型
        short x = 20;
        short y = 30;
        //x = x + y;                             // 错误: 不兼容的类型: 从int转换到short可能会有损失（说明 x + y 是 int 型）
        x = (short)(x + y);

        /* 字符型 */
        char c = '中';                           // 占用 2 个字节，长度与 short 一样，但彼此之间任需要强制类型转换
        c = (char)s;
        //char c = '你好';                       // 只能放一个字符，报错
        // 补充
        char c2 = '\\';                          // 转义字符，表示 \

        /* 浮点型（字面值默认为 double） */
        double d = 123.45;                       // 占用 8 个字节
        //float f = 123.45;                      // 占用 4 个字节，这里编译会报错，因为字面值 123.45 默认是 double 型
        float f2 = 123.45F;                      // 加上后缀 F，字面值 123.45F 为 float 型
        float f3 = (float)123.45;                // 也可强制类型转换
        System.out.println("d = " + d + "\nf2 = " + f2 + "\nf3 = " + f3);
        // 补充
        double d2 = 1.23e3;                      // 科学计数法，表示为 1.23×10^3

        /* 布尔型 */
        boolean b1 = true;
        boolean b2 = false;
        //b1 = (boolean)3;                       // 不能用数字赋值

        /* 字符串 */
        String str = "Hello Java";
        System.out.println(str);
    }
}