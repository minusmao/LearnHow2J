/**
 * 文件名：Client.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 网络编程 -> 多线程聊天
 * 时间：2021-5-4
 */

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

public class Client {
    /* 程序入口 */
    public static void main(String[] args) {
        try {
            System.out.println("连接 localhost 的 8080 端口");
            Socket s = new Socket("localhost", 8080);    // 连接本地 8080 端口
            // 连接成功，打印信息
            System.out.println("连接成功：" + s);
            // 启动收发线程
            new Thread(new SendThread(s)).start();
            new Thread(new ReceiveThread(s)).start();
        } catch(UnknownHostException e) {
            System.out.println("域名信息错误");
            e.printStackTrace();
        } catch(IOException e) {
            System.out.println("连接错误");
            e.printStackTrace();
        }
    }
}