/**
 * 文件名：ADHero.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 类和对象
 * 时间：2021-4-5
 */

import character.*;

public class HeroMain {
    /* 程序入口 */
    public static void main(String[] args) {
        ADHero bh = new ADHero("赏金猎人", (float)1000);
        bh.express = "更改类属性";              // 不推荐使用对象访问类属性
        System.out.println(ADHero.express);    // 使用类访问类属性
        Hero h1 = new Hero();
        h1.name = "盖伦";
        Hero h2 = new Hero();
        h2.name = "提莫";

        bh.attack();
        bh.attack(h1);
        bh.attack(h1, h2);
        bh.attack(h1, h2, h1, h2);
    }
}

/* ======= 形参：基本类型和类类型 ======
基本类型形参：只传递值，在方法内改变不影响外部
类类型形参：传递地址，在方法内改变影响外部
==================================== */