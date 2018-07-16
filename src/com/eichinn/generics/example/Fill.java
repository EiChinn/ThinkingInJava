package com.eichinn.generics.example;

import com.eichinn.common.Generator;
import com.eichinn.generics.example.coffee.Coffee;
import com.eichinn.generics.example.coffee.Latte;
import com.eichinn.generics.example.coffee.Mocha;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Fill {
    // ClassToken version
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    // Generator version
    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }

    public static void main(String[] args) {
        // adapt a collection
        List<Coffee> carrier = new ArrayList<>();
        fill(new AddableCollectionAdapter<>(carrier), Coffee.class, 3);

        // Helper method captures the type
        fill(Adapter.collectionAdapter(carrier), Latte.class, 2);

        for (Coffee coffee : carrier) {
            System.out.println(coffee);
        }
        System.out.println("----------");

        // Use adapted class
        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<>();
        fill(coffeeQueue, Mocha.class, 4);
        fill(coffeeQueue, Latte.class, 1);
        for (Coffee coffee : coffeeQueue) {
            System.out.println(coffee);
        }
    }


}

interface Addable<T> {
    void add(T t);
}

// To adapt a base type, you must use composition.
// Make any collection addable using composition.
class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> collection;

    public AddableCollectionAdapter(Collection<T> collection) {
        this.collection = collection;
    }

    @Override
    public void add(T t) {
        collection.add(t);
    }
}

// A helper to capture the type automatically
class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> collection) {
        return new AddableCollectionAdapter<>(collection);
    }
}

// To adapter a specific type, you can use inheritance.
// Make a SimpleQueue addable using inheritance
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    @Override
    public void add(T t) {
        super.add(t);
    }
}