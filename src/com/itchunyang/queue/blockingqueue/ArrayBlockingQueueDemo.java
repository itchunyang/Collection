package com.itchunyang.queue.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by luchunyang on 2016/11/1.
 *
 * ArrayBlockingQueue和LinkedBlockingQueue的区别
 * 1.队列中锁的实现不同
 *      ArrayBlockingQueue实现的队列中的锁是没有分离的，即生产和消费用的是同一个锁；
 *      LinkedBlockingQueue实现的队列中的锁是分离的，即生产用的是putLock，消费是takeLock
 *
 * ArrayBlockingQueue进行put和take操作，共用同一个锁对象。也即是说，put和take无法并行执行！
 *
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        //基于数组的阻塞队列实现，在ArrayBlockingQueue内部，维护了一个定长数组
        final ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(5, true);

        //blockingQueue.take();//take 空队列会阻塞

        for (int i = 0; i < 5; i++) {
            blockingQueue.add("" + i);
        }
        //队列满 抛出异常
        //blockingQueue.add("");

        //不会抛出异常，返回false而已
        System.out.println(blockingQueue.offer(""));


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " element : " + blockingQueue.element());
                blockingQueue.element();//这个方法不能打断阻塞

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingQueue.poll();
                System.out.println(Thread.currentThread().getName() + " poll : " + blockingQueue.element());

            }
        }).start();

        //阻塞队列新的方法
        blockingQueue.put("5");
        System.out.println("队列阻塞完毕");
    }
}
