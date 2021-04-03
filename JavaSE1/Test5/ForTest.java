/**
 * 文件名：ForTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 流程控制 -> for、continue、break
 * 时间：2021-4-3
 */

public class ForTest {
    /* 程序入口 */
    public static void main(String[] args) {
        /* for */
        int money = 0;
        int moneyPerDay = 1;
        System.out.println("天朝有一个乞丐姓洪，去天桥要钱");
        for(int i = 0; i < 10; i++) {
            money += moneyPerDay; 
            System.out.println("第" + (i+1) + "天要了" + moneyPerDay + "块钱");
            moneyPerDay *= 2;
        }
        System.out.println("他一共要了" + money + "块钱");

        /* continue */
        for(int i = 0; i < 10; i++) {
            if((i%3 == 0) || (i%5 == 0)) {
                continue;
            }
            System.out.println(i);
        }

        /* break */
        for(int i = 0; i < 10; i++) {
            if(i == 5) {
                break;
            }
            System.out.println(i);
        }

        System.out.println("=================");
        
        /* 结束外部循环 */
        //打印单数    
        outLoop: //outLoop这个标示是可以自定义的比如outLoop1,ol2,out5
        for (int i = 0; i < 10; i++) {
             
            for (int j = 0; j < 10; j++) {
                System.out.println(i+":"+j);
                if(4==j%5) 
                    break outLoop; //如果是双数，结束外部循环
            }
             
        }
    }
}