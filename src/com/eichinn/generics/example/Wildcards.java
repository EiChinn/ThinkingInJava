package com.eichinn.generics.example;

/**
 * Exploring the meaning of wildcards
 */
public class Wildcards {
    //Raw argument
    static void rawArgs(Holder holder, Object arg) {
        holder.set(arg);//Unchecked call to 'set(T)' as a member of raw type Holder
        holder.set(new Wildcards());////Unchecked call to 'set(T)' as a member of raw type Holder

        //Can't do this, don't have any 'T'
        //T t = holder.get();

        //OK, but type information has been lost
        Object obj = holder.get();
    }

    //Similar to rawArgs(), but errors instead of warnings
    static void unboundedArg(Holder<?> holder, Object arg) {
        //holder.set(arg);//Error: set(capture<?>) in Holder can not be applied to Object
        //holder.set(new Wildcards());//Error: set(capture<?>) in Holder can not be applied to Wildcards

        //Can't do this, don't have any 'T'
        //T t = holder.get();

        //OK, but type information has been lost
        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        //holder.set(arg);//Error: set(capture<? extends T>) in Holder can not be applied to (T)
        T t = holder.get();
        return t;
    }

    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);

        //T t = holder.get();//Error: Incompatible types.Required T, found capture<? super T>

        //OK, but type information has bean lost
        Object obj = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        //Or:
        raw = new Holder();

        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1l;

        //对于迁移兼容性，rawArgs将接受所有Holder的不同变体，而不会产生警告
        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        //unbounded也可以接受所有Holder的不同变体，但它与rawArgs方法内部处理这些类型的方式并不相同
        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        //向接受“确切”泛型类型(没有通配符）的方法传递一个原生Holder引用，就会得到一个警告，因为确切的参数期望得到在原生类型中并不存在的信息
        Object r1 = exact1(raw);//Unchecked assignment:Holder to Holder<Object>
        Long r2 = exact1(qualified);
        //向接受“确切”泛型类型（没有通配符）的方法传递一个无界引用，就不会有任何可以确定返回类型的类型信息
        Object r3 = exact1(unbounded);
        Long r4 = exact1(bounded);

        Long r5 = exact2(raw, lng);//Unchecked assignment: Holder to Holder<Object>
        Long r6 = exact2(qualified, lng);
        //Long r7 = exact2(unbounded, lng);//Error:exact2(Holder<T>, T) in Wildcards can not be applied to (Holder<capture<?>>, Long)
        //Long r8 = exact2(bounded, lng);//Error:exact2(Holder<T>, T) in Wildcards can not be applied to (Holder<capture<? extends Long>>, Long)


        Long r9 = wildSubtype(raw, lng);//Unchecked assignment: Holder to Holder<? extends Long>
        Long r10 = wildSubtype(qualified, lng);
        //OK, but can only return Object
        Object r11 = wildSubtype(unbounded, lng);
        Long r12 = wildSubtype(bounded, lng);

        wildSupertype(raw, lng);//Unchecked assignment: Holder to Holder<? super Long>
        wildSupertype(qualified, lng);
        //wildSupertype(unbounded, lng);//Error: wildSupertype(Holder<? super T>, T) can not be applied to (Holder<capture<?>>, Long)
        //wildSupertype(bounded, lng);//Error: wildSupertype(Holder<? super T>, T) can not be applied to (Holder<capture<? extends Long>>, Long)


    }
}
