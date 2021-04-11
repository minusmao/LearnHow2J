/**
 * 文件名：LinkListTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 集合框架
 * 时间：2021-4-11
 */

import java.util.LinkedList;

public class LinkedListTest {
    /* 程序入口 */
    public static void main(String[] args) {
        LinkedList<Hero> heroList = new LinkedList<>();
        // LinkList 也实现了 List 接口，与 ArrayList 类似
        // 除此之外，还实现了双向链表结构 Deque 接口、实现了队列结构 Queue 接口

        /* 双向链表结构 Deque 接口的方法 */
        // addLast() 最后插入
        heroList.addLast(new Hero("last1"));
        heroList.addLast(new Hero("last2"));
        heroList.addLast(new Hero("last3"));
        System.out.println(heroList);
        // addFirst() 最前面插入
        heroList.addFirst(new Hero("first1"));
        heroList.addFirst(new Hero("first2"));
        heroList.addFirst(new Hero("first3"));
        System.out.println(heroList);
        // getXxx() 查看，不删除
        System.out.println(heroList.getFirst());    // 查看最前面
        System.out.println(heroList.getLast());     // 查看最后面
        System.out.println(heroList);
        // removeXxx() 取出，会删除
        System.out.println(heroList.removeFirst());    // 取出最前面
        System.out.println(heroList.removeLast());     // 取出最后面
        System.out.println(heroList);

        // 清空
        heroList.clear();

        /* 队列结构 Queue 接口的方法 */
        // offer() 加在队列的最后面
        heroList.offer(new Hero("queue1"));
        heroList.offer(new Hero("queue2"));
        heroList.offer(new Hero("queue3"));
        heroList.offer(new Hero("queue4"));
        System.out.println(heroList);
        // peek() 查看第一个，不删除
        System.out.println(heroList.peek());
        System.out.println(heroList);
        // poll() 取出第一个，会删除
        System.out.println(heroList.poll());
        System.out.println(heroList.poll());
        System.out.println(heroList);
    }
}