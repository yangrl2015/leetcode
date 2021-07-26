package com.study.leetcode.multithread.problem01.solve04;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 这里采用的是ReentrantLock 但是这个会在n=5的时候出现TLE (TIME LIMIT EXCEED)
 */
public class FooBar {

    private int n;
    private volatile boolean fooExc = true;
    private ReentrantLock lock = new ReentrantLock(true); //采用公平锁

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            if(fooExc){
                try {
                    lock.lock();
                    printFoo.run();
                    fooExc = false;
                }
                finally {
                    lock.unlock();
                }
            }else {
                i--;
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            if(!fooExc){
                try {
                    lock.lock();
                    printBar.run();
                    fooExc = true;
                }
                finally {
                    lock.unlock();
                }

            }
            else {
                i--;
            }



        }
    }

}
