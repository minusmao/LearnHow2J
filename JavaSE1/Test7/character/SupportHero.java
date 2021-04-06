/**
 * 文件名：SupportHero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 类和对象
 * 时间：2021-4-5
 */

package character;

/**
 * 类名：SupportHero
 * 功能：辅助英雄
 */
public class SupportHero extends Hero {
    /* 对象方法 */

    // 构造方法：与类名相同，没有返回值
    public SupportHero() {
        System.out.println("调用 SupportHero 类的无参构造方法，构造一个 SupportHero 对象");
    }

    /* 方法重载：名字相同，形参不同（包括数量、类型） */
    public void heal() {
        System.out.println(name + " 进行了一次治疗 ，但是不确定治疗谁了");
    }
    public void heal(Hero h1) {
        System.out.println(name + "对" + h1.name + "进行了一次治疗 ");
    }
    public void heal(Hero h1, Hero h2) {
        System.out.println(name + "同时对" + h1.name + "和" + h2.name + "进行了治疗 ");
    }
}