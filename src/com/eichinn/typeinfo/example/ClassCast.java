package com.eichinn.typeinfo.example;

public class ClassCast {
    public static void main(String[] args) {
        Building building = new House();
        Class<House> houseType = House.class;
        House house = houseType.cast(building);
        //or just do this
        house = (House) building;


//        Class<? extends Building> subClass = houseType;
//        subClass = houseType.asSubclass(Building.class);
    }
}

class Building {

}

class House extends Building {

}
