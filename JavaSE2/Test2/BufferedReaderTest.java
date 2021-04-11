/**
 * 文件名：BufferedReaderTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> IO流 -> 缓存流
 * 时间：2021-4-10
 */

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class BufferedReaderTest {
    /* 程序入口 */
    public static void main(String[] args) {
        File file = new File("./Test.txt");

        /* BufferedReader 读取 */
        try(BufferedReader bufferRe = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            // 读取
            while(true) {
                String bufStr = bufferRe.readLine();
                if(bufStr == null) {
                    break;
                }
                System.out.println(bufStr);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        /* PrintWriter 写入 */
        try(PrintWriter printWr = new PrintWriter(new FileWriter("./Out.txt", Charset.forName("GBK")))) {
            printWr.println("第一行");
            printWr.println("第二行");
            printWr.println("第三行");
            printWr.flush();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}