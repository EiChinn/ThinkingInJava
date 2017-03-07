package com.eichinn.holding.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ei_chinn on 2017/3/2.
 */
public class Pets {
    public static List<Pet> arrayList(int num) {
        List<Pet> pets = new ArrayList<>();
        Collections.addAll(pets, new Rat(), new Manx(), new Cymric(), new Mutt(), new Pug(), new Cymric(), new Pug());
        return pets;
    }
}

class Pet implements Comparable<Pet>{
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int compareTo(Pet o) {
        return this.getClass().getSimpleName().compareTo(o.getClass().getCanonicalName());
    }
}

class Rat extends Pet {}
class Manx extends Pet {}
class Cymric extends Pet {}
class Mutt extends Pet {}
class Pug extends Pet {}
class Hamster extends Pet {}
class Mouse extends Pet {}
class EgyptianMau extends Pet {}
