package com.eichinn.generics.example;

public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();

        C c = new C();
        c.setAndGet(new C());
    }

    //SelfBoundedMethod
    public <T extends SelfBounded<T>> T f(T arg) {
        return arg.set(arg).get();
    }
}

class SelfBounded<T extends SelfBounded<T>> {
    T element;
    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A extends SelfBounded<A> {} //selfBounded
class B extends SelfBounded<A> {} // Also OK, because A extends SelfBounded<A>

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D {}
//Can't do this, type parameter D is not with its bound
//class E extends SelfBounded<D> {}
//Also, you can do this, so you can't force the idiom
class F extends SelfBounded {}