/**
 * 文件名：LeftPotion.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 接口与继承
 * 时间：2021-4-6
 */

package property;
 
public class LeftPotion extends Item {
    // 重写了父类的方法
    @Override
    public void effect(){
        System.out.println("血瓶使用后，可以回血");
    }
}