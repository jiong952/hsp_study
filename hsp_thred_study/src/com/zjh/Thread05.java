package com.zjh;

public class Thread05 {
    public static void main(String[] args) throws InterruptedException {
        T3 t3 = new T3();
        System.out.println(t3.getState());
        t3.start();
        System.out.println(t3.getState());
        for (int i = 0; i < 15; i++) {
            System.out.println(t3.getState());
            Thread.sleep(1000);
        }
        System.out.println(t3.getState());
    }
}
class T3 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("测试线程");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
