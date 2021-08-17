package com.thread;


import java.util.concurrent.locks.ReentrantLock;

/**
 * 现程安全问题都是由全局变量及静态变量引起的
 * */
public class Demo5_3Ticket {

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

        ReentrantLock lock = new ReentrantLock();
        private int ticket = 10;

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

        //方法2：同步方法（this锁）
        private void sell(String name){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //方法三：加ReentrantLock锁
            lock.lock();
            if(ticket > 0){
               System.out.println(name + "卖票剩余:" + ticket);
               ticket--;
            }
            lock.unlock();
        }
    }
}
