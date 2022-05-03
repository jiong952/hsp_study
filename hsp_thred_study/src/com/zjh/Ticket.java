package com.zjh;

public class Ticket {
    public static void main(String[] args) {
        //Thread方式
        new SellTicket0().start();
        new SellTicket0().start();
        new SellTicket0().start();

    }
}

//Thread方式
class SellTicket0 extends Thread{
    private static int ticketNum = 100;//让多个线程共享 ticketNum
    private static Object object = new Object();
    @Override
    public void run() {
        while (ticketNum > 0) {
            synchronized (object){
                if (ticketNum <= 0) {
                    System.out.println("售票结束...");
                    return;
                }

                //休眠50毫秒, 交叉运行
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                        + " 剩余票数=" + (--ticketNum));
            }
        }
    }

}