/**
 * 文件名：ExceptionTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 异常处理
 * 时间：2021-4-9
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest {
    // throws 测试方法 1
    public static void testThrows1() {
        try {
            testThrows2();
        } catch(FileNotFoundException e) {
            e.printStackTrace();    // 打印异常信息
        } finally {
            System.out.println("测试 throws");
        }
    }
    // throws 测试方法 2
    public static void testThrows2() throws FileNotFoundException{
        throw new FileNotFoundException();    // 主动抛出一个异常
    }
    // throws 测试方法 3 Throwable类
    public static void testThrows3() throws Throwable {
        throw new FileNotFoundException();    // 主动抛出一个异常
    }
    // 练习：try、catch、finally都有return
    public static int testReturn() {
        try {
            return 1;
        } catch(Exception e) {
            return 2;
        } finally {
            return 3;    // 测试结果，最后依然会执行 finally
        }
    }
    /* 程序入口 */
    public static void main(String[] args) {
        File file = new File("d:/LOL.exe");
        FileInputStream input;
        /* 处理异常 */
        // try catch 捕获异常
        try {
            System.out.println("视图打开" + file.getPath());
            input = new FileInputStream(file);
            System.out.println("成功打开");
        } catch(FileNotFoundException e) {
            System.out.println(file.getPath() + "不存在");
            e.printStackTrace();    // 打印异常信息
        } catch(Exception e) {
            System.out.println("未知异常");
            e.printStackTrace();    // 打印异常信息
        } finally {
            // finally 一般用来做统一的处理
            System.out.println("是否有异常，都会执行 finally 代码块");
        }
        // 多异常也可以放在一个 catch 里面，然后再内部判断，如下：
        /*
        catch (FileNotFoundException | ParseException e) {
            if (e instanceof FileNotFoundException)
                System.out.println("d:/LOL.exe不存在");
            if (e instanceof ParseException)
                System.out.println("日期格式解析错误");
        }
        */
        // throws 抛走异常
        testThrows1();
        // 练习：try、catch、finally都有return
        System.out.println(testReturn());    // 测试结果，最后依然会执行 finally

        /* 异常分类：可查异常、运行时异常和错误 */
        /*
        Throwable:Error: 错误 ---> 系统级别的异常，通常是内存用光了
                  Exception: RuntimeException: 运行时异常 ---> 不是必须进行try catch的异常（下标越界、除数为零等）
                             非RuntimeException：可查异常 ---> 必须进行处理的异常
        */
        
        /* Throwable：Error和Exception都是它的子类 */
        try {
            new FileInputStream(file);
            //使用Throwable进行异常捕捉
        } catch (Throwable t) {
            // TODO Auto-generated catch block
            t.printStackTrace();
        }
        // 测试 Throws Throwable
        try {
            testThrows3();    // 测试证明，方法可以抛出 Throwable 异常类
            //使用Throwable进行异常捕捉
        } catch (Throwable t) {
            // TODO Auto-generated catch block
            t.printStackTrace();
        }
    }
}