/**
 * 文件名：Account.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 异常处理 -> 综合练习
 * 时间：2021-4-10
 */

package practice;

public class Account {
    /* 对象属性 */
    private double balance;    // 余额

    /* 对象方法 */
    // 得到余额 balance
    public double getBalance() {
        return balance;
    }
    // 存钱
    public void deposit(double amt) {
        this.balance += amt;
    }
    // 取钱
    public void withdraw(double amt) throws OverdraftException {
        if(this.balance < amt) {
            // 如果余额 balance 小于 amt，则抛出透支异常
            throw new OverdraftException("透支", this.balance -= amt);
        } else {
            this.balance -= amt;
        }
    }
}