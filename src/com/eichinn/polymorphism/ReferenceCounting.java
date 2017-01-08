package com.eichinn.polymorphism;

/**
 * Created by ei_chinn on 2017/1/8.
 */
public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composings = {new Composing(shared), new Composing(shared), new Composing(shared), new Composing(shared), new Composing(shared), };
        for (Composing composing : composings) {
            composing.dispose();
        }

        // Test finalize():
        Composing compTest = new Composing(shared);
        Composing compest2 = new Composing(shared);
        try {
            shared.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Shared sharedTest = new Shared();
        Composing compTest3 = new Composing(sharedTest);
        try {
            sharedTest.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}

class Shared {
    private int refCount = 0;//用于跟踪共享对象的引用数量，可增可减
    private static long counter = 0;//用于id，跟踪所创建的实例的数量，只增不减
    private final long id = counter++;
    public Shared() {
        System.out.println("Creating " + this);
    }
    public void addRef() {
        refCount++;
    }

    @Override
    protected void finalize() throws Throwable {
        if (refCount > 0) {
            System.err.println("Error: " + refCount + " Shared " + id + " objects in use");
        }
    }

    protected void dispose() {
        if (--refCount == 0) {
            System.out.println("Disposing " + this);
        }
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    public Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }
    protected void dispose() {
        System.out.println("disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }
}
