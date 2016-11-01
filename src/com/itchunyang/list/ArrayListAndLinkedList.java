package com.itchunyang.list;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by luchunyang on 2016/10/28.
 *
 * 总结
 * 1、顺序插入速度ArrayList会比较快，因为ArrayList是基于数组实现的，数组是事先new好的，只要往指定位置塞一个数据就好了；
 *    LinkedList则不同，每次顺序插入的时候LinkedList将new一个对象出来，如果对象比较大，那么new的时间势必会长一点，
 *    再加上一些引用赋值的操作，所以顺序插入LinkedList必然慢于ArrayLis
 *
 * 2、基于上一点，因为LinkedList里面不仅维护了待插入的元素，还维护了Entry的前置Entry和后继Entry，如果一个LinkedList中的Entry非常多，那么LinkedList将比ArrayList更耗费一些内存
 *
 *
 * 4、有些说法认为LinkedList做插入和删除更快，这种说法其实是不准确的：
 *  （1）LinkedList做插入、删除的时候，慢在寻址，快在只需要改变前后Entry的引用地址
 *  （2）ArrayList做插入、删除的时候，慢在数组元素的批量copy，快在寻址
 *
 *  所以，如果待插入、删除的元素是在数据结构的前半段尤其是非常靠前的位置的时候，LinkedList的效率将大大快过ArrayList，因为ArrayList将批量copy大量的元素；
 *  越往后，对于LinkedList来说，因为它是双向链表，所以在第2个元素后面插入一个数据和在倒数第2个元素后面插入一个元素在效率上基本没有差别，但是ArrayList由于要批量copy的元素越来越少，操作速度必然追上乃至超过LinkedList。
 *
 *  从这个分析看出，如果你十分确定你插入、删除的元素是在前半段，那么就使用LinkedList；如果你十分确定你删除、删除的元素在比较靠后的位置，那么可以考虑使用ArrayList。
 *  如果你不能确定你要做的插入、删除是在哪儿呢？那还是建议你使用LinkedList吧，因为一来LinkedList整体插入、删除的执行效率比较稳定，没有ArrayList这种越往后越快的情况；
 *  二来插入元素的时候，弄得不好ArrayList就要进行一次扩容，记住，ArrayList底层数组扩容是一个既消耗时间又消耗空间的操作。
 *
 */
public class ArrayListAndLinkedList {


    public static void main(String[] args) {
//        testAdd();
//        testAdd1();
    }

    /**
     * 头部添加LinkedList快
     * ArrayList添加时会逐个向后移动List.size() - index 个元素耗费大量的时间
     *
     * NUM = 100000
     *      ArrayList spend = 1125
     *      LinkedList spend = 12
     *
     * NUM = 300000
     *      ArrayList spend = 9546
     *      LinkedList spend = 17
     */
    private static void testAdd1() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        int NUM = 300000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            arrayList.add(0,i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList spend = " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            linkedList.add(0,i);
            //linkedList.addFirst(i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList spend = " + (end - start));

    }

    /**
     * 尾部添加ArrayList和LinkedList需要的时间都是常数时间
     *  但是一般来说ArrayList更快
     *
     * NUM = 18000000
     *      ArrayList spend = 4571
     *      LinkedList spend = 13120
     *
     * NUM = 12000000
     *      ArrayList spend = 4168
     *      LinkedList spend = 5462
     *
     * NUM = 8000000
     *      ArrayList spend = 2628
     *      LinkedList spend = 1472
     *
     * NUM = 6000000
     *      ArrayList spend = 1445
     *      LinkedList spend = 3013
     *
     * NUM = 1000000
     *      ArrayList spend = 39
     *      LinkedList spend = 179
     */
    private static void testAdd() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        int NUM = 18000000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList spend = " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            linkedList.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList spend = " + (end - start));
    }
}
