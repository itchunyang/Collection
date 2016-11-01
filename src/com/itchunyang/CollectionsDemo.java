package com.itchunyang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by luchunyang on 2016/11/1.
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        ArrayList<Staff> arrayList = new ArrayList<>();
        arrayList.add(new Staff(1,"员工[1]"));
        arrayList.add(new Staff(3,"员工[3]"));
        arrayList.add(new Staff(5,"员工[5]"));
        arrayList.add(new Staff(2,"员工[2]"));
        arrayList.add(new Staff(4,"员工[4]"));

        Collections.sort(arrayList);
//        Collections.sort(arrayList, new Comparator<Staff>() {
//            @Override
//            public int compare(Staff o1, Staff o2) {
//                return 0;
//            }
//        });
        System.out.println(arrayList.toString());
        int index = Collections.binarySearch(arrayList,new Staff(3,"员工3"));
        System.out.println("find index = "+ index);
        //Collections.EMPTY_LIST.add("1");

        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        list.add("hello");
        list.add("java");
        System.out.println(list.toString());

        Collections.fill(list,"fill");
        System.out.println(list.toString());

        System.out.println("min:"+Collections.min(arrayList));

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Staff)) return false;

            Staff staff = (Staff) o;

            if (id != staff.id) return false;
            return name != null ? name.equals(staff.name) : staff.name == null;

        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }
}
