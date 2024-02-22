package com.sxnd.leecode;

import java.util.concurrent.*;

/**
 * (一句话描述该类的功能)
 *
 * @version v1.0
 * @Author: xiaozhi
 * @Date: 2024/2/22 10:42
 */
public class Executors {
    /**
     * 测试一个thread多次Start
     * 测试结果：发现只启动了一个线程，另一个线程抛出IllegalThreadStateException
     */
    public void testTreadMulStart(){
        PrintTimeThread printTime = new PrintTimeThread();
        printTime.start();
        printTime.start();
    }

    public static class PrintTimeThread extends Thread {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }


    /**
     * 线程池使用
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                2,
                500,// 非核心最大线程的存活时间
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread  t = new Thread(r);
                        t.setName("测试-");
                        return t;
                    }
                },
                new ThreadPoolExecutor.AbortPolicy()
        );
        // 第一种方式 executor
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("嘿嘿嘿！！！");
            }
        });

        // 第二种方式 submit
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "called值";
            }

        });
        future.get();

    }
}
