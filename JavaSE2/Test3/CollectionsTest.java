/**
 * 文件名：CollectionsTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 集合框架
 * 时间：2021-4-11
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsTest {
    /* 程序入口 */
    public static void main(String[] args) {
        // 定义 LinkedList 集合
        LinkedList<Integer> link = new LinkedList<>();
        // 填入内容
        for(int i = 0; i < 10; i++) {
            link.add(i);
        }
        System.out.println(link);

        /* java.util.Collections 集合工具类 */
        // reverse() 反转
        Collections.reverse(link);
        System.out.println(link);
        // shuffle() 混淆
        Collections.shuffle(link);
        System.out.println(link);
        // sort() 排序
        Collections.sort(link);
        System.out.println(link);
        // swap() 交换
        Collections.swap(link, 0, 5);
        System.out.println(link);
        // rotate() 滚动（向右）
        Collections.rotate(link, 2);
        System.out.println(link);
        // synchronizedList() 线程安全化
        List<Integer> syncLink = (List<Integer>)Collections.synchronizedList(link);   // 只能用List，而不能用 LinkedList

        /* java.util.Comparator 比较器 */
        LinkedList<Hero> heroList = new LinkedList<>();
        heroList.addLast(new Hero("hero1", 250, 100));
        heroList.addLast(new Hero("hero2", 240, 100));
        heroList.addLast(new Hero("hero3", 250, 90));
        heroList.addLast(new Hero("hero4", 240, 300));
        // 定义比较器 Comparator，重写 int compare(Hero h1, Hero h2) 方法
        // 也可以让 Hero 实现 Comparator 接口，重写 int compareTo(Hero anotherHero) 方法
        Comparator<Hero> myCom = new Comparator<>() {
            @Override
            public int compare(Hero h1, Hero h2) {
                if(h1.hp > h2.hp) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };
        Collections.sort(heroList, myCom);
        System.out.println(heroList);

        /* JDK8 引入了聚合操作 */
        String name =heroList
            .stream()
            .sorted((h1,h2)->h1.hp>h2.hp?-1:1)
            .skip(2)
            .map(h->h.getName())
            .findFirst()
            .get();
 
        System.out.println("通过聚合操作找出来的hp第三高的英雄名称是:" + name);
    }
}