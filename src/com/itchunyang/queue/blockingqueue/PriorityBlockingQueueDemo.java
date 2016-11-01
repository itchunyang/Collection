package com.itchunyang.queue.blockingqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by lcy on 2016/11/1.
 */
public class PriorityBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        //这是一个基于优选级队列，它具有可阻塞的读取操作。不阻塞写操作!!!!!
        //PriorityBlockingQueue队列添加新元素时候不是将全部元素进行顺序排列，而是从某个指定位置开始将新元素与之比较，一直比到队列头，这样既能保证队列头一定是优先级最高的元素，又能减少排序带来的性能消耗
        //但是这样会出现一个情况，取完队列头时候，后面的剩余的元素不是排序的，岂不是不符合要求了，继续查看源码，发现每取一个头元素时候，都会对剩余的元素做一次调整，这样就能保证每次队列头的元素都是优先级最高的元素
//        Comparator<Staff> comparator = new Comparator<Staff>() {
//            @Override
//            public int compare(Staff o1, Staff o2) {
//                if(o1.id < o2.id)
//                    return 1;
//                else if(o1.id > o2.id)
//                    return -1;
//                return 0;
//            }
//        };
        //PriorityBlockingQueue<Staff> priorityBlockingQueue = new PriorityBlockingQueue<>(5,comparator);


        PriorityBlockingQueue<Staff> priorityBlockingQueue = new PriorityBlockingQueue<>(5);
//        priorityBlockingQueue.take();//读阻塞

        priorityBlockingQueue.put(new Staff(25,"员工25"));
        for (int i = 0; i < 5; i++) {
            priorityBlockingQueue.put(new Staff(i,"员工"+i));
        }

        priorityBlockingQueue.put(new Staff(5,"员工5"));//不会阻塞
        priorityBlockingQueue.put(new Staff(15,"员工15"));
        priorityBlockingQueue.put(new Staff(15,"员工15"));


//        Iterator<Staff> iterator = priorityBlockingQueue.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }


        int size = priorityBlockingQueue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(priorityBlockingQueue.poll());
        }

    }

    private static class Staff implements Comparable<Staff>{
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
        public int compareTo(Staff o) {
            return o.id - id;
        }
    }
}
