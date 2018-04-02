package com.eichinn.generics.example;

public class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple a = apple.get();
        apple.set(a);

        //!Holder<Fruit> fruit = apple; //Can not upcast
        Holder<? extends Fruit> fruit = apple;
        Fruit f = fruit.get();
        a = (Apple) fruit.get();// returns '? extend Fruit'


        try {
            Orange o = (Orange) fruit.get();
        } catch (Exception e) {
            System.out.println(e);
        }

        //!fruit.set(new Apple());//Can not call set
        //!fruit.set(new Fruit());//Can not call set

        System.out.println(fruit.equals(a));

    }
}
