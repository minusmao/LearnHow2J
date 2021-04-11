/**
 * 文件名：Hero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> IO流 -> 对象流
 * 时间：2021-4-11
 */

import java.io.Serializable;

// 序列化对象必须实现 Serializable 接口
public class Hero implements Serializable {
    /* 对象属性 */
    public String name;
    public float hp;
}