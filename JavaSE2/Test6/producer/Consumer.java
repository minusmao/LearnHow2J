/**
 * 文件名：Consumer.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程 -> 交互 -> 生产者消费者
 * 时间：2021-4-18
 */

public class Consumer extends Thread {
    /* 对象属性 */
    private BlockingQueue<Character> queue;

    /* 构造方法 */
    public Consumer(BlockingQueue<Character> queue) {
        this.queue = queue;
    }

    /* 对象方法 */
    // 实现接口的 run() 方法
    @Override
    public void run() {
        int i = 0;
        while(i++ < 20) {
            try {
                char c = queue.take();
                Thread.sleep(10);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}