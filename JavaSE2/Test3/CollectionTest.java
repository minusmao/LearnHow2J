/**
 * 文件名：CollectionTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 集合框架
 * 时间：2021-4-11
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionTest {
    /* 程序入口 */
    // 集合分 Collection 和 Map 两大类
    public static void main(String[] args) {
        /* HashMap，存储键值对（key=value） */
        HashMap<String, String> dictionary = new HashMap<>();
        // put() 放入
        dictionary.put("adc", "hero1");
        dictionary.put("apc", "hero2");
        dictionary.put("t", "hero3");
        System.out.println(dictionary);
        dictionary.put("apc", "hero4");    // 键不能重复，值可以重复，否则会覆盖原来的内容
        System.out.println(dictionary);
        // get() 查看
        System.out.println(dictionary.get("apc"));
        // remove() 删除
        System.out.println("删除：" + dictionary.remove("apc"));
        System.out.println(dictionary);
        // clear() 清空
        dictionary.clear();
        System.out.println(dictionary);

        /* HashSet，内部由 HashMap 实现，可以看成是没有 value 的 HashMap */
        // Set 接口不提供 get() 来获取指定位置的元素，所以遍历需要用到迭代器，或者增强型for循环
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("hello");
        hashSet.add("world");
        hashSet.add("字符串");
        hashSet.add("字符串");    // 返回 false
        System.out.println(hashSet);
        // 增强型 for
        for(String str : hashSet) {
            System.out.println(str);
        }
        // 迭代器
        Iterator<String> iterator = hashSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
/*
    HashSet 和 HashMap 重复的判断标准：
        1、先判断 hashcode
        2、若 hashcode 相同，则判断 equals，若 equals 也相容，则相同
*/