/**
 * 文件名：Hero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程
 * 时间：2021-4-17
 */

public class Hero {
    /* 对象属性 */
    private String name;
    private int hp;
    private int damage;

    /* 构造方法 */
    public Hero(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    /* 对象方法 */
    // 攻击
    public void attackHero(Hero hero) {
        try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        // 扣血
        hero.setHp(hero.getHp() - this.damage);
        System.out.println(this.name + "攻击了" + hero.getName() + "，" + hero.getName() + "还剩" + hero.getHp() + "滴血");
    }
    // 判断是否活着
    public boolean isAlive() {
        return this.hp > 0 ? true : false;
    }
    // 受伤，加同步功能
    public void hurt() {
        // 使用自己作为同步对象
        synchronized(this) {
            this.hp--;
        }
    }
    // 回血，直接在方法前加 synchronized 修饰符，等同于 hurt() 方法的同步功能
    public synchronized void recover() {
        this.hp++;
    }
    // getter 和 setter
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return this.hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
}