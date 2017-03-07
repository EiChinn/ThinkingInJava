package com.eichinn.holding.example;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by ei_chinn on 2017/3/6.
 */
public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(7);

        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext()) {
//            System.out.println(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex());
            //it.next之后并不是指向下一个元素，而是指在最后访问过的元素之后，下一个元素之前，即指在两个元素之间，
            System.out.print(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
        }
        System.out.println();

        //backwards
        it = pets.listIterator(pets.size());
        while (it.hasPrevious()) {
            System.out.print(it.previous() + " ");
        }
        System.out.println();

        System.out.println(pets);
        it = pets.listIterator(3);
        while (it.hasNext()) {
            it.next();
            it.set(new Mouse());
        }
        System.out.println(pets);
    }
}
