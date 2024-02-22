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
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                2,
                500,
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
