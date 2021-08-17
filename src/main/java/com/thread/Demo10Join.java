package com.thread;

import java.util.Random;

/**
 * join():让其他线程变为等待
 *      thread.join()把指定线程加入到当前线程中去
 *      比如在线程B中调用线程A的join()方法，A执行完毕后，才会继续执行B
 * */
public class Demo10Join {
    public static void main(String[] args) {

        JoinThread joinThread = new JoinThread();
        Thread thread1 = new Thread(joinThread, "线程1");
        Thread thread2 = new Thread(joinThread, "线程2");
        Thread thread3 = new Thread(joinThread, "线程3");
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
        } catch (Exception e) {

        }
        for (int i = 0; i < 5; i++) {
            System.out.println("main ---i:" + i);
        }
    }

    static class JoinThread implements Runnable {

        private Random random = new Random();

        public void run() {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + "内容是:" + i);
            }
        }
    }
}