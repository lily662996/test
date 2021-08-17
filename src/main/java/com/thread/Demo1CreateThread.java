package com.thread;

public class Demo1CreateThread {
    public static void main(String[] args) {
        new Demo1().start();
        new Demo1().start();
    }

    static class Demo1 extends Thread{
        @Override
        public void run() {
            //获取线程名称
            String name = Thread.currentThread().getName();

            for (int i = 0; i < 5; i++) {
                System.out.println("第"+i+"次循环的线程名字是："+name);
            }
        }
    }
}
