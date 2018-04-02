package com.eichinn.generics.example;

//{CompileTimeError} (won't compile)
public class NonCovariantGenerics {
    //Compile Error: incompatible types
    //!List<Fruit> flist = new ArrayList<Apple>();
}
