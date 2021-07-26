package com.study.leetcode.multithread.problem01.solve02;

import java.util.concurrent.Semaphore;

/**
 * 执行用时：23 ms, 在所有 Java 提交中击败了86.75%的用户
 内存消耗：38.7 MB, 在所有 Java 提交中击败了42.71%的用户
 */
public class FooBar {
    private int n;
    private Semaphore fooSemap = new Semaphore(1);
    private Semaphore barSemap = new Semaphore(0);
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            fooSemap.acquire();
            printFoo.run();
            barSemap.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            barSemap.acquire();
            printBar.run();
            fooSemap.release();
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(2);
        Runnable printFoo = ()->{
            System.out.print("foo");
        };
        Runnable printBar = ()->{
            System.out.print("bar");
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(printFoo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(printBar);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
