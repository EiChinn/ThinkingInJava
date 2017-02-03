package com.eichinn.innerclasses;

/**
 * Created by ei_chinn on 2017/2/2.
 */
public class TestParcel {

    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        Destination destination = parcel.destination("Tasmania");
        Contents contents = parcel.contents();

        Parcel.PDestination destination1 = (Parcel.PDestination) parcel.destination("test");

        Parcel.PDestination pDestination = parcel.new PDestination("test");
//        Parcel.PContents pContents = p.new PContents();
    }
}

interface Destination {
    String readLabel();
}

interface Contents {
    int value();
}

class Parcel {
    /**
     * private内部类给类的设计者提供了一种途径：通过这种方式可以完全阻止任何依赖于类型的编码，并且完全隐藏了实现的细节。
     * 此外，从客户端程序员的角度来看，由于不能访问任何新增加的、原本不属于公共接口的方法，所以扩展接口是没有价值的。这也给java编译器提供了生成更高效代码的机会。
     */
    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;

        public PDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }

    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }

}
