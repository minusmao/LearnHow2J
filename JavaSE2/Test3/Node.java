/**
 * 文件名：Node.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 集合框架
 * 时间：2021-4-11
 */

public class Node {
    /* 对象属性 */
    private Node leftNode;     // 左节点
    private Node rightNode;    // 右节点
    private Hero hero;         // 节点数据内容

    /* 对象方法 */
    public void setHero(Hero hero) {
        this.hero = hero;
    }
    public void addNode(Hero hero) {
        if(this.hero.hp > hero.hp) {
            if(this.leftNode == null) {
                this.leftNode = new Node();
                this.leftNode.setHero(hero);
            } else {
                this.leftNode.addNode(hero);
            }
        } else {
            if(this.rightNode == null) {
                this.rightNode = new Node();
                this.rightNode.setHero(hero);
            } else {
                this.rightNode.addNode(hero);
            }
        }
    }
    public void show() {
        if(this.leftNode != null) {
            this.leftNode.show();
        }
        System.out.println(this.hero.name + "; " + this.hero.hp);
        if(this.rightNode != null) {
            this.rightNode.show();
        }
    }
}