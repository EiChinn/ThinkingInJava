package com.eichinn.generics.example;

/*
A stack implemented with an internal linked structure
 */
public class LinkedStack<T> {
    private Node top = new Node();//End sentinel

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    private class Node {
        T item;
        Node next;

        public Node() {
            this(null, null);
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }


    public static void main(String[] args) {
        LinkedStack<String> lls = new LinkedStack<>();
        String str = "Phasers or stun!";
        for (String s : str.split(" ")) {
            lls.push(s);
        }
        String s;
        while ((s = lls.pop()) != null) {
            System.out.println(s);
        }

    }
}
