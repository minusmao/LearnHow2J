/**
 * 文件名：ObjectStreamTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> IO流 -> 对象流
 * 时间：2021-4-11
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

// 一个对象以流的形式进行传输，叫做序列化
public class ObjectStreamTest {
    /* 程序入口 */
    public static void main(String[] args) {
        // 文件对象
        File object = new File("./Object");

        // 数据对象
        Hero hero1 = new Hero();
        hero1.name = "二傻子";
        hero1.hp = 250F;
        Hero hero2;

        // 写入
        try(ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(object))) {
            objectOut.writeObject(hero1);
        } catch(Exception e) {
            e.printStackTrace();
        }

        // 读取
        try(ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(object))) {
            hero2 = (Hero)objectIn.readObject();
            System.out.println(hero2.name + "; " + hero2.hp);
        } catch(Exception e) {
            e.printStackTrace();
        }

        // 写入对象数组
        Hero[] heros = new Hero[] {hero1, hero1, hero1, hero1};
        Hero[] hs;
        // 写入
        try(ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(object))) {
            objectOut.writeObject(heros);
        } catch(Exception e) {
            e.printStackTrace();
        }

        // 读取
        try(ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(object))) {
            hs = (Hero[])objectIn.readObject();
            for(Hero h : hs) {
                System.out.println(h.name + "; " + h.hp);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}