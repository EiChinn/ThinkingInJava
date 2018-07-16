package com.eichinn.generics.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ByteSet {
    Byte[] possible = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Set<Byte> mySet = new HashSet<Byte>(Arrays.asList(possible));
    //But you can't do this
//    Set<Byte> mySet2 = new HashSet<Byte>(Arrays.<Byte>asList({1, 2, 3, 4, 5, 6, 7, 8, 9}));
}
