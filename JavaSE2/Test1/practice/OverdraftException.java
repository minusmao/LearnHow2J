/**
 * 文件名：OverdraftException.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 异常处理 -> 综合练习
 * 时间：2021-4-10
 */

package practice;

public class OverdraftException extends Exception {
    /* 对象属性 */
    private double deficit;    // 透支额

    /* 对象方法 */
    // 带参构造方法
    public OverdraftException(String msg, double deficit) {
        super(msg);
        this.deficit = deficit;
    }
    // 获得透支额
    public double getDeficit() {
        return this.deficit;
    }
}