/**
 * 文件名：Item.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 接口与继承
 * 时间：2021-4-6
 */

package property;

public class Item {
    String name;
    int price;
 
    public void buy(){
        System.out.println("购买");
    }
    public void effect() {
        System.out.println("物品使用后，可以有效果");
    }
}