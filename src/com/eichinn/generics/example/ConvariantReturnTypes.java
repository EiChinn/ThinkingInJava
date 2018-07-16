package com.eichinn.generics.example;

public class ConvariantReturnTypes {
    void test(DerivedGetter derivedGetter) {
        Derived d = derivedGetter.get();
    }
}

class Base {}
class Derived extends Base {}
interface OrdinaryGetter {
    Base get();
}
interface DerivedGetter extends OrdinaryGetter {
    // Return type of overridden method is allow to vary
    Derived get();
}