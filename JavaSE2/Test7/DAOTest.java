/**
 * 文件名：DAOTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> JDBC -> ORM 和 DAO
 * 时间：2021-4-28
 */

import java.util.List;

public class DAOTest {
    /* 程序入口 */
    public static void main(String[] args) {
        DAOHero daoHero = new DAOHero();
        Hero hero = new Hero("ORMHero", 233.3F, 140);

        // 向数据库的 hero 表中添加数据
        daoHero.add(hero);
        System.out.println("[" + hero.getId() + ", " + hero.getName() + ", " + hero.getHp() + ", " + hero.getDamage() + "]");

        // 删除 hero 表中 id 为 9 的数据
        daoHero.delete(9);

        // 更新数据
        hero.setId(30);
        hero.setName("UpdateHero");
        daoHero.update(hero);

        // 查询指定 id 的数据
        hero = daoHero.get(1);
        if(hero != null) {
            System.out.println("[" + hero.getId() + ", " + hero.getName() + ", " + hero.getHp() + ", " + hero.getDamage() + "]");
        }

        // 查询数据总数
        System.out.println("数据总数为：" + daoHero.getTotal());

        // 分页查询
        List<Hero> list = daoHero.getList(0, 5);
        for(Hero h : list) {
            System.out.println("[" + h.getId() + ", " + h.getName() + ", " + h.getHp() + ", " + h.getDamage() + "]");
        }
    }
}