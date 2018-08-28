package com.eichinn.containers.exercise;

import java.util.*;

public class Ex7 {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> b = new LinkedList<>(Arrays.asList(6, 7, 8, 9, 0));
        Iterator<Integer> ia = a.iterator();
        Iterator<Integer> ib = b.iterator();
        while (ia.hasNext()) {
            System.out.print(ia.next() + " ");
        }
        System.out.println();
        while (ib.hasNext()) {
            System.out.print(ib.next() + " ");
        }
        System.out.println();

        /*ListIterator<Integer> lla = a.listIterator();
        ListIterator<Integer> llb = b.listIterator();
        while (lla.hasNext() && llb.hasNext()) {
            lla.add(llb.next());
            lla.next();
        }
        System.out.println(a);*/

        ListIterator<Integer> lla = a.listIterator(a.size());
        ListIterator<Integer> llb = b.listIterator();
        while (lla.hasPrevious() && llb.hasNext()) {
            lla.add(llb.next());
            lla.previous();
//            lla.previous();
            System.out.println(a);
        }
        System.out.println(a);
    }
}
