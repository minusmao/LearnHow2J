/**
 * 文件名：Producer.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程 -> 交互 -> 生产者消费者
 * 时间：2021-4-18
 */

public class Producer extends Thread {
    /* 对象属性 */
    private BlockingQueue<Character> queue;

    /* 构造方法 */
    public Producer(BlockingQueue<Character> queue) {
        this.queue = queue;
    }

    /* 对象方法 */
    // 实现接口的 run() 方法
    @Override
    public void run() {
        int i = 0;
        while(i++ < 20) {
            try {
                char c = (char)(Math.random()*('Z'-'A'+1) + 'A');
                queue.put(c);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}