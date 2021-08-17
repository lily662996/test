package com.thread;

/**
 *有两种线程：用户线程、守护线程
 *
 * 用户线程：
 *  用户线程是指用户自定义创建的线程
 *  主线程停止 用户线程不会停止
 *
 * 守护线程：
 *  当进程不存在或主线程停止，守护线程也会被停止
 * */

public class Demo2CreateRunnable {

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();

        Thread t1 = new Thread(demo2);
        Thread t2 = new Thread(demo2);

        //设置为守护线程
//        t1.setDaemon(true);
//        t2.setDaemon(true);

        System.out.println("子线程开始执行了");
        t1.start();
        t2.start();
        System.out.println("主线程执行结束了");

    }
    static class Demo2 implements Runnable{

        @Override
        public void run() {
            String name = Thread.currentThread().getName();

            for (int i = 0; i < 5; i++) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第" + i + "次循环的线程名字是：" + name);
            }
        }


    }
}
