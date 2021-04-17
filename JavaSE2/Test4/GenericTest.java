/**
 * 文件名：GenericTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 泛型
 * 时间：2021-4-14
 */

import java.util.List;
import java.util.ArrayList;

public class GenericTest {
    /* 类方法 */
    // 使用泛型通配符作为形参
    public static void test(ArrayList<? extends Number> list) {
        for(Number num : list) {
            System.out.println(num);
        }
    }
    /* 程序入口 */
    public static void main(String[] args) {
        /* 集合中的泛型 */
        List<Number> list = new ArrayList<>();
        // 可以添加 Number 和 Number 的子类
        list.add(1);
        list.add(1.1F);
        // 不可以添加 String 类
        //list.add("Str");
        int i = (Integer)list.get(0);    // 取出时，强制类型转换为 Integer
        float f = (float)list.get(1);    // 取出时，强制类型转换为 float

        /* 支持泛型的类 */
        // 定义数据对象 Value 数组
        Value[] values = new Value[5];
        values[0] = new Value("value0", 2);
        values[1] = new Value("value1", 4);
        values[2] = new Value("value2", 1);
        values[3] = new Value("value3", 0);
        values[4] = new Value("value4", 5);
        // 添加到二叉树中
        BinaryTree<Value> bt = new BinaryTree<>();
        for(int n = 0; n < values.length; n++) {
            bt.add(values[n]);
        }
        // 得到左序遍历的 ArrayList
        ArrayList<Value> valueList = bt.getLeftArrayList();
        // 输出遍历结果
        for(Value v : valueList) {
            System.out.println("[" + v.getName() + ":" + v.getNum() + "]");
        }
        System.out.println(bt.getSize());

        /* 泛型通配符 */
        // ArrayList<? extends Hero>：指泛型可以是 Hero 和其子类，取出来必能转化为 Hero，但不能存入
        // ArrayList<? super Hero>：指泛型可以是 Hero 和其父类，能存，能取

        // 方法中形参用通配符：test(ArrayList<? extends Number> list)，因为泛型之间父类和子类无法转型，所以使用通配符
        ArrayList<Integer> listInt = new ArrayList<>();
        listInt.add(10);
        listInt.add(20);
        listInt.add(30);
        ArrayList<Float> listFloat = new ArrayList<>();
        listFloat.add(0.1F);
        listFloat.add(0.2F);
        listFloat.add(0.3F);
        test(listInt);
        test(listFloat);

        /* 泛型转型 */
        // 因为 ArrayList<Hero> 可以存入 Hero 和其子类（ApHero、AdHero），所以 ArrayList<ApHero> 和 ArrayList<Hero> 不能互相转换
        // 所以这个时候有了泛型通配符
    }
}