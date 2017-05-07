package com.eichinn.typeinfo.example;

/**
 * Examination of the way the class loader works
 * Created by ei_chinn on 2017/5/7.
 */
public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("com.eichinn.typeinfo.example.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");

    }
}

class Candy {
    static {
        System.out.println("loading Candy");
    }
}
class Gum {
    static {
        System.out.println("loading Gum");
    }
}
class Cookie {
    static {
        System.out.println("loading Cookie");
    }
}
