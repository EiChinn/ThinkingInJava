package com.eichinn.containers.examples;

import java.util.*;

/**
 * Demonstrates performance difference in maps
 * {Args: 100 5000} Small to keep build testing short
 */
public class MapPerformance {
    static List<Test<Map<Integer, Integer>>> tests = new ArrayList<>();
    static {
        tests.add(new Test<Map<Integer, Integer>>("put") {
            @Override
            int test(Map<Integer, Integer> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++) {
                        container.put(j, j);
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("get") {
            @Override
            int test(Map<Integer, Integer> container, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < span; j++) {
                        container.get(j);
                    }
                }
                return loops * span;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("iterate") {
            @Override
            int test(Map<Integer, Integer> container, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<Integer> it = container.keySet().iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                return loops * container.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        Tester.run(new TreeMap<>(), tests);
        Tester.run(new HashMap<>(), tests);
        Tester.run(new LinkedHashMap<>(), tests);
        Tester.run(new IdentityHashMap<>(), tests);
        Tester.run(new WeakHashMap<>(), tests);
        Tester.run(new Hashtable<>(), tests);

    }
}
