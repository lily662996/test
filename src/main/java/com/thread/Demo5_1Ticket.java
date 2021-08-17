package com.thread;

import java.util.concurrent.locks.ReentrantLock;


/**
 * 现程安全问题都是由全局变量及静态变量引起的
 * */
public class Demo5_1Ticket {

    public static void main(String[] args) {
        Ticket thicket = new Ticket();

        Thread t1 = new Thread(thicket, "窗口1");
        Thread t2 = new Thread(thicket, "窗口2");
        Thread t3 = new Thread(thicket, "窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
    static class Ticket implements Runnable{

        private int ticket = 10;
        Object lock = new Object();

        @Override
        public void run() {
            String name = Thread.currentThread().getName();

            while (true){
                sell(name);
                if (ticket <= 0){
                    break;
                }
            }

        }

        private void sell(String name){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //方法一：同步代码块
            synchronized (lock){
                if(ticket > 0){
                    System.out.println(name + "卖票剩余:" + ticket);
                    ticket--;
                }
            }

        }
    }
}
