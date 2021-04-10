/**
 * 文件名：PracticeTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 异常处理 -> 综合练习
 * 时间：2021-4-10
 */

import practice.Account;
import practice.OverdraftException;

public class PracticeTest {
    /* 程序入口 */
    public static void main(String[] args) {
        Account account = new Account();
        // 存钱
        account.deposit(500.0);
        System.out.println("当前余额：" + account.getBalance());
        // 取钱
        try {
            System.out.println("取出：" + 1000.0);
            account.withdraw(1000.0);
        } catch(OverdraftException e) {
            e.printStackTrace();
            System.out.println("异常内容：" + e.getMessage() + "；透支额：" + e.getDeficit());
        }
    }
}