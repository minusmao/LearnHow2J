/**
 * 文件名：Server.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 网络编程 -> 多线程聊天
 * 时间：2021-5-4
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class Server {
    /* 程序入口 */
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8080);    // 设置监听端口为 8080
            System.out.println("开始监听 8080 端口");
            // 开始监听
            Socket s = ss.accept();    // 等待客户端连接
            System.out.println("客户端已连接：" + s);
            // 启动收发线程
            new Thread(new SendThread(s)).start();
            new Thread(new ReceiveThread(s)).start();
            // 关闭
            //s.close();
            //ss.close();
        } catch(IOException e) {
            System.out.println("连接错误");
            e.printStackTrace();
        }
    }
}