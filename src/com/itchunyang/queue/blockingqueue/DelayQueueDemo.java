package com.itchunyang.queue.blockingqueue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by lcy on 2016/11/1.
 */
public class DelayQueueDemo {

    //有这个程序可以自动将上机的人排序，并在恰当的时间告诉老板哪个家伙时间到了
    public static void main(String[] args) {
        NetBar netBar = new NetBar();
        new Thread(netBar).start();

        netBar.start("李寻欢", "2094858773", 1);
        netBar.start("杨艳", "4493979494", 1);
        netBar.start("余青", "00990404", 3);
        netBar.start("柳岩", "8888888", 2);
    }

    static class SurfingMan implements Delayed {
        long endTime;
        String id;
        String name;

        public SurfingMan(long endTimeInMilliseconds, String id, String name) {
            this.endTime = System.nanoTime()+TimeUnit.NANOSECONDS.convert(endTimeInMilliseconds,TimeUnit.MILLISECONDS);
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "SurfingMan{" +
                    "endTime=" + endTime +
                    ", id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }

        //当一个元素的 getDelay(TimeUnit.NANOSECONDS) 方法返回一个小于等于 0 的值时，将发生到期。
        //应该返回以纳秒为单位的时间差
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(endTime - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        //通过take()方法取出时，可根据compareTo方法制定的顺序来优先取出线程执行
        @Override
        public int compareTo(Delayed o) {
            SurfingMan surefingMan = (SurfingMan) o;
            if (endTime > surefingMan.endTime)
                return 1;
            else if (endTime < surefingMan.endTime)
                return -1;
            return 0;
        }
    }

    static class NetBar implements Runnable {
        //无界阻塞队列,只有在延迟期满时才能从中提取元素
        DelayQueue<SurfingMan> delayQueue = new DelayQueue<>();

        public void start(String name, String id, int money) {
            SurfingMan surfingMan = new SurfingMan(60 * 1000 * money , id, name);
            System.out.println(""+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+" 网名" + surfingMan.name + " 身份证" + surfingMan.id + "交钱" + money + "块,开始上机...");
            delayQueue.add(surfingMan);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    SurfingMan man = delayQueue.take();
                    System.out.println(""+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+" 网名" + man.name + " 身份证" + man.id + "时间到下机...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
