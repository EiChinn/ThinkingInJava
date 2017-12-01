package com.eichinn.typeinfo.example;

//Testing class Class
interface HasBatteries {

}

interface Waterproof {

}

interface Shoots {

}

class Toy {
    //Comment out the following default constructor  to see NoSuchMethodError from(*1*)
    Toy(){}
    Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}
public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.eichinn.typeinfo.example.FancyToy");

        } catch (ClassNotFoundException e) {
            System.err.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object object = null;
        try {
            object = up.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.err.println("Can't instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.err.println("Can't access");
            System.exit(1);
        }
        printInfo(object.getClass());
    }
}
