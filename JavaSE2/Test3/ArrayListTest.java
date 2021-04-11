/**
 * 文件名：ArrayListTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 集合框架
 * 时间：2021-4-11
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
    /* 程序入口 */
    public static void main(String[] args) {
        /* ArrayList常用方法 */
        // JDK7 之前，List<Hero> heros = new ArrayList<Hero>()
        // JDK7 之后，可以省略后面部分，List<Hero> heros = new ArrayList<>()
        List<Hero> heros = new ArrayList<>();    // 定义 ArrayList

        // add() 增加
        for(int i = 0; i < 5; i++) {
            heros.add(new Hero("hero" + i));
        }
        System.out.println(heros);    // 打印内容：[元素1.toString(), 元素2.toString, ...]

        // add() 在指定位置增加对象
        Hero specialHero = new Hero("special hero");
        heros.add(3, specialHero);
        System.out.println(heros);

        // contains() 判断一个对象是否在容器中
        // 判断标准：是否是同一个对象，而不是name是否相同
        System.out.println(heros.contains(new Hero("special hero")));    // 返回 false
        System.out.println(heros.contains(specialHero));                 // 返回 true

        // get() 获取指定位置的对象，输入的下标越界，一样会报错
        Hero h = heros.get(3);
        System.out.println(h);

        // indexOf() 获取对象所处的位置，判断标准与 contains() 一样
        System.out.println(heros.indexOf(h));
        System.out.println(heros.indexOf(new Hero("special hero")));    // 找不到，返回 -1

        // remove() 删除，可以根据下标，也可以根据对象
        System.out.println(heros);
        heros.remove(1);
        heros.remove(specialHero);
        System.out.println(heros);

        // set() 替换
        heros.set(0, new Hero("HeroSet"));
        System.out.println(heros);

        // size() 获取大小
        System.out.println("当前大小：" + heros.size());

        // toArray() 转换为数组
        Hero[] heroArr = heros.toArray(new Hero[] {});    // 若不传入值，则返回 Object[] 数组
        for(Hero buf : heroArr) {
            System.out.println(buf.toString());
        }

        // addAll() 把另一个容器所有对象都加进来
        heros.addAll(heros);
        System.out.println(heros);

        // clear() 清空
        heros.clear();
        System.out.println(heros);

        // isEmpty() 判断是否为空
        System.out.println(heros.isEmpty());

        /* 集合遍历 */
        /*
            法 1：常规for ----> for(int i = 0; i < Heros.size(); i++) {... Heros.get(i) ...}
            法 2：增强for ----> for(Hero h : Heros) ...
            法 3：iterator 迭代器
        */
        // 使用法 3：iterator 迭代器
        for(int i = 0; i < 5; i++) {
            heros.add(new Hero("hero" + i));
        }
        System.out.println(heros);
        Iterator<Hero> it= heros.iterator();    // 得到迭代器 Iterator
        while(it.hasNext()) {
            Hero hhh = it.next();
            System.out.println(hhh);
        }
    }
}