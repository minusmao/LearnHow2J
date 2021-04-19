/**
 * 文件名：BlockingQueue.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程 -> 交互 -> 生产者消费者
 * 时间：2021-4-18
 */

import java.util.LinkedList;

// 线程安全的栈
public class BlockingQueue<T> {
    /* 对象属性 */
    private LinkedList<T> stack;
    private int limit;    // 最大容量

    /* 构造方法 */
    public BlockingQueue(int limit) {
        this.limit = limit;
        stack = new LinkedList<>();
    }

    /* 对象方法 */
    public synchronized void put(T t) throws InterruptedException {
        while(stack.size() >= limit) {
            wait();
        }
        stack.addFirst(t);
        System.out.println("压入:" + t);
        System.out.println("当前栈中字符的个数：" + stack.size());
        notifyAll();
    }
    public synchronized T take() throws InterruptedException {
        while(stack.size() <= 0) {
            wait();
        }
        T t=stack.removeFirst();
        System.out.println("取出:" + t);
        System.out.println("当前栈中字符的个数：" + stack.size());
        notifyAll();
        return t;
    }
}