package com.eichinn.containers.exercise;

import java.util.NoSuchElementException;

public class Ex8 {
    public static void main(String[] args) {
        SList<String> sList = new SList<>();
        SListIterator<String> sListIterator = sList.iterator();
        System.out.println(sList);

        sListIterator.add("Hello");
        System.out.println(sList);
    }
}

class SList<E> {

    public SListIterator<E> iterator() {
        return new SListIterator<E>();
    }

    @Override
    public String toString() {
        SListIterator<E> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }
}

class SListIterator<E> {
    private Node<E> currentNode;
    private Node<E> previousNode;

    public SListIterator() {
        currentNode = new Node<>(null, null);
    }

    public boolean hasNext() {
        return currentNode.next != null;
    }

    public E next() {
        if (hasNext()) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            return currentNode.item;
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * add element after current element
     * @param element
     */
    public void add(E element) {
        Node<E> node = new Node<>(element, currentNode.next);
        currentNode.next = node;
    }

    public void remove() {
        if (previousNode != null) {
            previousNode.next = currentNode.next;
            previousNode = null;
        }
    }
}

class Node<E> {
    E item;
    Node<E> next;

    Node(E element, Node<E> next) {
        this.item = element;
        this.next = next;
    }
}


