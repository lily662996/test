package com.thread;

/**
 * 线程停止方法二：
 *  使用interrupt()方法，有两种情况：
 *  一：线程处于阻塞状态：
 *      如果使用了sleep,同步锁的wait,socket中的receiver,accept等方法时，会使线程处于阻塞状态。
 *      当调用线程的interrupt()方法时，会抛出InterruptException异常。阻塞中的那个方法抛出这个异常，通过代码捕获该异常，
 *      然后break跳出循环状态，从而让我们有机会结束这个线程
 *  二：未处于阻塞状态：
 *      当使用interrupt() 方法时，中断标志就会置ture，和使用自定义的标志来控制循环是一样的道理
 * */
public class Demo8_2Exit {

    public static boolean exit = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread((Runnable) () -> {
            while (exit){
                try {
                    System.out.println("线程执行！");

                    //判断线程中断标志来退出循环
                    if(Thread.currentThread().isInterrupted()){
                        break;

                    }
//                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                    //处于阻塞状态,当调用线程的interrupt()方法时，会抛出InterruptException异常
                    break;
                }
            }
        });
        t.start();

        Thread.sleep(1000);
        t.interrupt();
        System.out.println("线程中断了");
    }
}
