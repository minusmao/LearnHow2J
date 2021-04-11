/**
 * 文件名：NodeTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 集合框架
 * 时间：2021-4-11
 */

import java.lang.Math;

public class NodeTest {
    /* 程序入口 */
    public static void main(String[] args) {
        // 创建 Hero 数组，hp填充随机数
        Hero[] heroArr = new Hero[5];
        for(int i = 0; i < heroArr.length; i++) {
            heroArr[i] = new Hero("hero" + i, (float)(Math.random() * 100));
        }
        // 存入二叉树，按 hp 左小右大规律
        Node node = new Node();
        node.setHero(heroArr[0]);    // 存入第一个
        // 存入其余四个
        for(int i = 1; i < heroArr.length; i++) {
            node.addNode(heroArr[i]);
        }
        node.show();
    }
}