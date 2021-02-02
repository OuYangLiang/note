package com.personal.oyl.knn;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        List<Data> list = new LinkedList<>();
        list.add(new Data(new BigDecimal[]{BigDecimal.valueOf(1), BigDecimal.valueOf(1.1)}, "A"));
        list.add(new Data(new BigDecimal[]{BigDecimal.valueOf(1), BigDecimal.valueOf(1)}, "A"));
        list.add(new Data(new BigDecimal[]{BigDecimal.valueOf(0), BigDecimal.valueOf(0)}, "B"));
        list.add(new Data(new BigDecimal[]{BigDecimal.valueOf(0), BigDecimal.valueOf(0.1)}, "B"));

        System.out.println(KNN.INSTANCE.compute(new BigDecimal[]{BigDecimal.valueOf(0), BigDecimal.valueOf(0.2)}, list, 3));
        System.out.println(KNN.INSTANCE.compute(new BigDecimal[]{BigDecimal.valueOf(1.3), BigDecimal.valueOf(1.2)}, list, 3));
    }
}
