/**
 * 文件名：AggregateTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> Lambda
 * 时间：2021-4-17
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class AggregateTest {
    /* 程序入口 */
    public static void main(String[] args) {
        /* 聚合操作 */
        List<Hero> heroList = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < 5; i++) {
            heroList.add(new Hero("hero"+i, rand.nextInt(1000)));
        }
        // 传统方式遍历
        System.out.println("------ 传统方式遍历：hp 大于 500 ------");
        for(Hero h : heroList) {
            if(h.getHp() > 500) {
                System.out.println("[" + h.getName() + ":" + h.getHp() + "]");
            }
        }
        // 管道加 Lambda 方式
        System.out.println("------ 管道加 Lambda 方式遍历：hp 大于 500 ------");
        heroList.stream()
                .filter(h -> h.getHp() > 500)
                .forEach(h -> System.out.println("[" + h.getName() + ":" + h.getHp() + "]"));

        /*
        Stream    是一系列的元素，就像是生产线上的罐头一样，一串串的出来。
        管道      指的是一系列的聚合操作。

        管道又分3个部分
            管道源：在这个例子里，源是一个List
            中间操作： 每个中间操作，又会返回一个Stream，比如.filter()又返回一个Stream, 中间操作是“懒”操作，并不会真正进行遍历。
            结束操作：当这个操作执行后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。 
                    结束操作不会返回Stream，但是会返回int、float、String、 Collection或者像forEach，
                    什么都不返回, 结束操作才进行真正的遍历行为，在遍历的时候，才会去进行中间操作的相关判断
        */

        /* 1、管道源 */
        // 集合调用 stream() 方法即可得到管道源
        // 但是数组没有 stream() 方法，所以需要其他工具类：Arrays.stream(数组对象) 或者 Stream.of(数组对象)
        System.out.println("------ 数组作为管道源 ------");
        Hero[] heros = heroList.toArray(new Hero[] {});
        Arrays.stream(heros)
              .filter(h -> h.getHp() > 0)
              .forEach(h -> System.out.println("[" + h.getName() + ":" + h.getHp() + "]"));
        
        /* 2、中间操作 */
        /* 中间操作主要分两类：
                （1）对元素进行筛选：filter 匹配、distinct 去除重复(根据equals判断)、sorted 自然排序、
                                    sorted(Comparator<T>) 指定排序、limit(n) 保留（前 n 个）、skip(n) 忽略（前 n 个）
                （2）转换为其他形式的流：mapToDouble 转换为double的流、map 转换为任意类型的流
        */
        // 中间操作：转换其他形式的流
        System.out.println("------ 转换为其他形式的流1 ------");
        heroList.stream()
                .mapToDouble(Hero::getHp)
                .forEach(h -> System.out.println(h));

        System.out.println("------ 转换为其他形式的流2 ------");
        heroList.stream()
                .map(t -> "[" + t.getName() + ":" + t.getHp() + "]")
                .forEach(h -> System.out.println(h));

        /* 3、结束操作 */
        // 结束操作才真正进行遍历行为，前面的中间操作也在这个时候，才真正的执行
        /* 常见结束操作如下：
                forEach() 遍历每个元素
                toArray() 转换为数组
                min(Comparator<T>) 取最小的元素
                max(Comparator<T>) 取最大的元素
                count() 总数
                findFirst() 第一个元素
        */
        System.out.println("------ hp 大于 500 的英雄个数 ------");
        long count = heroList.stream()
                            .filter(t -> t.getHp() > 500)
                            .count();
        System.out.println("hp 大于 500 的英雄个数：" + count);

        // 测试操作顺序
        System.out.println("------ 操作顺序 ------");    // 观察结果，顺序为先出现的先操作
        heroList.stream()
                .limit(3)
                .skip(2)
                .map(t -> "[" + t.getName() + ":" + t.getHp() + "]")
                .forEach(h -> System.out.println(h));
    }
}