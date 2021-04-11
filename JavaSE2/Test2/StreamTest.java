/**
 * 文件名：StreamTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> IO流 -> 字节流
 * 时间：2021-4-11
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.lang.Exception;

public class StreamTest {
    /* 程序入口 */
    public static void main(String[] args) {
        try {
            // InputStream是字节输入流，同时也是抽象类，只提供方法声明，不提供方法的具体实现
            // FileInputStream 是InputStream子类
            File file1 = new File("./Test.txt");
            FileInputStream fileIn1 = new FileInputStream(file1);    // 打开字节流
            byte[] fileBytes1 = new byte[(int) file1.length()];    // 创建字节数组
            fileIn1.read(fileBytes1);    // 读取文件到字节数组
            System.out.println(Arrays.toString(fileBytes1));    // 打印数组
            String fileStr1 = new String(fileBytes1, "utf-8");    // 以 UTF-8 解析字节数组为字符串
            System.out.println(fileStr1);
            // OutputStream是字节输出流，同时也是抽象类，只提供方法声明，不提供方法的具体实现
            // FileOutputStream 是OutputStream子类
            File file2 = new File("./Out.txt");    // 相对路径，肯定有父目录
            file2.getParentFile().mkdirs();    // 如果文件的父目录不存在，则会报错，所以可以调用此方法创建父目录
            FileOutputStream fileOut = new FileOutputStream(file2);
            fileOut.write(fileStr1.getBytes("GBK"));    // 得到以 GBK 编码的字节数组，并输出到文件，如果文件存在，会覆盖
        } catch(Exception e) {
            e.printStackTrace();
        }

        /* 关闭字符流的方式 */
        /*
            1、在try中关闭
                在try的作用域里关闭文件输入流，在前面的示例中都是使用这种方式，这样做有一个弊端：
                如果文件不存在，或者读取的时候出现问题而抛出异常，那么就不会执行这一行关闭流的代码，存在巨大的资源占用隐患。 不推荐使用
            2、在finally中关闭
                1. 首先把流的引用声明在try的外面，如果声明在try里面，其作用域无法抵达finally.
                2. 在finally关闭之前，要先判断该引用是否为空
                3. 关闭的时候，需要再一次进行try catch处理
            3、使用try()的方式 ----- 推荐
                把流定义在try()里,try,catch或者finally结束的时候，会自动关闭
                这种编写代码的方式叫做 try-with-resources， 这是从JDK7开始支持的技术
                所有的流，都实现了一个接口叫做 AutoCloseable，任何类实现了这个接口，都可以在try()中进行实例化
        */
        // 使用try()的方式关闭字节流
        File file5 = new File("./Test.txt");
        try(FileInputStream fileIn5 = new FileInputStream(file5)) {
            byte[] fileBytes5 = new byte[(int) file5.length()];    // 创建字节数组
            fileIn5.read(fileBytes5);    // 读取文件到字节数组
            System.out.println(Arrays.toString(fileBytes5));    // 打印数组
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}