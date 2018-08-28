package com.eichinn.containers.examples;

import com.eichinn.common.Countries;

import java.util.*;

/**
 *  A Map implemented with ArrayList
 */
public class SlowMap<K, V> extends AbstractMap<K, V> {
    List<K> keys = new ArrayList<>();
    List<V> values = new ArrayList<>();

    public V put(K key, V value) {
        V oldValue = get(key); // The old value or null
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    public V get(Object key) { // key is type object, not K
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));

    }
    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext()) {
            set.add(new MapEntry<>(ki.next(), vi.next()));
        }
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<>();
        m.putAll(Countries.capitals(15));
        System.out.println(m);
        System.out.println(m.get("COMOROS"));
        System.out.println(m.entrySet());
    }
}
