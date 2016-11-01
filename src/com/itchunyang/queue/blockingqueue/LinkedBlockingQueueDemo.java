package com.itchunyang.queue.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by luchunyang on 2016/11/1.
 */
public class LinkedBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        //没有指定其容量大小，LinkedBlockingQueue会默认一个类似无限大小的容量（Integer.MAX_VALUE），这样的话，如果生产者的速度一旦大于消费者的速度，也许还没有等到队列满阻塞产生，系统内存就有可能已被消耗殆尽了
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(5);
        linkedBlockingQueue.put("");
    }
}
