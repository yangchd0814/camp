package com.yangchd.week04;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */
public class Homework03_03 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start=System.currentTimeMillis();

        Sum sum = new Sum();
        Thread1 t = new Thread1(sum);
        t.start();

        t.join();

        System.out.println("异步计算结果为："+ sum.getSum());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    public static class Thread1 extends Thread {
        private Sum sum;
        public Thread1(Sum sum) {
            this.sum = sum;
        }

        @Override
        public void run() {
            sum.setSum(sum());
        }
    }

    public static class Sum {
        private Integer sum;

        public Integer getSum() {
            return sum;
        }

        public void setSum(Integer sum) {
            this.sum = sum;
        }
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
