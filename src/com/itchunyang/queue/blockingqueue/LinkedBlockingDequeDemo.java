package com.itchunyang.queue.blockingqueue;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by lcy on 2016/11/1.
 */
public class LinkedBlockingDequeDemo {

    public static void main(String[] args) throws InterruptedException {
        //Deque。这种队列允许在队列头和尾部进行入队出队操作
        LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>(5);
        for (int i = 0; i < 5; i++) {
            linkedBlockingDeque.put(""+i);
        }

//        linkedBlockingDeque.put("5");//阻塞
//        linkedBlockingDeque.putLast("5");//阻塞

//        linkedBlockingDeque.addLast("5");//异常Deque full
        //linkedBlockingDeque.offer("5");//非阻塞
        linkedBlockingDeque.offerLast("5",5, TimeUnit.SECONDS);
        System.out.println(linkedBlockingDeque.toString());
    }
}
