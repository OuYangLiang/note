package com.personal.oyl.knn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author OuYang Liang
 * @since 2021-01-28
 */
public class Rank {
    private Map<String, Integer> inner = new HashMap<>();

    public void increase(String label) {
        if (inner.containsKey(label)) {
            inner.put(label, inner.get(label)+1);
        } else {
            inner.put(label, 1);
        }
    }

    public String get() {
        return inner.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toList())
                .get(inner.size() - 1).getKey();
    }
}
