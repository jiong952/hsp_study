package com.zjh;

public class Thread03 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("主" + "吃了第" + i + "个包子");
            Thread.sleep(1000);
            if(i == 5) {
                System.out.println("子线程先执行");
//                t.join();
                Thread.yield();
            }
        }
    }
}
class T extends Thread{
    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            System.out.println("子" + "吃了第" + j + "个包子");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
