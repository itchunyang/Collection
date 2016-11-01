package com.itchunyang.queue.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by luchunyang on 2016/11/1.
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        //基于数组的阻塞队列实现，在ArrayBlockingQueue内部，维护了一个定长数组
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(5, true);

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
