package com.itchunyang.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by luchunyang on 2016/10/31.
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {
        //它保留插入的顺序，如果需要输出的顺序和输入时的相同，那么就选用LinkedHashMap。
        //默认是按照插入顺序排序，也可以按照访问顺序排序
        //LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>(10,0.75f);
        LinkedHashMap linkedHashMap = new LinkedHashMap<>(5,0.75f,true);
        linkedHashMap.put("one","员工1");
        linkedHashMap.put("two","员工2");
        linkedHashMap.put("three","员工3");
        linkedHashMap.put("four","员工4");
        linkedHashMap.put("five","员工5");
        linkedHashMap.put("six","员工6");
        linkedHashMap.get("four");//如果指定按访问顺序排序，那么调用get方法后，会将这次访问的元素移至链表尾部
        System.out.println(linkedHashMap.toString());

        System.out.println("\n---------------------\n");
        /**
         * 如果removeEldestEntry返回true，那么LinkedHashMap会自动删掉最不常用的那个entry（也就是header线性表最前面的那个）。
         */
        int MAXSIZE = 5;
        linkedHashMap = new LinkedHashMap(15,0.75f,true){
            //定义put后的移除规则，大于容量就删除eldest
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                System.out.println("eldest:"+eldest.getValue());
                if(size() > MAXSIZE)
                    return true;
                else
                    return false;
            }
        };
        linkedHashMap.put("one","员工1");
        linkedHashMap.put("two","员工2");
        linkedHashMap.put("three","员工3");
        linkedHashMap.get("two");
        linkedHashMap.put("four","员工4");
        linkedHashMap.put("five","员工5");
        linkedHashMap.put("six","员工6");
        linkedHashMap.put("seven","员工7");

        System.out.println(linkedHashMap.toString());
    }
}
