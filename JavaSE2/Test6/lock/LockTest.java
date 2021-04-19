/**
 * 文件名：LockTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程 -> Lock 对象
 * 时间：2021-4-19
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    /* 程序入口 */
    public static void main(String[] args) {
        /* 使用Lock对象实现同步效果 */
        // 1、lock()方法，表示当前线程占用lock对象，一旦占用，其他线程就不能占用了
        // 2、lock却必须调用unlock方法进行手动释放，为了保证释放的执行，往往会把unlock() 放在finally中进行
        Lock lock = new ReentrantLock();
        // 定义两个线程
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程1企图占用 lock 对象");
                try {
                    lock.lock();    // 占用
                    System.out.println("线程1成功占用 lock 对象");
                    Thread.sleep(4000);    // 延时 4 秒
                } catch(InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("线程1开始释放 lock 对象");
                    lock.unlock();    // 释放
                }
            }
        };
        Thread t2 = new Thread() {
            boolean locked = false;    // 定义一个标记是否占用成功的变量
            @Override
            public void run() {
                System.out.println("线程2企图占用 lock 对象（try）");
                try {
                    locked = lock.tryLock(2,TimeUnit.SECONDS);    // 尝试占用，若 2 秒内不成功，则放弃
                    if(locked) {
                        System.out.println("线程2成功占用 lock 对象");
                        Thread.sleep(1000);    // 延时 1 秒
                    } else {
                        System.out.println("线程2占用 lock 对象失败，不再尝试，继续往后执行");
                    }
                } catch(InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if(locked) {
                        System.out.println("线程2开始释放 lock 对象");
                        lock.unlock();    // 释放
                    }
                }
            }
        };
        // 启动两个线程
        t1.start();
        t2.start();
        // 前面线程走完
        try {
            t1.join();
            t2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        /* 线程交互 */
        BlockingQueue<Character> blockQueue = new BlockingQueue<>(5);
        // 定义生产者、消费者线程
        Thread produceThread = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while(i++ < 20) {
                    char c = (char)(i + 'A');
                    blockQueue.put(c);
                    try {
                        Thread.sleep(100);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread consumerThread = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while(i++ < 20) {
                    blockQueue.take();
                    try {
                        Thread.sleep(500);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        // 启动生产者、消费者线程
        produceThread.start();
        consumerThread.start();
    }
}