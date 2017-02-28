package com.eichinn.holding;

import java.util.*;

/**
 * Adding groups of elements to Collection objects
 * Created by ei_chinn on 2017/2/28.
 */
public class AddingGroups {
    public static void main(String[] args) {
        //Collection构造器可以接受另外一个Collection
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        //可变参数也就是数组
        Integer[] moreInts = {6, 7, 8, 9, 10};
        //collection.addAll要比用构造器接受另外一个Collection快一些
        collection.addAll(Arrays.asList(moreInts));
        // Runs significantly faster, but you can't construct a Collection this way
        //创造一个空的Collection，然后使用Collections.addAll是首选方式
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        // Produces a list "backed by" an array
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99);//OK -- modify an element
        //Arrays.asList方法底层是数组，因此不能调整尺寸，所以这这方式创建的List只能修改，不能增减，否则会抛出运行时异常
//        list.add(21);//Runtime error because the underlying array cannot be resized
    }
}
