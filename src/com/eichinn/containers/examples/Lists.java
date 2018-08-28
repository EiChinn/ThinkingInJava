package com.eichinn.containers.examples;

import com.eichinn.common.Countries;

import java.util.*;

/**
 * Things you can do with lists
 */
public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void baseTest(List<String> a) {
        a.add(1, "x"); // add at location 1
        a.add("x"); // add at end
        // add a collection
        a.addAll(Countries.names(25));
        // add a collection starting at location 3
        a.addAll(3, Countries.names(25));
        b = a.contains("1"); // is it in there
        // is the entire collection in there
        b = a.containsAll(Countries.names(25));
        // Lists allow random access, which is cheap for ArrayList, expensive for LinkedList
        s = a.get(1); // get (typed) object at location 1
        i = a.indexOf("1"); // tell index of object
        b = a.isEmpty(); // any elements inside?
        it = a.iterator(); // ordinary iterator
        lit = a.listIterator(); // list iterator
        lit = a.listIterator(3); // start at location 3
        i = a.lastIndexOf("1"); // last match
        a.remove(1); // remove location 1
        a.remove("1"); // remove this object
        a.set(1, "y"); // set location 1 to y
        // keep everything that's in the argument(the intersetion of the two sets)
        a.retainAll(Countries.names(25));
        // remove everything that's in the argument
        a.removeAll(Countries.names(25));
        i = a.size(); // how big is it?
        a.clear(); // remove all elements

    }

    public static void iterMotion(List<String> a) {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }

    public static void iterManipulation(List<String> a) {
        ListIterator<String> it = a.listIterator();
        it.add("47");
        // Must move to an element after add()
        it.next();
        // Remove the element after the newly produced one
        it.remove();
        // Must move to an element after remove()
        it.next();
        // Change the element after the deleted one
        it.set("47");
    }

    public static void testVisual(List<String> a) {
        System.out.println(a);
        List<String> b = Countries.names(5);
        System.out.println("b = " + b);
        a.addAll(b);
        a.addAll(b);
        System.out.println(a);
        // Insert, remove, and replace elements using a listIterator
        ListIterator<String> x = a.listIterator(a.size() / 2);
        x.add("one");
        System.out.println(a);
        System.out.println(x.next());
        x.remove();
        System.out.println(x.next());
        x.set("47");
        System.out.println(a);
        // Traverse the list backwards:
        x = a.listIterator(a.size());
        while (x.hasPrevious()) {
            System.out.print(x.previous() + " ");
        }
        System.out.println();
        System.out.println("testVisual finished");


    }

    // There are somethings that only LikedLists can do
    public static void testLinkedList() {
        LinkedList<String> ll = new LinkedList<>();
        ll.addAll(Countries.names(5));
        System.out.println(ll);
        // Treat it like a stack, pushing
        ll.addFirst("one");
        ll.addFirst("two");
        System.out.println(ll);
        // Like "peeking" at the top of a stack
        System.out.println(ll.getFirst());
        // Like poping a stack
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeFirst());
        // Treat it like a queue, pulling elements off the tail end
        System.out.println(ll.removeLast());
        System.out.println(ll);

    }

    public static void main(String[] args) {
        // Make and fill a new list each time
        baseTest(new LinkedList<>(Countries.names(25)));
        baseTest(new ArrayList<>(Countries.names(25)));
        iterMotion(new LinkedList<>(Countries.names(25)));
        iterMotion(new ArrayList<>(Countries.names(25)));
        iterManipulation(new LinkedList<>(Countries.names(25)));
        iterManipulation(new ArrayList<>(Countries.names(25)));
        testVisual(new ArrayList<>(Countries.names(5)));
        testLinkedList();

    }
}
