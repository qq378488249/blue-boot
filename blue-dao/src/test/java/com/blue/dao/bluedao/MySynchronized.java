package com.blue.dao.bluedao;

/**
 * Demo class
 *
 * @author lblue
 * @date 2018/01/22 11:42
 */
public class MySynchronized extends Thread {
    private int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    private Object getLock = new Object();

    private static Object lock = new Object();

    public MySynchronized(int v) {
        val = v;
    }

    public void printVal(int v) {
        synchronized (getLock) {
//            for (int i = 0; i < 50; i++)
//            {
//                System.out.print(v+System.currentTimeMillis());
//            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(v + "---" + System.currentTimeMillis());
        }
    }

    public void run() {
        printVal(val);
    }

    public static void main(String args[]) {
        MySynchronized f1 = new MySynchronized(1);
        f1.printVal(1);
        f1.printVal(2);
//        MySynchronized f2 = new MySynchronized(2);
//        f2.start();
    }
}
