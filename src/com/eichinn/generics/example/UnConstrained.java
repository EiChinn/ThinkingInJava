package com.eichinn.generics.example;

public class UnConstrained {
    public static void main(String[] args) {
        BasicOther b = new BasicOther(), b2 = new BasicOther();
        b.set(new Other());
        Other other = b.get();
        b.f();
    }
}

class Other{}

class BasicOther extends BasicHolder<Other> {

}
