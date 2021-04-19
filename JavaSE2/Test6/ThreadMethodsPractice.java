/**
 * 文件名：ThreadMethodsPractice.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程 -> 常见线程方法 -> 练习
 * 时间：2021-4-18
 */

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ThreadMethodsPractice {
    /* 类属性 */
    public static volatile boolean flag = false;    // 定义一个共享变量来实现通信，它需要是volatile修饰，否则线程不能及时感知
    /* 程序入口 */
    public static void main(String[] args) {
        /* 练习-破解密码 */
        Random rand = new Random();
        int password = rand.nextInt(1000);
        System.out.println("password = " + password);

        List<Integer> syncList = Collections.synchronizedList​(new ArrayList<Integer>(1000));    // 创建一个线程同步的 ArrayList

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for(int i = 0; i < 500; i++) {
                    // isInterrupted() 判断此线程是否已被中断，中断状态不受此方法的影响
                    // Thread.interrupted() 判断当前线程是否已被中断，此方法清除线程的中断状态
                    if(this.isInterrupted()) {
                        break;
                    }
                    syncList.add(i);
                    if(i == password) {
                        System.out.println(this.getName() + "第" + i + "次找到了");
                        flag = true;
                        break;
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for(int i = 500; i < 1000; i++) {
                    if(this.isInterrupted()) {
                        break;
                    }
                    syncList.add(i);
                    if(i == password) {
                        System.out.println(this.getName() + "第" + (i-500) + "次找到了");
                        flag = true;
                        break;
                    }
                }
            }
        };
        t1.start();
        t2.start();

        // 等待 flag
        while(!flag);

        // 判断并结束进程
        if(t1.isAlive()) {
            t1.interrupt();    // 中断，stop 方法已过时，不安全
        }
        if(t2.isAlive()) {
            t2.interrupt();
        }

        System.out.println(syncList.size());
    }
}