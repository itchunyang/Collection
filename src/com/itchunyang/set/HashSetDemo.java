package com.itchunyang.set;

import java.util.HashSet;

/**
 * Created by luchunyang on 2016/10/28.
 */
public class HashSetDemo {

    public static void main(String[] args) {
        //无重复元素的集合,不保证元素的顺序
        //由于Set只使用到了HashMap的key，所以此处定义一个静态的常量Object类，来充当HashMap的value
        //private static final Object PRESENT = new Object();
        HashSet<String> hashSet = new HashSet<>(10,0.75f);
        hashSet.add("hello");
        hashSet.add("java");
        System.out.println(hashSet.add("hello"));

        System.out.println(hashSet.toString());
    }
}
