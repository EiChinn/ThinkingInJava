package com.eichinn.generics.example;

public class GenericsAndReturnTypes {
    void test(Getter getter) {
        Getter g = getter.get();
        GenericGetter gg = getter.get(); // Also the base type
    }
}

interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}

interface Getter extends GenericGetter<Getter> {

}