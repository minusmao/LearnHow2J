/**
 * 文件名：DataStreamTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> IO流 -> 数据流
 * 时间：2021-4-11
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class DataStreamTest {
    /* 程序入口 */
    // 注：要用DataInputStream 读取一个文件，这个文件必须是由DataOutputStream 写出的，否则会出现EOFException，
    //     因为DataOutputStream 在写出的时候会做一些特殊标记，只有DataInputStream 才能成功的读取
    public static void main(String[] args) {
        File data = new File("./Data");

        // 写入
        try(DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(data))) {
            dataOut.writeBoolean(true);
            dataOut.writeInt(1000);
            dataOut.writeUTF("你好");
        } catch(Exception e) {
            e.printStackTrace();
        }

        // 读取
        try(DataInputStream dataIn = new DataInputStream(new FileInputStream(data))) {
            System.out.println(dataIn.readBoolean());
            System.out.println(dataIn.readInt());
            System.out.println(dataIn.readUTF());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}