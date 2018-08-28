package com.eichinn.arrays;

import java.util.Arrays;

public class MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        //对于基本类型的多维数组，可以通过使用花括号将每个向量分割开来
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(a));
    }
}
