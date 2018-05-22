package com.blue.utils.tools;

import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

import java.util.concurrent.*;

/**
 * 线程池工具类
 *
 * @author lblue
 * @date 2018/5/17
 */
public class ThreadPoolUtils {

    /**
     *
     */
    private static ExecutorService threadPool = new ThreadPoolExecutor(0, 10,
            60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>());


    public static <T> Future<T> ex(Runnable task, T result) {
        return threadPool.submit(task, result);
    }

    public static void main(String[] args) {
        System.out.println(TimeUnit.DAYS.toHours(2));
    }
}
