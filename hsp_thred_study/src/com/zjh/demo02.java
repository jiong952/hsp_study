package com.zjh;

public class demo02 {
    public static void main(String[] args) {
        Card card = new Card();
        new A2(card).start();
        new A2(card).start();
    }
}
class Card {
    public static int balance = 10000;
    public void get(){
        balance-=1000;
    }

    public int getBalance() {
        return balance;
    }
}
class A2 extends Thread{
    private Card card;

    public A2(Card card) {
        this.card = card;
    }
    private static Object object = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (object){
                if(Card.balance < 1000){
                    System.out.println("余额不足");
                    break;
                }
                card.get();
                System.out.println(this.getName() + "取了1000"+"剩余："+card.getBalance()+"元");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}