/**
 * 文件名：ADHero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 接口与继承
 * 时间：2021-4-6
 */

package character;

public class ADHero extends Hero implements AD, Mortal {
    // 隐藏父类的类方法
    public static void win() {
        System.out.println("ADHero win");
    }

    // 实现接口的物理攻击方法
    @Override
    public void physicAttack() {
        System.out.println("进行了物理攻击");
    }
    @Override
    public void die() {
        System.out.println("AD 站着 die");
    }
}