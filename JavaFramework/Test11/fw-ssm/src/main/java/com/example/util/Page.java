package com.example.util;

/* 存放分页信息 */
public class Page {
    /* 对象属性 */
    private int start = 0;    // 记录当前页开始的位置
    private int count = 5;    // 每页的个数
    private int last = 0;     // 记录最后一页开始的位置

    /* 对象方法 */
    // getter 和 setter
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    // 通过总数total和每页的个数计算出最后一页开始的位置
    public void calculateLast(int total) {
        if (0 == total % count) {
            last = total - count;
        } else {
            last = total - total % count;
        }
    }
}
