package com.eichinn.generics.example;

import com.eichinn.typeinfo.example.pets.Cat;
import com.eichinn.typeinfo.example.pets.Dog;
import com.eichinn.typeinfo.example.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {
    @SuppressWarnings("unchecked")
    private static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1); // Quietly accepts a cat, 将cat从list取出来的时候才会抛出异常

        List<Dog> dogs2 = Collections.checkedList(new ArrayList<>(), Dog.class);
        try {
            oldStyleMethod(dogs2); // Throws an exception， 将cat插入list的时候就会抛出异常
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        //Derived types work fine
        List<Pet> pets = Collections.checkedList(new ArrayList<>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Pet());
    }




}
