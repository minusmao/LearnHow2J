/**
 * 文件名：StringTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 数字与字符串
 * 时间：2021-4-7
 */

public class StringTest {
    /* 程序入口 */
    public static void main(String[] args) {
        String sentence = "盖伦，在进行了连续8次击杀后，获得了“超神”的称号，AaBbCc";
        /* 操纵字符串 */
        // 获取指定位置的字符
        System.out.println(sentence.charAt(0));
        // 获取对应的字符数组
        char[] chars = sentence.toCharArray();
        // 截取子字符串
        System.out.println(sentence.substring(3));       // 一个参数，截取第 3 个之后的字符串（包括第 3 个）
        System.out.println(sentence.substring(3, 5));    // 一个参数，截取第 3 个（包括）到第 5 个（不包括）的字符串
        // 分隔
        String[] subSentences = sentence.split("，");    // 根据 "，" 进行分割，得到3个子字符串
        for (String sub : subSentences) {
            System.out.println(sub);
        }
        // 大小写
        System.out.println(sentence.toLowerCase());    // 全部变成小写，中文不变
        System.out.println(sentence.toUpperCase());    // 全部变成大写，中文不变
        // 定位
        System.out.println(sentence.indexOf('8'));         // 字符第一次出现的位置
        System.out.println(sentence.indexOf("超神"));      // 字符串第一次出现的位置
        System.out.println(sentence.lastIndexOf("了"));    // 字符串最后出现的位置
        System.out.println(sentence.indexOf(',',5));       // 从位置5开始，出现的第一次,的位置
        System.out.println(sentence.contains("击杀"));     // 是否包含字符串"击杀"
        // 替换
        String temp = sentence.replaceAll("击杀", "被击杀");     // 替换所有的
        temp = temp.replaceAll("超神", "超鬼");
        System.out.println(temp);
        temp = sentence.replaceFirst("，"," ");                   // 只替换第一个
        System.out.println(temp);

        /* 比较字符串 */
        // 是否是同一个对象
        String str1 = "the light";
        String str2 = new String(str1);
        String str3 = "the light";
        System.out.println( str1  ==  str2);    // 返回 false
        System.out.println( str1  ==  str3);    // 返回 true
        // 内容是否相同
        System.out.println(str1.equals(str2));              // 不忽略大小写
        System.out.println(str1.equalsIgnoreCase(str3));    // 忽略大小写的比较
        // 是否以子字符串开始或者结束
        System.out.println(str1.startsWith("the"));         // 是否以...开始
        System.out.println(str1.endsWith("ght"));           // 是否以...结束

        /* StringBuffer：可变长的字符串 */
        // 追加 删除 插入 反转
        str1 = "12345";
        System.out.println(str1);
        StringBuffer sb = new StringBuffer(str1);    // 根据str1创建一个StringBuffer对象
        sb.append("6789");        // 在最后追加
        System.out.println(sb);
        sb.delete(4, 6);          // 删除 4 （不包括）到 6 （包括）之间的字符
        System.out.println(sb);
        sb.insert(4, "there");    // 在 4 这个位置后插入 "there "
        System.out.println(sb);
        sb.reverse();             // 反转
        System.out.println(sb);
        // 长度 容量
        System.out.println(sb.length());      // 内容长度
        System.out.println(sb.capacity());    // 总空间
    }
}