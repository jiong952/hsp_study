package com.zjh;

import java.util.Locale;
import java.util.Scanner;

public class demo01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
    }
}
//A线程一直打印
class A extends Thread{
    private boolean loop = true;
    @Override
    public void run() {
        while (loop){
            System.out.println((int) (Math.random()*100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

//B线程监听输入，输入为Q则退出
class B extends Thread{
    private A a;
    private Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("请输入指令（Q）退出：");
            char c = scanner.next().toUpperCase().charAt(0);
            if(c == 'Q') {
                a.setLoop(false);
                System.out.println("正在退出");
                break;
            }
        }
    }
}