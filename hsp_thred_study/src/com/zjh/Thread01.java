package com.zjh;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        new Cat().run();
        System.out.println("主线程继续执行 "+Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程 i="+i);
            //让主线程休眠1秒
            Thread.sleep(1000);
        }

    }
}
class Cat extends Thread{
    @Override
    public void run() {
        int times = 0;
        while(true){
            System.out.println("小猫咪" + (++times) + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times == 7) break;
        }
    }
}