package com.eichinn.generics.example;

public class OrdinaryArguments {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedSetter ds = new DerivedSetter();
        ds.set(derived);
        ds.set(base); // Compiles: overloaded, not overridden
    }
}

class OrdinarySetter {
    void set(Base base) {
        System.out.println("OrdinarySetter.set(Base)");
    }
}
class DerivedSetter extends OrdinarySetter {
    // Overload, not override
    void set(Derived derived) {
        System.out.println("DerivedSetter.set(Derived");

    }
}
