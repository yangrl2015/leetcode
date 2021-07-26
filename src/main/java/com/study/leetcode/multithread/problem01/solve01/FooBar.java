package com.study.leetcode.multithread.problem01.solve01;

/**
 * 通过notify wait通知机制解决：
 执行用时：24 ms, 在所有 Java 提交中击败了84.74%的用户
 内存消耗：38.7 MB, 在所有 Java 提交中击败了25.70%的用户
 */
public class FooBar {
    private  int n;
    private volatile int flag;
    private Object obj = new Object();
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.

            synchronized(obj) {
                while(flag %2 != 0) obj.wait();
                printFoo.run();
                flag=1;
                obj.notify();
            }





        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized(obj) {
                while(flag %2 != 1) obj.wait();
                printBar.run();
                flag=0;
                obj.notify();
            }


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
