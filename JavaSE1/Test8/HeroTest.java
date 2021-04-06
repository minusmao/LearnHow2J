/**
 * 文件名：HeroTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 接口与继承
 * 时间：2021-4-6
 */

import character.*;
import property.*;

public class HeroTest {
    /* 程序入口 */
    public static void main(String[] args) {
        /* 对象转型 */
        // 定义四种对象
        Hero hero;
        ADHero adHero;
        APHero apHero;
        AD_APHero ad_apHero;

        // 向上转型，父类引用指向子类对象，肯定成功
        adHero = new ADHero();
        hero = adHero;

        // 向下转型，子类引用指向父类对象，需强制类型转换，可能成功，可能失败
        //hero = new Hero();
        //adHero = (ADHero)hero;    // 编译成功，运行错误 ------ java.lang.ClassCastException
        hero = new ADHero();
        adHero = (ADHero)hero;    // 成功，在 hero 其实指向 ADHero 时，转型才会成功
        //hero = new APHero();
        //adHero = (ADHero)hero;    // 编译成功，运行错误 ------ java.lang.ClassCastException

        // 关键字 instanceof
        hero = new AD_APHero();
        System.out.println(hero instanceof Hero);         // 是 Hero 的子类对象，则 true
        System.out.println(hero instanceof AD_APHero);    // 是 AD_APHero 对象，则 true
        System.out.println(hero instanceof ADHero);       // 即不是 ADHero 对象，也不是 ADHero 的子类对象，所以 false

        // 类型转换练习
        AP ap;
        apHero = new APHero();
        hero = apHero;
        //ap = hero;          // 错误
        ap = apHero;          // 正确
        ap = (APHero)hero;    // 正确

        /* 重写、多态、隐藏 */
        Item item = new Item();
        item.effect();
        item = new LeftPotion();
        item.effect();
        item = new MagicPotion();
        item.effect();
        // 多态有两种：操作符的多态（加号“+”既有计算的功能，也有连接字符串的功能）、类的多态
        hero = new Hero();
        hero.useItem(new LeftPotion());
        hero.useItem(new MagicPotion());
        hero.kill(new AD_APHero());
        hero.kill(new ADHero());
        // 重写 ------ 子类覆盖父类的对象方法
        // 隐藏 ------ 子类覆盖父类的类方法，没有多态现象
        hero.win();
        hero = new ADHero();
        hero.win();    // Hero 虽然指向了子类，但是调用类方法时，并不会调用子类的类方法
        adHero = (ADHero)hero;
        adHero.win();

        /* super */
        // 用法1：在子类构造方法中，通过 super(...) 调用父类的构造方法，不写也会默认在第一行插入 super()
        // 用法2：在子类中，通过 super.属性 和 super.方法 调用父类被覆盖的方法

        /* Object 类：所有类的父类 */
        // toString() 方法：返回当前对象的字符串表达
        System.out.println(hero.toString());
        // finalize() 方法：一个对象被垃圾回收的时候，它的finalize() 方法就会被调用（Java11 提示 API 过时）
        // equals() 方法：用于判断两个对象的内容是否相同，String 默认重写过，可以比较两个字符串是否相同，而不是比较地址
        System.out.println("Hello".equals("Hello"));
        // hashCode() 方法：返回一个对象的哈希值
        System.out.printf("%#x\n", hero.hashCode());
        // Object还提供线程同步相关方法 wait()、notify()、notifyAll()
        // getClass() 类方法：会返回一个对象的类对象

        /* final */
        // 修饰的类：不能被继承
        // 修饰的方法：不能被重写
        // 修饰的变量：基本类型只能有一子赋值的机会，引用类型只能有一次指向对象的机会，但只其指向的对象属性可以变化

        /* 抽象类 */
        // 有抽象方法，必须是抽象类，且抽象类不能被实例化
        // 与接口最大的区别就是：接口中声明的属性只能是 public 静态 final 的，即便没有显式的声明

        /* 内部类 */
        hero = new Hero();
        Hero.BattleScore battleScore = hero.new BattleScore();    // 实例化非静态内部类，必须要有一个外部类的实例
        Hero.EnemyCrystal enemyCrystal = new Hero.EnemyCrystal();    // 实例化静态内部类，不需要外部实例
        enemyCrystal.checkIfVictory();
        // 匿名类：直接在 new 的时候实现抽象方法
        // 本地类：可理解为有名字的匿名类，在运行的代码中进行类的定义
        // 匿名类使用的外部类属性必须由 final 修饰，Java8 之后编译器会偷偷的帮你加上（暂不做深入研究，其他资料更详细）

        /* 默认方法 */
        // 默认方法是JDK8新特性，指的是接口也可以提供具体方法了，而不像以前，只能提供抽象方法
        // 用 default 修饰
    }
}