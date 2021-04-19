/**
 * 文件名：ThreadPoolTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 多线程 -> 线程池
 * 时间：2021-4-18
 */

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    /* 程序入口 */
    public static void main(String[] args) {
        /* 开发一个自定义线程池 */
        ThreadPool pool = new ThreadPool();
        // 给线程池添加任务
        Runnable[] tasks = new Runnable[20];
        for(int i = 0; i < tasks.length; i++) {
            tasks[i] = new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行");
                }
            };
            pool.addTask(tasks[i]);
        }

        /* 使用java自带线程池 */
        // java提供自带的线程池 java.util.concurrent.ThreadPoolExecutor
        ThreadPoolExecutor taskPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        /*
            构造函数的各参数含义：
                第一个参数 --- 10 --- 表示这个线程池初始化了10个线程在里面工作
                第二个参数 --- 15 --- 表示如果10个线程不够用了，就会自动增加到最多15个线程
                第三个参数 --- 60 --- 结合第四个参数TimeUnit.SECONDS，表示经过60秒，多出来的线程还没有接到活儿，就会回收，最后保持池子里就10个
                第四个参数 --- TimeUnit.SECONDS --- 如上（TimeUnit 类型）
                第五个参数 --- new LinkedBlockingQueue<Runnable>() --- 用来放任务的集合（BlockingQueue<Runnable> 类型）
        */
        for(int i = 0; i < tasks.length; i++) {
            tasks[i] = new Runnable() {
                @Override
                public void run() {
                    System.out.println("官方线程池执行");
                }
            };
            taskPool.execute(tasks[i]);    // 放入线程池
        }
    }
}