/**
 * 文件名：ReflectionTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 反射机制
 * 时间：2021-5-4
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReflectionTest {
    /* 程序入口 */
    public static void main(String[] args) {
        /* 获取类对象 */
        // 方法一：Class.forName(String className)
        // 方法二：类.class，方法二不会使 Hero 类被初始化
        // 方法三：对象.getClass()
        // 在一个JVM中，一种类，只会有一个类对象存在。所以以上三种方式取出来的类对象，都是一样的。
        try {
            Class<?> pClass = Class.forName("Hero");    // 此时 Hero 类会被初始化
            System.out.println(pClass);

            /* 通过反射机制创建一个对象 */
            // 1、得到构造器 Constructor
            Constructor con1 = pClass.getConstructor();                                      // 无参
            Constructor con2 = pClass.getConstructor(String.class, int.class, int.class);    // 有参
            // 2、通过构造器 Constructor 实例化对象
            Hero hero1 = (Hero)con1.newInstance();
            System.out.println(hero1.toString());
            Hero hero2 = (Hero)con2.newInstance("galen", 500, 100);
            System.out.println(hero2.toString());

            /* 访问属性 */
            // getField() 只能获取public的，包括从父类继承来的字段
            // getDeclaredField() 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。
            //                    注： 这里只能获取到private的字段，但并不能访问该private字段的值,除非加上setAccessible(true)
            // 1、得到 Field 对象
            Field field = pClass.getField("other");
            // 2、通过 Field 更改属性
            field.set(hero1, 110);
            // 3、通过 Field 访问属性
            System.out.println(field.get(hero1));

            /* 调用方法 */
            // 1、得到 Method 对象
            Method m = pClass.getMethod("setName", String.class);    // 方法名, 参数1类型, 参数2类型, ...
            // 2、通过 Method 调用方法
            m.invoke(hero1, "name");    // 对象, 传参1, 传参2, ...
            System.out.println(hero1.getName());

        } catch(ClassNotFoundException e) {
            System.out.println("类名不存在");
            e.printStackTrace();
        } catch(Exception e) {
            System.out.println("未知错误");
            e.printStackTrace();
        }

        /* 通过配置文件创建对象 */
        File configFile = new File("./config.txt");             // 配置文件
        Properties configPro = new Properties();
        try {
            configPro.load(new FileInputStream(configFile));    // 加载配置文件到 Properties 对象中
            String className = (String)configPro.get("class");
            String methodName = (String)configPro.get("method");

            // 操作对象
            Class<?> clazz = Class.forName(className);    // 得到 Class 对象
            Constructor con = clazz.getConstructor();     // 得到构造器
            Hero h = (Hero)con.newInstance();             // 构造对象
            Method m = clazz.getMethod(methodName);       // 得到方法
            System.out.println(m.invoke(h));              // 调用方法

        } catch(FileNotFoundException e) {
            System.out.println("文件信息错误");
            e.printStackTrace();
        } catch(IOException e) {
            System.out.println("加载文件错误");
            e.printStackTrace();
        } catch(Exception e) {
            System.out.println("未知异常");
            e.printStackTrace();
        }
    }
}