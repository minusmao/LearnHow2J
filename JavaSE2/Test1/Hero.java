/**
 * 文件名：Hero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 异常处理 -> 自定义异常
 * 时间：2021-4-10
 */

public class Hero {
    /* 对象属性 */
    public String name = "Java-er";
    public int hp = 0;

    /* 自定义异常，这里用内部类实现的 */
    // 1.继承 java.lang.Exception 类
    public class EnemyHeroIsDeadException extends Exception {
        // 1.重写无参构造方法
        public EnemyHeroIsDeadException() {
            // 内容
        }
        // 2.重写有参构造方法
        public EnemyHeroIsDeadException(String msg) {
            super(msg);
        }
    }

    /* 对象方法 */
    public void attackHero(Hero h) throws EnemyHeroIsDeadException {
        if(h.hp == 0) {
            throw this.new EnemyHeroIsDeadException(h.name + "已经挂了,不需要施放技能");
        }
    }

    /* 程序入口 */
    public static void main(String[] args) {
        Hero hero1 = new Hero();
        Hero hero2 = new Hero();
        try {
            hero1.attackHero(hero2);
        } catch(Exception e) {
            System.out.println("异常内容：" + e.getMessage());    // 通过 getMessage() 获得写进去的 msg 内容
            e.printStackTrace();
        }
    }
}