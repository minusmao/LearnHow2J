/**
 * 文件名：Support.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 接口与继承
 * 时间：2021-4-6
 */

public class Support extends Hero implements Healer, Mortal {
    // 实现接口的治疗方法
    @Override
    public void heal() {
        System.out.println(this.name + "进行了治疗");
    }
    Override
    public void die() {
        System.out.println("辅助躺着 die");
    }
}