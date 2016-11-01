package com.itchunyang.list;

import java.util.*;

/**
 * Created by luchunyang on 2016/10/28.
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(15);
        for (int i = 0; i < 10; i++) {
            arrayList.add(String.valueOf(i));
        }
        travel(arrayList);

        ArrayList<String> list = new ArrayList<String>(5);
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");

        System.out.println("size="+arrayList.size());//实际元素大小
        System.out.println("from index=1 to index=9 : " + arrayList.subList(1,9));

        System.out.print("toArray():");
        //不能直接String[] objects = (String[]) list.toArray();会报错
        Object[] objects = arrayList.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.print(objects[i]+" ");
            if(i==objects.length - 1)
                System.out.println("");
        }

        System.out.print("toArray(T[]a):");
        String[] strings = new String[list.size()];
        strings = arrayList.toArray(strings);
        System.out.println(Arrays.toString(strings));

        //保留集合中共有的元素,如果List集合对象由于调用retainAll方法而发生更改，则返回 true
        System.out.println("arrayList retainAll list : "+arrayList.retainAll(list)+" arrayList="+arrayList);
        ////集合是否完全包含另一个集合
        System.out.println("arrayList containsAll list : "+arrayList.containsAll(list));

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
            //迭代器遍历时不能通过集合添加删除元素
            //list.add("123");
            //list.remove();
            //iterator.remove();//可以这样的
        }

        //比ListIterator比Iterator多了一些方法，Iterator仅仅可以删除
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            String s = listIterator.next();
            listIterator.add("可以添加元素");
        }
        System.out.println(list);
    }

    public static void travel(List<String> list){
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println("");
    }
}
