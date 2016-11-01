package com.itchunyang.queue.deque;

import java.util.ArrayDeque;

/**
 * Created by luchunyang on 2016/11/1.
 * 数组双端队列
 *
 */
public class ArrayDequeDemo {

    public static void main(String[] args) {
        //默认初始化16个元素，它没有限制的，自动扩容！底层循环数组
        ArrayDeque<String> deque = new ArrayDeque<>(10);

        //常规队列添加方法 2个
        deque.addFirst("1");
        deque.addLast("2");
        deque.add("3");
        deque.offer("4");
        deque.offerFirst("5");
        deque.offerLast("6");

        System.out.println(deque.toString());


        //队列查看
        System.out.println("peek:"+deque.peek());
        System.out.println("peekFirst:"+deque.peekFirst());
        System.out.println("peekLast:"+deque.peekLast());
        System.out.println("element:"+deque.element());//queue为空 报异常

        //队列移除,queue为空 报异常
        deque.remove("3");
        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque.toString());
    }
}
