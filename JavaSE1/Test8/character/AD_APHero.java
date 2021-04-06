/**
 * 文件名：AD_APHero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 接口与继承
 * 时间：2021-4-6
 */

package character;

public class AD_APHero extends Hero implements AD, AP, Mortal {
    // 实现接口的物理攻击方法
    @Override
    public void physicAttack() {
        System.out.println(this.name + "进行了物理攻击");
    }
    // 实现接口的法术攻击方法
    @Override
    public void magicAttack() {
        System.out.println(this.name + "进行了法术攻击");
    }
    @Override
    public void die() {
        System.out.println("AD_AP 飘着 die");
    }
}