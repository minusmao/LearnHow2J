/**
 * 文件名：ADHero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 类和对象
 * 时间：2021-4-5
 */

package character;

/**
 * 类名：ADHero
 * 功能：AD英雄
 */
public class ADHero extends Hero {
    /* 对象方法 */

    /* 重写父类的构造方法 */
    public ADHero() {
        super();    // 调用父类的构造方法，不写，也会默认插入在第一行调用，写，只能写在第一行，否则报错
        System.out.println("调用 ADHero 类的无参构造方法");
    }
    public ADHero(String name,float hp){ 
        super(name, hp);
        System.out.println("调用 ADHero 类的有参构造方法");
    }

    /* 方法重载：名字相同，形参不同（包括数量、类型） */
    public void attack() {
        System.out.println(name + " 进行了一次攻击 ，但是不确定打中谁了");
    }
    public void attack(Hero h1) {
        System.out.println(name + "对" + h1.name + "进行了一次攻击 ");
    }
    public void attack(Hero h1, Hero h2) {
        System.out.println(name + "同时对" + h1.name + "和" + h2.name + "进行了攻击 ");
    }

    /* 以上情况也可以使用 ------ 可变数量的形参（可以替代上面的函数，若同时存在，没有上面的函数优先级高） */
    public void attack(Hero... Heros) {
        // 参数被放进了 Heros 数组里
        for(int i = 0; i < Heros.length; i++) {
            System.out.println(this.name + "攻击了" + Heros[i].name);
        }
    }
}