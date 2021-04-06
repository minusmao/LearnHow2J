/**
 * 文件名：Hero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 接口与继承
 * 时间：2021-4-6
 */

package character;

import property.*;

/**
 * 类名：Hero
 * 功能：所有英雄的父类
 */
public class Hero {
    /* 对象属性 */
    public String name;      //姓名
    public float hp;         //血量
    public float armor;      //护甲
    public int moveSpeed;    //移动速度

    /* 类方法 */
    public static void win() {
        System.out.println("Hero win");
    }

    /* 对象方法 */
    // 构造方法
    public Hero() {
        System.out.println("Hero的构造方法 ");
    }
    public Hero(String name, float hp, float armor, int moveSpeed) {
        this.name = name;
        this.hp = hp;
        this.armor = armor;
        this.moveSpeed = moveSpeed;
    }

    // 使用物品
    public final void useItem(Item item) {
        item.effect();
    }

    // 击杀
    public void kill(Mortal mortal) {
        mortal.die();
    }

    /* 内部类 */
    // 非静态内部类，只有一个外部类对象存在的时候，才有意义
    // 战斗成绩只有在一个英雄对象存在的时候才有意义
    public class BattleScore {
        int kill;
        int die;
        int assist;
 
        public void legendary() {
            if (kill >= 8)
                System.out.println(name + "超神！");
            else
                System.out.println(name + "尚未超神！");
        }
    }
    // 静态内部类，不需要一个外部类的实例为基础
    // 敌方的水晶
    public static class EnemyCrystal{
        int hp=5000;
         
        //如果水晶的血量为0，则宣布胜利
        public void checkIfVictory(){
            if(hp==0){
                System.out.println("win");
                 
                //静态内部类不能直接访问外部类的对象属性
                //System.out.println(name + " win this game");
            }
        }
    }
}