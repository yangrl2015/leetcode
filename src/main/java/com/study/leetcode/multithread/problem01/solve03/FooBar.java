package com.study.leetcode.multithread.problem01.solve03;

/**
 * 通过yield让出当前cpu，让出当前线程让出cpu之后，该线程和别地线程都会
 * 竞争cpu，当前线程可能再次获取cpu
 *
 *执行用时：21 ms, 在所有 Java 提交中击败了94.93%的用户
 内存消耗：38.2 MB, 在所有 Java 提交中击败了95.58%的用户
 * *
 */
public class FooBar {
    private int n;
    private volatile boolean fooExc = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            if(fooExc){
                printFoo.run();
                fooExc = false;
            }else {
                i--;
                Thread.yield();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            if(!fooExc){
                printBar.run();
                fooExc = true;
            }
            else {
                i--;
                Thread.yield();
            }



        }
    }


}
