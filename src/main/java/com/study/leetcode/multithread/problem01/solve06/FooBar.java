package com.study.leetcode.multithread.problem01.solve06;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;

/**
 * 执行用时：20 ms, 在所有 Java 提交中击败了99.40%的用户
 内存消耗：38.5 MB, 在所有 Java 提交中击败了74.58%的用户
 使用了LockSupport的工具类实现线程的park 和upark：
 这里注意，当unpark时传入的线程为null直接下行不会报任何错误，最好在while循环里判断park的条件
 */
public class FooBar {
    private int n;
    private Map<String,Thread> map = new HashMap<String,Thread>();
    private final String fooThread = "fooThread";
    private final String barThread = "barThread";
    private volatile boolean fooExec=true;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        map.put(fooThread, Thread.currentThread());
        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            while(!fooExec) {
                LockSupport.park();
            }
            printFoo.run();
            fooExec = false;
            LockSupport.unpark(map.get(barThread));
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        map.put(barThread, Thread.currentThread());
        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            while(fooExec){
                LockSupport.park();
            }
            printBar.run();
            fooExec = true;
            LockSupport.unpark(map.get(fooThread));

        }
    }
}
