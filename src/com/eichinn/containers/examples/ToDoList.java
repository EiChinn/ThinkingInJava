package com.eichinn.containers.examples;

import java.util.PriorityQueue;

/**
 *  A more complex use of PriorityQueue
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
    static class ToDoItem implements Comparable<ToDoItem> {
        private String item;
        private char primary;
        private int secondary;

        public ToDoItem(String item, char primary, int secondary) {
            this.item = item;
            this.primary = primary;
            this.secondary = secondary;
        }

        @Override
        public int compareTo(ToDoItem o) {
            if (this.primary > o.primary) {
                return +1;
            }
            if (this.primary == o.primary) {
                if (this.secondary > o.secondary) {
                    return +1;
                } else if (this.secondary == o.secondary) {
                    return 0;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(primary) + secondary + ": " + item;
        }
    }

    public boolean add(String item, char primary, int secondary) {
        return super.add(new ToDoItem(item, primary, secondary));
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add("Empty trash", 'C', 4);
        toDoList.add("Feed dog", 'A', 2);
        toDoList.add("Feed bird", 'B', 7);
        toDoList.add("Mow lawn", 'C', 3);
        toDoList.add("Water lawn", 'A', 1);
        toDoList.add("Feed cat", 'B', 1);
        while (!toDoList.isEmpty()) {
            System.out.println(toDoList.remove());
        }

    }
}
