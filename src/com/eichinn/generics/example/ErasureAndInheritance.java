package com.eichinn.generics.example;

public class ErasureAndInheritance {
    public static void main(String[] args) {
        Derived2 derived2 = new Derived2();
        Object obj = derived2.getElement();
        derived2.setElement(obj);//Unchecked call to 'setElement(T)' as a member of raw type 'GenericBase'
    }
}

class GenericBase<T> {
    private T element;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}

class Derived1<T> extends GenericBase<T> {

}

class Derived2 extends GenericBase {//No warning

}

//class Derived3 extends GenericBase<?> { } //Error: no wildcard expected


