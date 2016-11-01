package com.itchunyang.queue.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by luchunyang on 2016/11/1.
 */
public class LinkedBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        //LinkedBlockingQueue基于链表的FIFO阻塞队列，在链表一头加入元素，如果队列满，就会阻塞，另一头取出元素，如果队列为空，就会阻塞。
        //putLock上的条件变量是notFull,即可以用notFull唤醒阻塞在putLock上的线程。takeLock上的条件变量是notEmtpy，即可用notEmpty唤醒阻塞在takeLock上的线程。
        //没有指定其容量大小，LinkedBlockingQueue会默认一个类似无限大小的容量（Integer.MAX_VALUE），这样的话，如果生产者的速度一旦大于消费者的速度，也许还没有等到队列满阻塞产生，系统内存就有可能已被消耗殆尽了
        //此对象是 线程阻塞-安全的
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(5);
//        System.out.println(linkedBlockingQueue.take());
//        System.out.println("take 阻塞");

        for (int i = 0; i < 5; i++) {
            linkedBlockingQueue.put(""+i);
        }

        System.out.println(linkedBlockingQueue.offer("5"));
        linkedBlockingQueue.put("5");//阻塞
        System.out.println(linkedBlockingQueue);
        
    }
}
