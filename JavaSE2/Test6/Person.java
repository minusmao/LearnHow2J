/**
 * 文件名：Person.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程 -> 交互
 * 时间：2021-4-18
 */

public class Person {
    /* 对象属性 */
    public String name;
    public int hp;

    /* 构造方法 */
    public Person(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    /* 对象方法 */
    // 受伤
    public synchronized void hurt() {
        if (this.hp <= 1) {
            try {
                // 让占有this的减血线程，暂时释放对this的占有，并等待
                System.out.println("执行 wait() 前");
                this.wait();    // 会在这里一直等待被唤醒
                System.out.println("执行 wait() 后");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
 
        this.hp = this.hp - 1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%d%n", name, name, hp);
    }
    // 恢复
    public synchronized void recover() {
        this.hp = this.hp + 1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%d%n", name, name, hp);
        // 通知那些等待在this对象上的线程，可以醒过来了
        if(this.hp > 3) {
            this.notify();
        }
    }
}