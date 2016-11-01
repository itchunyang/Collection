package com.itchunyang.queue.priority;

import java.util.PriorityQueue;

/**
 * Created by luchunyang on 2016/11/1.
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Staff> priorityQueue = new PriorityQueue<>(5);
        priorityQueue.add(new Staff(1,"员工1"));
        priorityQueue.add(new Staff(4,"员工4"));
        priorityQueue.add(new Staff(2,"员工2"));
        priorityQueue.add(new Staff(3,"员工3"));
        priorityQueue.add(new Staff(6,"员工6"));
        priorityQueue.add(new Staff(5,"员工5"));

        //为什么直接输出时的顺序不是排好序的？https://my.oschina.net/skyline520/blog/134977
//        Iterator<Staff> iterator = priorityQueue.iterator();
//
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    static class Staff implements Comparable<Staff>{
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
            return id - o.id;
        }
    }
}
