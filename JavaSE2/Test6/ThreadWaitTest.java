/**
 * 文件名：ThreadWaitTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程 -> 交互
 * 时间：2021-4-18
 */

public class ThreadWaitTest {
    /* 程序入口 */
    public static void main(String[] args) {
        /* 使用wait和notify进行线程交互 */
        Person person = new Person("person", 10);
        // 定义两线程
        Thread hurtThread = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while(i++ < 20) {
                    person.hurt();
                     
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        Thread recoverThread = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while(i++ < 20) {
                    person.recover();
   
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        // 启动两个线程
        hurtThread.start();
        recoverThread.start();
    }
}