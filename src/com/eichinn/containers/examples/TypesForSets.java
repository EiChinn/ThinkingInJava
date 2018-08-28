package com.eichinn.containers.examples;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *  Methods necessary to put you own type in a set
 */
public class TypesForSets {

    static <T> Set<T> fill(Set<T> set, Class<T> type) {
        try {
            for (int i = 0; i < 10; i++) {
                set.add(type.getConstructor(int.class).newInstance(i));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return set;
    }

    static <T> void test(Set<T> set, Class<T> type) {
        fill(set, type);
        fill(set, type); // Try to set duplicates
        fill(set, type);
        System.out.println(set);
    }

    public static void main(String[] args) {
        test(new HashSet<>(), HashType.class);
        test(new LinkedHashSet<>(), HashType.class);
        test(new TreeSet<>(), TreeType.class);
        // Things that don't work
        test(new HashSet<>(), SetType.class); // have not override hashCode()
        test(new HashSet<>(), TreeType.class); // have not override hashCode()
        test(new LinkedHashSet<>(), SetType.class); // have not override hashCode()
        test(new LinkedHashSet<>(), TreeType.class); // have not override hashCode()

        try {
            test(new TreeSet<>(), SetType.class); // have not implement Comparable interface
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            test(new TreeSet<>(), HashType.class); // have not implement Comparable interface
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

class SetType {
    int i;

    public SetType(int n) {
        this.i = n;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SetType && this.i == ((SetType)obj).i;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

class HashType extends SetType {

    public HashType(int n) {
        super(n);
    }

    @Override
    public int hashCode() {
        return this.i;
    }
}

class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int n) {
        super(n);
    }

    @Override
    public int compareTo(TreeType o) {
        // 不能简单的 return this.i - o.i, 这是一个常见的编程错误，它只有在o.i 和 this.i都是无符号的int时才能正常工作，
        // 如果i是很大的正数，j是很小的负数， i - j 就会溢出并且返回负值，这就不正确了
        return o.i < i ? -1 : (o.i == i ? 0 : 1);
    }
}
