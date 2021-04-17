/**
 * 文件名：Value.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 泛型
 * 时间：2021-4-15
 */

import java.lang.Comparable;

/**
 * 类名：Value
 * 功能：数据对象，实现了 Comparable<T> 接口，可添加到 BinaryTree 中
 */
public class Value implements Comparable<Value> {
    /* 对象属性 */
    private String name;
    private int num;

    /* 构造方法 */
    public Value(String name, int num) {
        this.name = name;
        this.num = num;
    }

    /* 对象方法 */
    // 重写了 Comparable<T> 接口的 compareTo(T anotherObject) 方法，设置比较规则
    @Override
    public int compareTo(Value anotherValue) {
        return (this.getNum() - anotherValue.getNum());
    }
    // getter 和 setter 方法
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNum() {
        return this.num;
    }
    public void setName(int num) {
        this.num = num;
    }
}