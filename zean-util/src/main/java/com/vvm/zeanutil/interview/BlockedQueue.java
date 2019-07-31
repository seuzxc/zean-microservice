package com.vvm.zeanutil.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 * implements a blocked queue with jdk locks.
 *  for blocked queue the main point should be pay attention to is:
 *  1) when the queue is empty ,should not be remove
 *  2) when the queue is full ,should not be put
 *  3) when the queue is not full ,should notify thread that wait for add item
 *
 */
public class BlockedQueue {

    //the list used to save queue item
    private List<Integer> queueItems;

    // the max size of the queue
    private int maxQueueSize;

    //use lock for multi thread safety.
    private Lock lock = new ReentrantLock();

    //飞空，非满两个条件变量控制是否可以往队列添加，移除数据
    private Condition notEmpty = lock.newCondition(); //等待飞空条件
    private Condition notFull = lock.newCondition();//等待非满条件

    public BlockedQueue(int size) {
        maxQueueSize = size;
        queueItems = new ArrayList<>(size);
    }

    public void put(Integer item) throws Exception {
        lock.lock();
        try {
            while (queueItems.size() == maxQueueSize) {
                // 队列满，进入等待，condition进入等待，当前线程释放lock，进入wait状态,之所以用while循环进行判断
                // 是为了当前线程被通知进入running状态后继续判断，防止携程从该位置notify后任然不满足notFull条件
                notFull.await();
                System.err.println("current thread: " + Thread.currentThread().getName() + " notified for put");
            }
            queueItems.add(item);
            notEmpty.signal();

        } finally {
            // for jdk lock , the unlock should be written manually in finally
            lock.unlock();
        }
    }

    public Integer remove() throws Exception {
        lock.lock();
        try {
            while (0 == queueItems.size()) {
                notEmpty.await();
                System.err.println("current thread: " + Thread.currentThread().getName() + " notified for remove ");
            }
            Integer item = queueItems.remove(0);
            notFull.signal();
            return item;
        } finally {
            lock.unlock();
        }

    }
}
