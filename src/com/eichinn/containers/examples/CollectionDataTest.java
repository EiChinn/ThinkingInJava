package com.eichinn.containers.examples;

import com.eichinn.common.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Government(), 15));
        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);
    }
}

class Government implements Generator<String> {
    String[] foundation = "strange women lying in ponds distributing swords is no basis for a system of government"
            .split(" ");
    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}
