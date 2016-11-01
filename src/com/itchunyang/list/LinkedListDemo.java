package com.itchunyang.list;

import java.util.LinkedList;

/**
 * Created by luchunyang on 2016/10/28.
 * 底层双向链表
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("ONE");
        linkedList.add("TWO");
        linkedList.add("THREE");
        linkedList.add("FOUR");
        linkedList.add("FIVE");
        linkedList.add("SIX");
        linkedList.addFirst("first");
        linkedList.addLast("last");

        System.out.println(linkedList);
    }
}
