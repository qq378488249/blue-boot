package com.blue.dao.bluedao;

/**
 * Demo class
 *
 * @author lblue
 * @date 2018/01/22 11:30
 */
public class Test {
    static Object object = new Object();

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            a(i);
//        }
        a(1);
        a(2);
    }

    static void a(int i){
        synchronized(object){
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    try {
                        sleep(2000);
                        System.out.println("代码块同步"+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
