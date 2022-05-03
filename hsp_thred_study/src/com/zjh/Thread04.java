package com.zjh;

import java.util.List;

public class Thread04 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.setDaemon(true);
        t2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程工作" + i);
            Thread.sleep(1000);
        }
    }
}
class T2 extends Thread{
    @Override
    public void run() {
        for (; ;) {
            System.out.println("守护线程");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
