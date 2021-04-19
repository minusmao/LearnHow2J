/**
 * 文件名：ThreadSyncTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程 -> 同步
 * 时间：2021-4-18
 */

import java.util.Date;
import java.text.SimpleDateFormat;

public class ThreadSyncTest {
    /* 类方法 */
    // 返回当前时间
    public static String now() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    /* 程序入口 */
    public static void main(String[] args) {
        /* synchronized 同步对象概念 */
        final Object someObject = new Object();    // 用作同步对象，任何对象都可以
        // 定义两线程
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(now() + "---" + this.getName() + " 线程开始运行");
                    System.out.println(now() + "---" + this.getName() + " 试图占有对象：someObject");
                    synchronized(someObject) {
                        System.out.println(now() + "---" + this.getName()+ " 成功占有对象：someObject");
                        Thread.sleep(1000);    // 使用 sleep() 进入阻塞状态，但是不会释放同步对象
                        System.out.println(now() + "---" + this.getName()+ " 成功释放对象：someObject");
                    }
                    System.out.println(now() + "---" + this.getName() + " 线程结束运行");
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(now() + "---" + this.getName() + " 线程开始运行");
                    System.out.println(now() + "---" + this.getName() + " 试图占有对象：someObject");
                    synchronized(someObject) {
                        System.out.println(now() + "---" + this.getName()+ " 成功占有对象：someObject");
                        Thread.sleep(1000);    // 使用 sleep() 进入阻塞状态，但是不会释放同步对象
                        System.out.println(now() + "---" + this.getName()+ " 成功释放对象：someObject");
                    }
                    System.out.println(now() + "---" + this.getName() + " 线程结束运行");
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        // 启动两个线程
        t1.start();
        t2.start();
        // 等待两个线程走完
        try {
            t1.join();
            t2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        /* 使用hero对象作为同步对象、在方法前加上修饰符synchronized */
        Hero hero = new Hero("hero", 10000, 100);
        // 创建两个线程
        Thread hurtThread = new Thread() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++) {
                    // hero 对象的 hurt() 已加同步功能，同步对象就是 hero
                    hero.hurt();
                }
            }
        };
        Thread recoverThread = new Thread() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++) {
                    // hero 对象的 recover() 已被 synchronized 修饰，同步对象就是 hero
                    hero.recover();
                }
            }
        };
        hurtThread.start();
        recoverThread.start();
        // 等待两个线程走完
        try {
            hurtThread.join();
            recoverThread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(hero.getHp());

        /* 线程安全的类 */
        // 如果一个类，其方法都是有synchronized修饰的，那么该类就叫做线程安全的类
        // 如果在类方法前加上修饰符 synchronized，同步对象为类对象

        // StringBuffer 线程安全，StringBuilder 线程不安全
        // HashMap 线程不安全，可以存放 null，Hashtable 线程安全
        // ArrayList 线程不安全，Vector 线程安全

        /* 线程死锁 */
        // 当业务比较复杂，多线程应用里有可能会发生死锁
        /*
            1. 线程1 首先占有对象1，接着试图占有对象2
            2. 线程2 首先占有对象2，接着试图占有对象1
            3. 线程1 等待线程2释放对象2
            4. 与此同时，线程2等待线程1释放对象1
        */
    }
}