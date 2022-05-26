package com.yangchd.exercise.concurrency.conc0301;

public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread t = Thread.currentThread();
            System.out.println("当前线程:" + t.getName());
        };
        Thread thread = new Thread(task);
        thread.setName("test-thread-1");
        thread.setDaemon(true);
        thread.start();

        Thread thread2 = new Thread(task);
        thread2.setName("test-thread-2");
        thread2.setDaemon(false);
        thread2.start();

        //Thread.sleep(5500);
    }


}
