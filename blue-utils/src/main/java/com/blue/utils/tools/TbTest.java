package com.blue.utils.tools;

/**
 * 类名
 *
 * @author lblue
 * @date 2018/5/17
 */
public class TbTest {
    private static int count = 0;
    private static synchronized void add(){
        //休眠1秒，模拟用户操作时间
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        System.out.println("相加后"+count);
    }

    private static synchronized void subtract(){
        //休眠1秒，模拟用户操作时间
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count--;
        System.out.println("相减后"+count);
    }

    public static void main(String[] args) {
        TbTest tbTes = new TbTest();
        new Thread(){
            @Override
            public void run() {
//                super.run();
                TbTest.add();
                TbTest.subtract();
            }
        }.start();
//        new Runnable(){
//
//            @Override
//            public void run() {
//
//            }
//        };
    }
}
