/**
 * 文件名：ReceiveThread.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 网络编程 -> 多线程聊天
 * 时间：2021-5-4
 */

import java.net.Socket;
import java.io.DataInputStream;
import java.io.IOException;

public class ReceiveThread implements Runnable {
    /* 对象属性 */
    private Socket s;

    /* 构造方法 */
    public ReceiveThread(Socket s) {
        super();
        this.s = s;
    }

    /* 对象方法 */
    // 实现接口的 run() 方法
    @Override
    public void run() {
        try(
            DataInputStream dataIn = new DataInputStream(s.getInputStream());
        ) {
            // 循环接收并打印
            while(true) {
                String strBuf = dataIn.readUTF();
                System.out.println("接收到的内容："+ strBuf);
            }
        } catch(IOException e) {
            System.out.println("接收连接错误");
            e.printStackTrace();
        }
    }
}