/**
 * 文件名：SocketTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 网络编程
 * 时间：2021-4-29
 */

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class SocketTest {
    /* 程序入口 */
    public static void main(String[] args) {
        try {
            InetAddress host = InetAddress.getLocalHost();    // 获得本机地址的 InetAddress 对象
            String hostStr = host.getHostAddress();           // 文本表示的IP地址
            System.out.println(hostStr);
        } catch(UnknownHostException e) {
            e.printStackTrace();
        }

        /* 执行 ping */
        try {
            Process process = Runtime.getRuntime().exec("ping " + "192.168.1.1");    // 运行一个 windows 的 exe 程序
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            StringBuffer sb = new StringBuffer();
            while((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println(sb.toString());

            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        /* 练习：通过 ping 检测本地局域网的主机 */
        System.out.println("检测本地局域网的主机，列表如下：");
        List<String> ipList = new ArrayList<>();
        try {
            for(byte i = 0; i < 256; i++) {
                Process process = Runtime.getRuntime().exec("ping " + "192.168.1." + i);
                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String line;
                StringBuffer sb = new StringBuffer();

                // 获得 ping 程序返回的内容
                while((line = br.readLine()) != null) {
                    sb.append(line);
                }

                // 判断内容
                if(sb.indexOf("无法访问目标主机") == -1) {
                    // 返回 -1 说明没有“无法访问目标主机”，说明该 IP 的存在主机
                    ipList.add("192.168.1." + i);   // 添加
                    System.out.println("192.168.1." + i);
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}