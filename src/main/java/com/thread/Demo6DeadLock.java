package com.thread;


import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁：
 *  同步中嵌套同步
 * */
public class Demo6DeadLock {

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

        //对象锁
        Object lock = new Object();
        private int ticket = 1000;

        @Override
        public void run() {
            String name = Thread.currentThread().getName();

            while (true){
                if("窗口1".equals(name)){
                    synchronized (lock){
                        sell(name);
                    }
                }else {
                    sell(name);
                }
                if (ticket <= 0){
                    break;
                }
            }

        }

        private synchronized void sell(String name){ //this锁
            synchronized (lock){ //想要获取对象锁
                if(ticket > 0){
                    System.out.println(name + "卖票剩余:" + ticket);
                    ticket--;
                }
            }
        }
    }
}
