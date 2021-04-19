/**
 * 文件名：BlockingQueue.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程 -> Lock对象 -> 生产者消费者
 * 时间：2021-4-19
 */

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

// 线程安全的栈
public class BlockingQueue<T> {
    /* 对象属性 */
    private LinkedList<T> stack;
    private int limit;                                    // 最大容量
    private Lock lock = new ReentrantLock();              // Lock 对象
    private Condition condition = lock.newCondition();    // 用于线程交互 await、signal、signalAll

    /* 构造方法 */
    public BlockingQueue(int limit) {
        this.limit = limit;    // 设置最大容量
        stack = new LinkedList<>();
    }

    /* 对象方法 */
    public void put(T t) {
        try {
            lock.lock();    // 企图占用 lock 对象
            while(stack.size() >= limit) {
                condition.await();    // 等待
            }
            stack.addFirst(t);
            System.out.println("压入:" + t);
            System.out.println("当前栈中字符的个数：" + stack.size());
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            condition.signalAll();    // 唤醒其他线程
            lock.unlock();            // 释放
        }
    }
    public T take() {
        try {
            lock.lock();    // 企图占用 lock 对象
            while(stack.size() <= 0) {
                condition.await();    // 等待
            }
            T t=stack.removeFirst();
            System.out.println("取出:" + t);
            System.out.println("当前栈中字符的个数：" + stack.size());
            return t;
        } catch(InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            condition.signalAll();    // 唤醒其他线程
            lock.unlock();            // 释放
        }
    }
}