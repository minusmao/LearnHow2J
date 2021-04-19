/**
 * 文件名：KillThread.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程
 * 时间：2021-4-17
 */

public class KillThread extends Thread {
    /* 对象属性 */
    private Hero h1;
    private Hero h2;

    /* 构造方法 */
    public KillThread(Hero h1, Hero h2) {
        this.h1 = h1;
        this.h2 = h2;
    }

    /* 对象方法 */
    // 重写 run() 方法
    @Override
    public void run() {
        while(h2.isAlive()) {
            h1.attackHero(h2);
        }
        System.out.println(h2.getName() + "阵亡");
    }
}