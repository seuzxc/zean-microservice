package com.vvm.zeanutil.interview;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TicketTest {
    public static void main(String[] args) {
        BlockedQueue blockedQueue = new BlockedQueue(5);
        for (int i = 0; i < 3; i++) {
            new SellerThread(blockedQueue, "seller thread-" + i, i * 20).start();
        }

        new BuyThread(blockedQueue, "buy thread").start();
    }


    public static class SellerThread extends Thread {
        private BlockedQueue queue;

        private int startTicketNum;

        public SellerThread(BlockedQueue sharedQueue, String threadName, int startNum) {
            this.queue = sharedQueue;
            super.setName(threadName);
            this.startTicketNum = startNum;
        }

        public void run() {
            for (int i = startTicketNum; i < 10 + startTicketNum; i++) {
                try {
                    queue.put(i);
                    System.err.println("add item :" + i+", thread: "+Thread.currentThread().getName());
                } catch (Exception e) {
                    log.error("put error item: " + i, e);
                }
            }
        }
    }

    public static class BuyThread extends Thread {
        private BlockedQueue queue;

        public BuyThread(BlockedQueue sharedQueue, String threadName) {
            this.queue = sharedQueue;
            super.setName(threadName);
        }

        public void run() {
           while (true){
               try {
                  Integer item =  queue.remove();
                  System.err.println("remove item :" + item+", thread: "+Thread.currentThread().getName());
               } catch (Exception e) {
                   log.error("remove error item", e);
               }
           }
        }
    }
}
