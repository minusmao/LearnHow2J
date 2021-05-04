/**
 * 文件名：SendThread.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 网络编程 -> 多线程聊天
 * 时间：2021-5-4
 */

import java.net.Socket;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SendThread implements Runnable {
    /* 对象属性 */
    private Socket s;

    /* 构造方法 */
    public SendThread(Socket s) {
        super();
        this.s = s;
    }

    /* 对象方法 */
    // 实现接口的 run() 方法
    @Override
    public void run() {
        try(
            DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());    // 输出流
        ) {
            // 循环读取并发送
            while(true) {
                System.out.print("请输入要发送的内容：");
                Scanner scan = new Scanner(System.in);     // 获取系统输入
                String strBuf = scan.next();
                dataOut.writeUTF(strBuf);
            }
        } catch(IOException e) {
            System.out.println("发送连接错误");
            e.printStackTrace();
        }
    }
}