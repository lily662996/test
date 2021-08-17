package com.thread;

public class Demo3Runnable {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();

                for (int i = 0; i < 5; i++) {
                    System.out.println("第" + i + "次循环的线程名字是：" + name);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                for (int i = 0; i < 5; i++) {
                    System.out.println("第" + i + "次循环的线程名字是：" + name);
                }
            }
        }).start();

    }
}
