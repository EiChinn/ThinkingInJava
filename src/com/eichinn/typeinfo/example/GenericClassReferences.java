package com.eichinn.typeinfo.example;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;//Same thing
        intClass = double.class;
//        genericIntClass = double.class;//Illegal
//        Class<Number> genericNumberClass = int.class; //Class<Integer> is not the subclass of Class<Number>, thought int is the subclass of Number
    }
}
