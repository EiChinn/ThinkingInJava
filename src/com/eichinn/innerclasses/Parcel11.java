package com.eichinn.innerclasses;

/**
 * Created by ei_chinn on 2017/2/6.
 */
public class Parcel11 {
    private static class ParcelContents implements Contents {
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {
        private String label;
        private ParcelDestination(String label) {
            this.label = label;
        }
        @Override
        public String readLabel() {
            return label;
        }

        //Nested classes can contain other static elements
        //普通内部类不能有static字段或static方法，也不能包含嵌套类（static内部类），可以把ParcelDestination类声明中的static去掉，会有编译错误
        //而嵌套类（static内部类）则可以有static字段、static方法，和继续包含嵌套类（static内部类）
        static int x = 10;

        static void f() {

        }

        static class AnotherLevel {
            public static void f() {

            }
            static int x = 10;
        }

    }

}
