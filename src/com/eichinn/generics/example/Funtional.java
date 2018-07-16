package com.eichinn.generics.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Funtional {
    // Calls the combiner object on each element to combine it with a running result, which is finally returned
    public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {
        Iterator<T> iterator = seq.iterator();
        if (iterator.hasNext()) {
            T result = iterator.next();
            while (iterator.hasNext()) {
                result = combiner.combine(result, iterator.next());
            }
            return result;
        }
        // if seq is the empty list
        return null; // or thrown exception
    }

    // Take a function and call it on each object in the list, ignoring the return value.
    // The function object may act as a collecting parameter, so it is returned at the end.
    public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
        for (T t : seq) {
            func.function(t);
        }
        return func;
    }

    // Creates a list of results by calling a function object for each object in the list
    public static <R, T> List<R> transform(Iterable<T> seq, UnaryFunction<R, T> func) {
        List<R> result = new ArrayList<>();
        for (T t : seq) {
            result.add(func.function(t));
        }
        return result;
    }

    //Applies a unary predicate to each item in a sequence, and returns a list of items that produce "true"
    public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred) {
        List<T> result = new ArrayList<>();
        for (T t : seq) {
            if (pred.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    // To use the above generic methods, we need to create function objects to adapt to our particular needs:
    static class IntegerAdder implements Combiner<Integer> {
        @Override
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }
    static class BigDecimalAdder implements Combiner<BigDecimal> {
        @Override
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }
    static class BigIntegerAdder implements Combiner<BigInteger> {
        @Override
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }
    static class AtomicLongAdder implements Combiner<AtomicLong> {
        @Override
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }
    static class IntegerSubtracter implements Combiner<Integer> {
        @Override
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }

    // We can even make a UnaryFunction with a "ulp"(Units in the last place)
    static class BigDecimalUlp implements UnaryFunction<BigDecimal, BigDecimal> {

        @Override
        public BigDecimal function(BigDecimal x) {
            return x.ulp();
        }
    }

    static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T> {
        private T bound;

        public GreaterThan(T bound) {
            this.bound = bound;
        }

        @Override
        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }

    static class MultiplyingIntegerCollector implements Collector<Integer> {
        private Integer value = 1;
        @Override
        public Integer function(Integer x) {
            value *= x;
            return value;
        }

        @Override
        public Integer result() {
            return value;
        }
    }

    public static void main(String[] args) {
        // Generic, varargs & boxing working together:
        List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Integer result = reduce(li, new IntegerAdder());
        System.out.println(result);

        result = reduce(li, new IntegerSubtracter());
        System.out.println(result);

        System.out.println(filter(li, new GreaterThan<>(4)));

        System.out.println(forEach(li, new MultiplyingIntegerCollector()).result());
        System.out.println(forEach(filter(li, new GreaterThan<>(4)), new MultiplyingIntegerCollector()).result());

        MathContext mc = new MathContext(7);
        List<BigDecimal> lbd = Arrays.asList(
                new BigDecimal(1.1, mc), new BigDecimal(2.2, mc),
                new BigDecimal(3.3, mc), new BigDecimal(4.4, mc)
        );
        System.out.println(reduce(lbd, new BigDecimalAdder()));
        System.out.println(filter(lbd, new GreaterThan<>(new BigDecimal(3))));

        // Use the prime-generation facility of BigInteger
        List<BigInteger> lbi = new ArrayList<>();
        BigInteger bi = BigInteger.valueOf(11);
        for (int i = 0; i < 11; i++) {
            lbi.add(bi);
            bi = bi.nextProbablePrime();
        }
        System.out.println(lbi);

        BigInteger rbi = reduce(lbi, new BigIntegerAdder());
        System.out.println(rbi);
        // The sum of this list of primes is also prime
        System.out.println(rbi.isProbablePrime(5));

        List<AtomicLong> lal = Arrays.asList(
                new AtomicLong(11), new AtomicLong(47),
                new AtomicLong(74), new AtomicLong(133)
        );
        AtomicLong ral = reduce(lal, new AtomicLongAdder());
        System.out.println(ral);

        System.out.println(transform(lbd, new BigDecimalUlp()));

    }

}

//Different types of function objects:
interface Combiner<T> {
    T combine(T x, T y);
}

interface UnaryFunction<R, T> {
    R function(T t);
}

interface Collector<T> extends UnaryFunction<T, T> {
    T result(); // Extract result of collecting parameter
}

interface UnaryPredicate<T> {
    boolean test(T x);
}

