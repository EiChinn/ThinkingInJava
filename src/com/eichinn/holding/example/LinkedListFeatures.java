package com.eichinn.holding.example;

import java.util.LinkedList;

/**
 * Created by ei_chinn on 2017/3/7.
 */
public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<>(Pets.arrayList(7));
        System.out.println(pets);

        //identical
        System.out.println("pets.getFirst(): " + pets.getFirst());
        System.out.println("pets.element(): " + pets.element());
        //only differs in empty-list behavior 前面两个方法在对empty list操作时会抛出异常，下面的方法会返回null
        System.out.println("pets.peek(): " + pets.peek());

        //identical: remove and return the first element
        System.out.println("pets.remove(): " + pets.remove());
        System.out.println("pets.removeFirst(): " + pets.removeFirst());
        //only differs in empty-list behavior 前面两个方法在对empty list操作时会抛出异常，下面的方法会返回null
        System.out.println("pets.poll(): " + pets.poll());
        System.out.println(pets);

        pets.addFirst(new Mouse());
        System.out.println("After addFirst(): " + pets);

        pets.add(new Mouse());
        System.out.println("After add(): " + pets);
        pets.offer(new Pug());
        System.out.println("After offer(): " + pets);
        pets.addLast(new Pug());
        System.out.println("After addLast(): " + pets);

        System.out.println("pets.removeLast(): " + pets.removeLast());

    }
}
