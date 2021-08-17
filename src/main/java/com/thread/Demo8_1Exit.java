package com.thread;

/**
 * 线程停止方法一：
 *  使用退出标志
 * */
public class Demo8_1Exit {

    public static boolean exit = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread((Runnable) () -> {
            while (exit){
                try {
                    System.out.println("线程执行！");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        Thread.sleep(1000);
        exit = false;
        System.out.println("退出标识位设置成功");
    }
}
