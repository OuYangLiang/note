package com.personal.oyl.trees;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Tree {
    INSTANCE;

    public BigDecimal calcShannonEnt(List<Data> dataset) {
        BigDecimal num = BigDecimal.valueOf(dataset.size());
        Map<String, BigDecimal> labelCounts = dataset.stream().map(Data::getLabel)
                .collect(Collectors.toMap(Function.identity(), t -> BigDecimal.ONE, BigDecimal::add));

        BigDecimal rlt = BigDecimal.ZERO;
        for (Map.Entry<String, BigDecimal> item : labelCounts.entrySet()) {
            BigDecimal prob = item.getValue().divide(num, MathContext.DECIMAL128);
            rlt = rlt.add((prob.multiply(this.log2(prob), MathContext.DECIMAL128)));
        }

        return rlt//.setScale(2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(-1));
    }

    private BigDecimal log2(BigDecimal n) {
        return BigDecimal.valueOf(Math.log(n.doubleValue()) / Math.log(2));
    }

    public static void main(String[] args) {
        List<Data> list = new LinkedList<>();
        list.add(new Data(null, "maybe"));
        list.add(new Data(null, "yes"));
        list.add(new Data(null, "no"));
        list.add(new Data(null, "no"));
        list.add(new Data(null, "no"));

        System.out.println(Tree.INSTANCE.calcShannonEnt(list));
    }
}
