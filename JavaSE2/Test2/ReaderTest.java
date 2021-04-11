/**
 * 文件名：ReaderTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> IO流 -> 字符流
 * 时间：2021-4-11
 */

import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.lang.Exception;
import java.util.Arrays;

public class ReaderTest {
    /* 程序入口 */
    public static void main(String[] args) {
        // 文件对象
        File file = new File("./Out.txt");

        // 打开字符流，系统默认字符集，Charset.defaultCharset()的返回值
        try(FileReader fileRe = new FileReader​(file)) {
            // 定义字符数组
            char[] fileChars = new char[(int)file.length()];
            // 读取
            System.out.println((char)fileRe.read());   // 一次只读一个字符，注意函数返回 int 基本数据类型
            fileRe.read(fileChars);                    // 一次全部读完
            System.out.println(fileChars);
        } catch(Exception e) {
            e.printStackTrace();
        }

        // 打开字符流，系统默认字符集，Charset.defaultCharset()的返回值
        try(FileWriter fileWr = new FileWriter("./out.txt")) {
            // 定义内容，并得到字符数组
            char[] txt = "你好\n".toCharArray();
            // 写入
            fileWr.write(txt);
            fileWr.write("字符串");    // 可以直接写入字符串
            // 刷新缓冲区
            fileWr.flush();
        } catch(Exception e) {
            e.printStackTrace();
        }

        /* 不同字符集的字符流 */
        /*
            法 1：FileReader fileRe = new FileReader​(file, Charset.forName("UTF-8"));    // 在构造方法第二个参数指明字符集 Charset
            法 2：FileInputStream fileIn = new FileInputStream(file);    // 先得到字节流
                  InputStreamReader fileInRe = new InputStreamReader(fileIn, "UTF-8");    // 转化为 InputStreamReader 对象
        */
        // 试试法 2（InputStreamReader 是 Reader 的子类，FileReader 是 InputStreamReader 的子类）
        File test = new File("./Test.txt");
        try(
            FileInputStream fileIn = new FileInputStream(test);
            InputStreamReader fileInRe = new InputStreamReader(fileIn, "UTF-8");
        ) {
            char[] testChars = new char[(int)test.length()];
            fileInRe.read(testChars);
            System.out.println(new String(testChars));
        } catch(Exception e) {
            e.printStackTrace();
        }    
    }
}