package com.itchunyang.map;

import java.util.*;

/**
 * Created by luchunyang on 2016/10/28.
 */
public class HashTableDemo {

    public static void main(String[] args) {

        String s1 = new String("abc");
        String s2 = new String("abc");
        //如果根据 equals(Object) 方法，两个对象是相等的，那么在两个对象中的每个对象上调用 hashCode 方法都必须生成相同的整数结果。
        System.out.println(s1.hashCode() + " | " + s2.hashCode());

        //key value 都不可为null.线程安全!
        Hashtable<String, Staff> hashtable = new Hashtable<>(10, 0.75f);
        hashtable.put("one", new Staff(1001, "员工1"));
        hashtable.put("two", new Staff(1002, "员工2"));
        hashtable.put("three", new Staff(1003, "员工3"));
        hashtable.put("four", new Staff(1004, "员工4"));

        //遍历 1
        System.out.println("\n--------------遍历方式1--------------");
        Set<String> keySet = hashtable.keySet();
        for (String key : keySet) {
            System.out.println(key + "=" + hashtable.get(key));
        }

        //遍历 2
        System.out.println("\n--------------遍历方式2--------------");
        Collection<Staff> values = hashtable.values();
        System.out.println(values.toString());

        //遍历 3
        System.out.println("\n--------------遍历方式3--------------");
        Set<Map.Entry<String, Staff>> entries = hashtable.entrySet();
        for (Map.Entry<String, Staff> entry : entries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    static class Staff {
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
    }
}
