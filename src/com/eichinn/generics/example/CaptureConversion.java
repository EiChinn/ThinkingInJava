package com.eichinn.generics.example;

public class CaptureConversion {
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        //参数类型在调用f2的过程中被捕获，因此它（被捕获的确切的参数类型）可以在对f1的调用中使用
        //注意不能从f2中返回T，因为T对于f2来说是未知的
        f1(holder);//Call with captured type
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);//注意声明类型为原生类型Holder，所以下面这行代码才会有Warning
        f1(raw);//Unchecked assignment: Holder to Holder<Object>
        f2(raw);

        Holder rawBasic = new Holder();
        rawBasic.set(new Object());//Unchecked call to 'set(T)' as a member of raw type Holder
        f1(rawBasic);//Unchecked assignment: Holder to Holder<Object>
        f2(rawBasic);

        //Upcast to Holder<?>, still figure it out
        Holder<?> wildcarded = new Holder<Double>(1.0);
        f1(wildcarded);
        f2(wildcarded);
    }
}
