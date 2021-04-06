/**
 * 文件名：APHero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 接口与继承
 * 时间：2021-4-6
 */

package character;

public class APHero extends Hero implements AP, Mortal {
    // 实现接口的法术攻击方法
    @Override
    public void magicAttack() {
        System.out.println("进行了法术攻击");
    }
    @Override
    public void die() {
        System.out.println("AP 坐着 die");
    }
}