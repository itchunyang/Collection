package com.itchunyang.map;

import java.util.HashMap;

/**
 * Created by luchunyang on 2016/10/31.
 */
public class HashMapDemo {

    public static void main(String[] args) {

        //线程不安全
        HashMap<String,String> hashMap = new HashMap<>(10,0.75f);
        hashMap.put("one","员工1");
        hashMap.put("two","员工2");
        hashMap.put("three","员工3");
        hashMap.put("four","员工4");
        hashMap.put("five","员工5");
        System.out.println(hashMap.toString());

//        hashMap.clear();
        System.out.println(hashMap.size());

    }
}
