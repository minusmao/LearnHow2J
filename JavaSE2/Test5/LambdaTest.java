/**
 * 文件名：LambdaTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> Lambda
 * 时间：2021-4-17
 */

import java.util.Random;

public class LambdaTest {
    /* 类方法 */
    // 根据 HeroChecker 接口的规则输出
    public static void filter(Hero[] heros, HeroChecker heroChecker) {
        // 循环检查
        for(int i = 0; i < heros.length; i++) {
            if(heroChecker.check(heros[i])) {
                System.out.println("[" + heros[i].getName() + ":" + heros[i].getHp() + "]");
            }
        }
    }
    // 有规则的静态方法，与 HeroChecker 接口的 check() 方法形参和返回值一样，用于 Lambda 引用
    public static boolean testHero(Hero hero) {
        return hero.getHp() < 500;
    }
    /* 程序入口 */
    public static void main(String[] args) {
        /* 匿名类方式实现接口 */
        Random rand = new Random();    // 创建随机数对象
        // 创建 5 个 Hero 对象
        Hero[] heros = new Hero[5];
        for(int i = 0; i < heros.length; i++) {
            heros[i] = new Hero("hero"+i, rand.nextInt(1000));
            System.out.println("[" + heros[i].getName() + ":" + heros[i].getHp() + "]");
        }
        // 匿名类
        HeroChecker heroChecker = new HeroChecker() {
            @Override
            public boolean check(Hero h) {
                return (h.getHp() > 500);
            }
        };
        System.out.println("匿名类方式， Hp 大于 500 的 Hero：");
        filter(heros, heroChecker);

        /* Lambda 方式实现接口 */
        // 版本支持，Lambda 表达式在 JDK8 版本中才开始支持
        System.out.println("Lambda 方式，Hp 小于 500 的 Hero：");
        filter(heros, h -> h.getHp() < 500);

        /* Lambda 引用静态方法的方式 */
        System.out.println("Lambda 引用静态方法的方式 1，Hp 小于 500 的 Hero：");
        filter(heros, h -> LambdaTest.testHero(h));
        System.out.println("Lambda 引用静态方法的方式 2，Hp 小于 500 的 Hero：");
        filter(heros, LambdaTest::testHero);

        /* Lambda 引用对象方法的方式 */
        // 与引用静态方法很类似，只是传递时候，需要一个对象（对象名::方法名）

        /* 引用容器中的对象的方法 */
        // 暂不展开

        /* 引用构造器 */
        // （类名::new）
    }
}