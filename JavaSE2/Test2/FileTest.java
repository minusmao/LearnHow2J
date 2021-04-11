/**
 * 文件名：FileTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> IO流 -> 文件对象
 * 时间：2021-4-10
 */

import java.io.File;
import java.util.Date;

public class FileTest {
    /* 类方法 */
    // 递归遍历文件夹
    public static void showFile(File f, int tabNum) {
        // 根据 tabNum 确定 tab 数
        char[] tabChars = new char[tabNum];    // 定义存储 tab 的数组
        for(int i = 0; i < tabChars.length; i++) {
            tabChars[i] = '\t';    // 填充 tab
        }
        String tabStr = String.valueOf(tabChars);    // 数组转化为 字符串

        // 判断是否是文件
        if(f.isFile()) {
            System.out.println(tabStr + f.getName() + "\t" + f.length());    // 打印文件名和文件大小
        } else {
            System.out.println(tabStr + f.getName());    // 打印文件夹名
            File[] files = f.listFiles();    // 获得其子文件的 File 数组
            // 遍历递归调用
            for(File ff : files) {
                showFile(ff, tabNum+1);
            }
        }
    }
    /* 程序入口 */
    public static void main(String[] args) {
        /* 创建文件对象 File */
        File file1 = new File("./Test.txt");    // 相对路径
        File file2 = new File("E:/Code/Java/Test/How2J/JavaSE2/Test2/Test.txt");    // 绝对路径
        System.out.println("file1 是：" + file1 + "\nfile2 是：" + file2);

        /* 文件常用方法1 */
        // toString() 返回文件里路径，与 getPath() 一样
        System.out.println("--------------------------");
        System.out.println("toString() 方法，得到\nfile1 的路径：" + file1.toString() + "\nfile2 的路径：" + file2.toString());
        System.out.println("getPath() 方法，得到\nfile1 的路径：" + file1.getPath() + "\nfile2 的路径：" + file2.getPath());
        System.out.println("--------------------------");
        // exists() 判断是否存在
        System.out.println("file1 是否存在：" + file1.exists());
        // isDirectory() 判断是否是文件夹
        System.out.println("file1 是否是文件夹：" + file1.isDirectory());
        // isFile() 判断是否是文件（非文件夹）
        System.out.println("file1 是否是文件：" + file1.isFile());
        // length() 返回文件长度
        System.out.println("file1 文件大小为：" + file1.length());
        // lastModified() 返回文件最后修改时间，返回的数据类型为 long
        Long lastTimeLong = file1.lastModified();
        System.out.println(new Date(lastTimeLong).toString());
        // setLastModified 设置文件修改时间
        file1.setLastModified(0);    // 设置为 1970.1.1 08:00:00
        System.out.println(new Date(file1.lastModified()).toString());
        // renameTo() 文件重命名，需要传入取好名字的 File 对象
        File file3 = new File("./test/Test.txt");
        //file1.renameTo(file3);    // 必须先在当前目录下创建 test 子文件夹，才能成功
        System.out.println("file1 是：" + file1);

        System.out.println("--------------------------");

        /* 文件常用方法2 */
        File file4 = new File("E:/Code/Java/Test/How2J/JavaSE2/Test2/");
        // list() 以字符串数组的形式，返回当前文件夹下的所有文件和文件夹（不包含子文件和子文件夹）
        String[] fileName = file4.list();    // file4 不能为文件，否则报错
        for(String str : fileName) {
            System.out.println(str);
        }
        /*
        // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        File[]fs= f.listFiles();

        // 以字符串形式返回获取所在文件夹
        f.getParent();
  
        // 以文件形式返回获取所在文件夹
        f.getParentFile();

        // 创建文件夹，如果父文件夹不存在，创建就无效
        f.mkdir();
  
        // 创建文件夹，如果父文件夹不存在，就会创建父文件夹
        f.mkdirs();
  
        // 创建一个空文件,如果父文件夹不存在，就会抛出异常
        f.createNewFile();
        // 所以创建一个空文件之前，通常都会创建父目录
        f.getParentFile().mkdirs();
  
        // 列出所有的盘符c: d: e: 等等
        f.listRoots();
  
        // 刪除文件
        f.delete();
  
        // JVM结束的时候，刪除文件，常用于临时文件的删除
        f.deleteOnExit();
        */

        /* 练习：遍历文件夹 */
        System.out.println("\n-------- 练习：遍历文件夹 ----------");
        File file5 = new File("E:/Code/Java/Test/How2J");
        showFile(file5, 0);
    }
}