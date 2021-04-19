/**
 * 文件名：AtomicTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程 -> 原子访问
 * 时间：2021-4-19
 */

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    /* 类属性 */
    private static int value = 0;
    private static AtomicInteger atomicValue =new AtomicInteger();

    /* 程序入口 */
    public static void main(String[] args) {
        int number = 100000;
        Thread[] ts1 = new Thread[number];
        for (int i = 0; i < number; i++) {
            Thread t =new Thread(){
                public void run(){
                    value++;
                }
            };
            t.start();
            ts1[i] = t;
        }
         
        //等待这些线程全部结束
        for (Thread t : ts1) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
         
        System.out.printf("%d个线程进行value++后，value的值变成:%d%n", number,value);
        Thread[] ts2 = new Thread[number];
        for (int i = 0; i < number; i++) {
            Thread t =new Thread(){
                public void run(){
                    atomicValue.incrementAndGet();
                }
            };
            t.start();
            ts2[i] = t;
        }
         
        //等待这些线程全部结束
        for (Thread t : ts2) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.printf("%d个线程进行atomicValue.incrementAndGet();后，atomicValue的值变成:%d%n", number,atomicValue.intValue());
    }
}