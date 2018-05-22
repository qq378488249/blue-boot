package com.blue.dao.bluedao;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Demo class
 *
 * @author lblue
 * @date 2018/01/22 11:30
 */
public class Test {
    static Object object = new Object();
    static class MyThread implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            throw new RuntimeException("25");
//            return "Hello w65orld";
        }
    }

    static class MyThread2 implements Runnable {
        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> run = threadPool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        }, "2143");
        try {
            System.out.println(run.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        Future<String> future = threadPool.submit(new MyThread());
//
//        try {
//            System.out.println(future.get());
//        } catch (Exception e) {
//
//        } finally {
//            threadPool.shutdown();
//        }
    }
//    public static void main(String[] args) {
//        Callable<Integer> callable = new Callable<Integer>() {
//            public Integer call() throws Exception {
//                return new Random().nextInt(100);
//            }
//        };
//
//
////        new Thread(callable).start();
////
////        FutureTask<Integer> future = new FutureTask<Integer>(callable);
////        new Thread(future).start();
////        try {
////            Thread.sleep(1000);// 可能做一些事情
////            System.out.println(future.get());
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        } catch (ExecutionException e) {
////            e.printStackTrace();
////        }
//
////        ExecutorService threadPool = Executors.newSingleThreadExecutor();
////        Future<Integer> future = threadPool.submit(new Callable<Integer>() {
////            public Integer call() throws Exception {
//////                Thread.sleep(1000);
////                int b=0;
////                while(b<10){
////                    b++;
//////                    System.out.println(b++);
//////                    return b;
////                }
//////                return new Random().nextInt(100);
////                return b;
////            }
////        });
////        try {
//////            Thread.sleep(1000);// 可能做一些事情
////            System.out.println(future.get());
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        } catch (ExecutionException e) {
////            e.printStackTrace();
////        }
//    }

    static void a(int i) {
        synchronized (object) {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        sleep(2000);
                        System.out.println("代码块同步" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
