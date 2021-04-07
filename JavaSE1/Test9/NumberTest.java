/**
 * 文件名：NumberTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 数字与字符串
 * 时间：2021-4-6
 */

import java.lang.Math;
import java.util.Locale;

public class NumberTest {
    // 返回 range 以内的质数个数
    public static int getNum(int range) {
        int count = 1;   // 质数个数（2 为质数，提前记下）
        for(int i = 3; i < range; i++) {
            for(int j = 2; j < i; j++) {
                if(0 == i%j) {
                    // 如果 i 除以 j 余数为0，说明 i 是合数
                    break;
                } else if(j == i-1) {
                    count++;
                }
            }
        }
        return count;
    }
    // 返回长度为 range 的随机字符串，包括数字、大小写字母，一共 62 个字符
    public static String getStr(int range) {
        // 0~9 的 ASCII 值为 48~57
        // A~Z 的 ASCII 值为 65~90
        // a~z 的 ASCII 值为 97~122
        char[] str = new char[range];
        for(int i = 0; i < range; i++) {
            int rand = (int)(Math.random()*62);
            if(rand <= 9) {
                str[i] = (char)(rand + 48);
            } else if(rand <= 35) {
                str[i] = (char)(rand - 10 + 65);
            } else {
                str[i] = (char)(rand - 36 + 97);
            }
        }
        return String.valueOf(str);
    }
    /* 程序入口 */
    public static void main(String[] args) {
        /* 装箱拆箱 */
        // 所有的基本类型，都有对应的类类型
        // 数字封装类有 Byte、Short、Integer、Long、Float、Double，这些类都是抽象类 Number 的子类
        int i = 1;
        Integer integer;
        // 基本类型 -> 封装类型
        integer = Integer.valueOf(i);
        //integer = new Integer(i);    // Java11 提示已过时
        integer = i;    // 自动装箱
        // 封装类型 -> 基本类型
        i = integer.intValue();
        i = integer;    // 自动拆箱
        //int的最大值
        System.out.println(Integer.MAX_VALUE);
        //int的最小值      
        System.out.println(Integer.MIN_VALUE);

        byte b = integer.byteValue();    // 不能自动拆箱

        /* 字符串转换 */
        String str;
        // 数字 -> 字符串
        str = String.valueOf(i);       // 法一
        Integer in = i;
        str = in.toString();           // 法二
        // 字符串 -> 数字
        str = "999";
        in = Integer.valueOf(str);     // 法一，Integer.valueOf(str) 返回对象
        i = Integer.parseInt(str);     // 法二，Integer.parseInt(str) 返回 int 基本类型
        // 测试
        float f1 = 5.4F;
        float f2 = 5.5F;
        //f = Float.parseFloat("3.1a4");    // 运行错误

        /* 数学方法 Math */
        // 四舍五入
        System.out.println("f1 = " + Math.round(f1) + ", f2 = " + Math.round(f2));
        // 得到一个0-1之间的随机浮点数（取不到1）
        System.out.println(Math.random());
        // 开方
        System.out.println(Math.sqrt(9));
        // 次方（2的4次方）
        System.out.println(Math.pow(2,4));
        // π
        System.out.println(Math.PI);
        // 自然常数
        System.out.println(Math.E + "; " + Math.pow(1+1/1000.0,1000));
        // 练习：求一千万以内的质数
        System.out.println(NumberTest.getNum(100));    // 太慢了，改一百以内

        /* 格式化输出 */
        //%s表示字符串，%d表示数字，%n表示换行（使用 %n 换行用于跨平台）
        String sentenceFormat ="%s 在进行了连续 %d 次击杀后，获得了 %s 的称号%n";
        System.out.format(sentenceFormat, "name", 10, "title");
        System.out.printf(sentenceFormat, "name", 10, "title");    // 内部调用 format

        int year = 2020;
        //总长度，左对齐，补0，千位分隔符，小数点位数，本地化表达
        //直接打印数字
        System.out.format("%d%n",year);
        //总长度是8,默认右对齐
        System.out.format("%8d%n",year);
        //总长度是8,左对齐
        System.out.format("%-8d%n",year);
        //总长度是8,不够补0
        System.out.format("%08d%n",year);
        //千位分隔符
        System.out.format("%,8d%n",year*10000);
        //小数点位数
        System.out.format("%.2f%n",Math.PI);
        //不同国家的千位分隔符
        System.out.format(Locale.FRANCE,"%,.2f%n",Math.PI*10000);
        System.out.format(Locale.US,"%,.2f%n",Math.PI*10000);
        System.out.format(Locale.UK,"%,.2f%n",Math.PI*10000);

        /* 字符 */
        System.out.println(Character.isLetter('a'));//判断是否为字母
        System.out.println(Character.isDigit('a')); //判断是否为数字
        System.out.println(Character.isWhitespace(' ')); //是否是空白
        System.out.println(Character.isUpperCase('a')); //是否是大写
        System.out.println(Character.isLowerCase('a')); //是否是小写
         
        System.out.println(Character.toUpperCase('a')); //转换为大写
        System.out.println(Character.toLowerCase('A')); //转换为小写
 
        //String a = 'a'; //不能够直接把一个字符转换成字符串
        String a2 = Character.toString('a'); //转换为字符串

        System.out.println("使用\\t制表符可以达到对齐的效果");
        System.out.println("abc\tdef");
        System.out.println("ab\tdef");
        System.out.println("a\tdef");

        // 字符串 -> 字符数组
        String str1 = "abc123";
        char[] cs = str1.toCharArray();
        // 字符数组 -> 字符串
        str1 = String.valueOf(cs);

        /* 字符串 */
        // String 类被 final 修饰
        String galen ="盖伦";                // 字面值，虚拟机碰到字面值就会创建一个字符串对象
        String teem = new String("提莫");    // 创建了两个字符串对象
        // 字符串长度
        System.out.println(galen.length());
        // 练习：创建一个长度是5的随机字符串
        System.out.println(NumberTest.getStr(5));
    }
}