package com.eichinn.generics.example;

public class ClassTypeCapture<T> {
    private Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);

    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctc1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctc1.f(new Building()));
        System.out.println(ctc1.f(new House()));

        ClassTypeCapture<House> ctc2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctc2.f(new Building()));
        System.out.println(ctc2.f(new House()));
    }
}

class Building {

}

class House extends Building {

}
