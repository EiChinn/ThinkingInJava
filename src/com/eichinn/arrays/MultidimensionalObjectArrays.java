package com.eichinn.arrays;

import com.eichinn.common.CountedInteger;

import java.util.Arrays;

public class MultidimensionalObjectArrays {
    public static void main(String[] args) {
        CountedInteger[][] counter = {
                {new CountedInteger(), new CountedInteger()},
                {new CountedInteger(), new CountedInteger(),
                        new CountedInteger(), new CountedInteger(), },
                {new CountedInteger(), new CountedInteger(),
                        new CountedInteger(), new CountedInteger(),
                        new CountedInteger(), new CountedInteger(),
                        new CountedInteger(), new CountedInteger(), }

        };
        System.out.println(Arrays.deepToString(counter));
    }
}
