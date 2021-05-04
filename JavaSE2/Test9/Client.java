/**
 * 文件名：Client.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 网络编程
 * 时间：2021-5-3
 */

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.DataOutputStream;

public class Client {
    /* 程序入口 */
    public static void main(String[] args) {
        try {
            // 定义 Socket，并执行连接
            Socket s = new Socket("localhost", 8080);
            // 打印连接信息
            System.out.println(s);

            /* 收发数据 */
            // 打开输出流
            OutputStream out = s.getOutputStream();
            // 写入数据
            int data = 256;
            out.write(data);    // 写入一个字节数据，传入 int 类型数据，只发送最低的一个字节
            try {
                Thread.sleep(1000);    // 延时 1 秒
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            out.write(data);
            // 关闭流
            out.close();

            // 关闭
            s.close();
        } catch(UnknownHostException e) {
            System.out.println("域名信息错误");
            e.printStackTrace();
        } catch(IOException e) {
            System.out.println("连接错误");
            e.printStackTrace();
        } finally {
            System.out.println("-------- 结束 --------");
        }

        /* 收发字符串 */
        try {
            // 定义 Socket，并执行连接
            Socket s = new Socket("127.0.0.1", 8080);
            // 打印连接信息
            System.out.println(s);

            /* 收发数据 */
            // 打开输出流，并封装成数据流
            DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
            // 写入数据
            dataOut.writeUTF("字符串数据，编码格式为 utf-8");
            dataOut.writeUTF("字符串数据");
            // 关闭流
            dataOut.close();

            // 关闭
            s.close();
        } catch(UnknownHostException e) {
            System.out.println("域名信息错误");
            e.printStackTrace();
        } catch(IOException e) {
            System.out.println("连接错误");
            e.printStackTrace();
        } finally {
            System.out.println("-------- 结束 --------");
        }
    }
}