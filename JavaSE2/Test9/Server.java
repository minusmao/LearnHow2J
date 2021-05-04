/**
 * 文件名：Server.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 网络编程
 * 时间：2021-4-29
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;

public class Server {
    /* 程序入口 */
    public static void main(String[] args) {
        try {
            // 定义 ServerSocket
            ServerSocket ss = new ServerSocket(8080);    // 设置为 8080 端口
            // 开始监听
            System.out.println("开始监听 8080 端口");
            Socket s = ss.accept();    // 会在这里一直等待连接过来
            // 打印链接过来的客户端信息
            System.out.println("连接对象：" + s);

            /* 收发数据 */
            // 打开输入流
            InputStream in = s.getInputStream();
            // 读取数据
            int data = in.read();    // 读取一个字节数据，返回 int 类型数据
            System.out.println(data);
            data = in.read();        // 等待客户端发送下一个字节
            System.out.println(data);
            data = in.read();        // 客户端已经关闭输出流，即流已经结束，返回 -1
            System.out.println(data);
            // 关闭流
            in.close();

            // 关闭
            s.close();
            ss.close();
        } catch(IOException e) {
            System.out.println("连接错误");
            e.printStackTrace();
        } finally {
            System.out.println("-------- 结束 --------");
        }

        /* 收发字符串 */
        try {
            // 定义 SeverSocket
            ServerSocket ss = new ServerSocket(8080);    // 设置监听端口为 8080
            // 开始监听
            System.out.println("开始监听 8080 端口");
            Socket s = ss.accept();    // 会在这里一直等待连接过来

            /* 收发数据 */
            // 打开输入流，并封装成数据流
            DataInputStream dataIn = new DataInputStream(s.getInputStream());
            // 读取数据
            String str = dataIn.readUTF();    // 读取 utf-8 编码的流，解析成 Unicode 字符串并返回
            System.out.println(str);
            System.out.println(dataIn.readUTF());
            // 关闭流
            dataIn.close();

            // 关闭
            s.close();
            ss.close();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("-------- 结束 --------");
        }
    }
}