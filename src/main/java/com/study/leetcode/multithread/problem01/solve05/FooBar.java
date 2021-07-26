package com.study.leetcode.multithread.problem01.solve05;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/** 通过阻塞队列
 * 执行用时：21 ms, 在所有 Java 提交中击败了94.93%的用户
 内存消耗：38.8 MB, 在所有 Java 提交中击败了16.86%的用户
 注意这里 add put 方法的区别
 */
public class FooBar {
    private int n;
    private BlockingQueue<Integer> fooQueue = new LinkedBlockingQueue<Integer>() {{
        add(0);
    }};
    private BlockingQueue<Integer> barQueue = new LinkedBlockingQueue<>();
    public FooBar(int n) throws InterruptedException {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws Exception {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
                fooQueue.take();
                printFoo.run();
                barQueue.add(1);

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                barQueue.take();
                printBar.run();
                fooQueue.add(1);


        }
    }
}
