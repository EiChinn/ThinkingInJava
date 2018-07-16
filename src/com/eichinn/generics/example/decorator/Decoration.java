package com.eichinn.generics.example.decorator;


import java.util.Date;

public class Decoration {
    public static void main(String[] args) {
        TimeStamped t1 = new TimeStamped(new Basic());
        TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));
        t1.getStamp();
        //! t2.getSerialNumber();

        SerialNumbered s1 = new SerialNumbered(new Basic());
        SerialNumbered s2 = new SerialNumbered(new TimeStamped(new Basic()));
        s1.getSerialNumber();
        //! s2.getStamp();
    }

}
class Basic {
    private String value;

    public void set(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}

class Decorator extends Basic {
    protected Basic basic;

    public Decorator(Basic basic) {
        this.basic = basic;
    }

    @Override
    public void set(String value) {
        basic.set(value);
    }

    @Override
    public String get() {
        return basic.get();
    }
}

class TimeStamped extends Decorator {
    private final long timeStamp;

    public TimeStamped(Basic basic) {
        super(basic);
        this.timeStamp = new Date().getTime();
    }

    public long getStamp() {
        return timeStamp;
    }
}

class SerialNumbered extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter++;

    public SerialNumbered(Basic basic) {
        super(basic);
    }

    public long getSerialNumber() {
        return serialNumber;
    }
}
