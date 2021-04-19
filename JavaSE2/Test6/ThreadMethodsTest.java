/**
 * 文件名：ThreadMethodsTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程 -> 常见线程方法
 * 时间：2021-4-18
 */

public class ThreadMethodsTest {
    /* 程序入口 */
    public static void main(String[] args) {
        /* 常见线程方法 */
        // 1、当前线程暂停：Thread.sleep(1000)，有可能会抛出InterruptedException 中断异常
        System.out.println("------ 当前线程暂停 1 秒 ------");
        try {
            Thread.sleep(1000);    // 1000ms
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("暂停结束");

        // 2、加入到当前线程中：join()，有可能会抛出InterruptedException 中断异常
        Hero hero1 = new Hero("Hero1", 1000, 100);
        Hero hero2 = new Hero("Hero2", 500, 200);
        // 启动一个线程
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while(hero2.isAlive()) {
                    hero1.attackHero(hero2);
                }
            }
        };
        t1.start();
        // 将该线程加入到主线程中
        System.out.println("------ 加入到当前线程 ------");
        try {
            t1.join();    // join(1000)，可以设置最大等待时间
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        // 加入的线程结束，当前线程的后面才会被执行
        System.out.println("加入的线程结束，当前线程的后面才会被执行");

        // 3、线程优先级：setPriority(Thread.MAX_PRIORITY)
        // Java 线程的优先级是一个整数，其取值范围是 1 （Thread.MIN_PRIORITY ） - 10 （Thread.MAX_PRIORITY ）
        // 默认情况下，每一个线程都会分配一个优先级 NORM_PRIORITY（5）
        System.out.println("------ 线程优先级------");
        Thread maxThread = new Thread() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++) {
                    // 4、临时暂停：Thread.yield();
                    if(i == 5) {
                        Thread.yield();    // 使当前线程由执行状态，变成为就绪状态，当前程序看不出效果
                    }
                    System.out.println("MAX_PRIORITY 线程：" + i);
                }
            }
        };
        maxThread.setPriority(Thread.MAX_PRIORITY);
        Thread minThread = new Thread() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++) {
                    System.out.println("MIN_PRIORITY 线程：" + i);
                }
            }
        };
        minThread.setPriority(Thread.MIN_PRIORITY);
        minThread.start();    // 虽然 min 线程先开始
        maxThread.start();    // 但是 max 线程先输出

        // 等待前面线程完成
        try {
            minThread.join();
            maxThread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        // 5、守护线程
        // 守护线程的概念是： 当一个进程里，所有的线程都是守护线程的时候，结束当前进程
        System.out.println("------ 守护线程 ------");
        Thread daemonThread = new Thread() {
            @Override
            public void run() {
                int time = 0;
                while(true) {
                    System.out.format("\r守护线程，执行中，时间：" + time++);
                    try {
                        Thread.sleep(1000);    // 1000ms
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        daemonThread.setDaemon(true);    // 设置为守护进程，当所有非守护进程走完，它自动停止
        daemonThread.start();
        // 主线程等待 10 秒
        try {
            Thread.sleep(10000);    // 1000ms
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}