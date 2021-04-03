/**
 * 文件名：HomeworkTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 流程控制 -> 综合练习
 * 时间：2021-4-3
 */
import java.lang.Math;

public class HomeworkTest {
    /* 程序入口 */
    public static void main(String[] args) {
        /* 黄金分割点 */
        int x = 0;
        int y = 0;
        float x_y = 10;
        for(int i = 2; i <= 20; i++) {
            for(int j = 2; j <= 20; j++) {
                float delta = Math.abs(i/(float)j - 0.618F);    // 计算绝对值
                if(delta < Math.abs(x_y - 0.618)) {
                    x = i;
                    y = j;
                    x_y = (float)x/y;
                }
            } 
        }
        System.out.println(x + "/" + y + "=" + x_y);

        /* 寻找水仙花数 */
        // 水仙花数定义：
        //     1. 一定是3位数
        //     2. 每一位的立方，加起来恰好是这个数本身，比如153=1*1*1+5*5*5+3*3*3
        for(int i = 100; i < 1000; i++) {
            int ge = i%10;
            int shi = (i%100 - ge)/10;
            int bai = i/100;
            if(i == (ge*ge*ge + shi*shi*shi + bai*bai*bai)) {
                System.out.println(i);
            }
        }

        /* 小学算术：i+j=8、n-m=6、i+n=14、j+m=10 */
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                for(int n = 0; n < 20; n++) {
                    for(int m = 0; m < 20; m++) {
                        if(i+j==8 && n-m==6 && i+n==14 && j+m==10) {
                            System.out.println("{" + i + ", " + j + ", " + n + ", " + m + "}");
                        }
                    }
                }
            }
        }
    }
}