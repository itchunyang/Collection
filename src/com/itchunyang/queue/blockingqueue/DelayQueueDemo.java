package com.itchunyang.queue.blockingqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by lcy on 2016/11/1.
 */
public class DelayQueueDemo {

    public static void main(String[] args) {
        DelayQueue<Staff> delayQueue = new DelayQueue<>();
    }

    static class Staff implements Delayed {
        int id;
        String name;

        public Staff(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Staff{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }
}
