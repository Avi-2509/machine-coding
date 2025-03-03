package com.machine_coding.Machine.coding.practice.lldQuestions.LRUCache;

import com.machine_coding.Machine.coding.practice.lldQuestions.LRUCache.service.LRU;

public class LRUCacheDemo {
    public static void main(String args[]) {
        LRU<Integer, String> cache = new LRU<>(3);

        cache.put(1, "Value 1");
        cache.put(2, "Value 2");
        cache.put(3, "Value 3");

        System.out.println(cache.get(1)); // Output: Value 1
        System.out.println(cache.get(2)); // Output: Value 2

        cache.put(4, "Value 4");

        System.out.println(cache.get(3)); // Output: null
        System.out.println(cache.get(4)); // Output: Value 4

        cache.put(2, "Updated Value 2");

        System.out.println(cache.get(1)); // Output: Value 1
        System.out.println(cache.get(2)); // Output: Updated Value 2
    }
}
