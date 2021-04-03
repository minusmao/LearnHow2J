/**
 * 文件名：SwitchTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 流程控制 -> switch
 * 时间：2021-4-3
 */

public class SwitchTest {
    /* 类方法 */
    public static void monthIs(int month) {
        /* 判断季节 */
        // switch可以使用byte、short、int、char、String、enum
        // Java从1.7开始支持switch用String的，编译后是把String转化为hash值，其实还是整数
        switch(month) {
            case 1:
            case 2:
            case 3:
                System.out.println(month + "月是春天");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println(month + "月是夏天");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println(month + "月是秋天");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println(month + "月是冬天");
                break;
            default:
                System.out.println("月份错误");
                break;
        }
    }
    
    /* 程序入口 */
    public static void main(String[] args) {
        SwitchTest.monthIs(11);
    }
}