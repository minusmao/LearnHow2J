/**
 * 文件名：ThreadTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程
 * 时间：2021-4-17
 */

public class ThreadTest {
    /* 程序入口 */
    public static void main(String[] args) {
        /* 启动线程 */
        Hero hero1 = new Hero("hero1", 1000, 100);
        Hero hero2 = new Hero("hero2", 1000, 100);
        Hero hero3 = new Hero("hero3", 1000, 100);
        // KillThread 继承了 Thread 类，并实现了 run() 方法
        // 也可以实现 Runnable 接口，效果一样
        KillThread kill1 = new KillThread(hero1, hero2);
        KillThread kill2 = new KillThread(hero1, hero3);
        // 启动两个线程
        kill1.start();
        kill2.start();
        // 通过匿名类启动线程，可以调用外部的变量，外部变量会默认被 final 修饰
        Hero hero4 = new Hero("hero4", 1000, 100);
        Hero hero5 = new Hero("hero5", 1000, 100);
        new Thread(){
            @Override
            public void run() {
                 while(hero5.isAlive()) {
                    hero4.attackHero(hero5);
                }
                System.out.println(hero5.getName() + "阵亡");
            }
        }.start();
    }
}