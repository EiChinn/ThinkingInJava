package com.eichinn.typeinfo.example.pets;

import java.util.HashMap;
import java.util.Map;

/**
 * Counts instance of a type family
 */
public class TypeCounter extends HashMap<Class<?>, Integer>{
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object object) {
        Class<?> type = object.getClass();
        if (!baseType.isAssignableFrom(type)) {
            throw new IllegalArgumentException(object + " incorrect type: " + type + ", should be type or subtype of " + baseType);
        }
        countClass(type);
    }

    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass)) {
            countClass(superClass);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("}");
        return result.toString();
    }

    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            System.out.println(pet.getClass().getSimpleName() + " ");
            typeCounter.count(pet);
        }
        System.out.println();
        System.out.println(typeCounter);
    }
}
