/**
 * 文件名：ThreadPool.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程 -> 线程池
 * 时间：2021-4-18
 */

import java.util.LinkedList;

public class ThreadPool {
    /* 对象属性 */
    private int poolSize;                                          // 任务消费者个数
    private LinkedList<Runnable> taskList = new LinkedList<>();    // 装线程任务的容器

    /* 构造方法 */
    public ThreadPool() {
        // 设置任务消费者个数
        poolSize = 10;
        // 启动 poolSize 个任务消费者线程
        synchronized(taskList) {
            for(int i = 0; i < poolSize; i++) {
                new TaskConsumeThread("任务消费者线程 " + i).start();
            }
        }
    }

    /* 对象方法 */
    public void addTask(Runnable newTask) {
        synchronized(taskList) {
            // 将线程任务添加到容器中
            taskList.addFirst(newTask);
            // 唤醒等待的任务消费者线程
            taskList.notifyAll();
        }
    }

    /* 内部类 */
    // 任务消费者
    private class TaskConsumeThread extends Thread {
        /* 对象属性 */
        Runnable task;

        /* 构造方法 */
        public TaskConsumeThread(String name) {
            super(name);
        }

        /* 对象方法 */
        // 重写父类的 run() 方法
        @Override
        public void run() {
            System.out.println("启动： " + this.getName());
            while(true) {
                // 同步对象 --- 装线程任务的容器
                synchronized(taskList) {
                    // 判断容器是否为空
                    while(taskList.isEmpty()) {
                        try {
                            taskList.wait();    // 为空则等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 不为空则取出任务
                    task = taskList.removeLast();
                    // 唤醒其他线程
                    taskList.notifyAll();
                }
                // 执行任务
                System.out.println(this.getName() + " 获取到任务，并执行");
                task.run();
            }
        }
    }
}