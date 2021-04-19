/**
 * 文件名：BlockingQueue.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程 -> 交互 -> 生产者消费者
 * 时间：2021-4-18
 */

public class Test {
    /* 程序入口 */
    public static void main(String[] args) {
        BlockingQueue<Character> blockQueue = new BlockingQueue<>(5);    // 定义栈，最大容量为 5
        // 定义生产者和消费者
        Producer proThread = new Producer(blockQueue);
        Consumer conThread = new Consumer(blockQueue);
        // 开启两个线程
        proThread.start();
        conThread.start();
    }
}