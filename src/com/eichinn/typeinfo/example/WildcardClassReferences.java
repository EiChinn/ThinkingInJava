package com.eichinn.typeinfo.example;

public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
        //        Class<Number> genericNumberClass = int.class; //Class<Integer> is not the subclass of Class<Number>, thought int is the subclass of Number
        Class<? extends Number> genericNumberClass = int.class;
        genericNumberClass = double.class;
        genericNumberClass = Number.class;
    }
}
