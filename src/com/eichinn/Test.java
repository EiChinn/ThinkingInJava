package com.eichinn;

import java.util.ArrayList;
import java.util.List;

public class Test {
    static class People {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "People{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        byte[] data = {(byte)0x00, (byte)0xa1};
        System.out.println(calculateTestValue(data));
        /*List<People> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            People people = new People();
            people.setName(i + "");
            list.add(people);
        }

        List<People> list1 = new ArrayList<>(list);
        People people = new People();
        people.setName("ei_chinn");
        list1.set(0, people);
        System.out.println("list: " + list);
        System.out.println("list1: " + list1);*/

    }

    private static void change(List<String> arg) {
        List<String> tem = new ArrayList<>();
        tem.add("change");
        System.out.println("Before: " + arg);
        arg = tem;
        System.out.println("After: " + arg);
    }





    private static double calculateTestValue(byte[] data) {
        double result = 0.0;
        String hexString = bytesToHexString(data);
        if (hexString != null && !"".equals(hexString)) {
            result = Integer.parseInt(hexString, 16) / 100.0;
        }
        return result;
    }

    private static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

}
