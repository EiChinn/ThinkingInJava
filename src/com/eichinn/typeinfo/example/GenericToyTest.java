package com.eichinn.typeinfo.example;

public class GenericToyTest {
    public static void main(String[] args) {
        Class<FancyToy> ftClass = FancyToy.class;
        //Produce exact type;
        try {
            FancyToy fancyToy = ftClass.newInstance();
            Class<? super FancyToy> up = ftClass.getSuperclass();
            //This won't compile
//            Class<Toy> up2 = ftClass.getSuperclass();
            //Only produces object:
            Object obj = up.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
