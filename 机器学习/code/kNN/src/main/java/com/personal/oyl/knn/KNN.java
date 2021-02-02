package com.personal.oyl.knn;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

/**
 * @author OuYang Liang
 * @since 2021-01-28
 */
public enum KNN {
    INSTANCE;

    public String compute(BigDecimal[] properties, List<Data> dataset, int k) {

        ThreeTuple<List<Data>, BigDecimal[], BigDecimal[]> tuple = this.norm(dataset);
        BigDecimal[] normProp = this.norm(properties, tuple.getSecond(), tuple.getThird());

        List<MiddleData> middles = new ArrayList<>(dataset.size());
        for (int i = 0; i < tuple.getFirst().size(); i++) {
            Data data = tuple.getFirst().get(i);
            middles.add(new MiddleData(i, distance(normProp, data.getProperties())));
        }

        Rank rank = new Rank();
        middles.sort(Comparator.comparing(MiddleData::getDistance));
        for (int i = 0; i < k; i++) {
            rank.increase(tuple.getFirst().get(middles.get(i).getIdx()).getLabel());
        }

        return rank.get();
    }

    /*
     * 归一化入参
     */
    BigDecimal[] norm(BigDecimal[] properties, BigDecimal[] min, BigDecimal[] range) {
        BigDecimal[] rlt = new BigDecimal[properties.length];
        for (int i = 0; i < properties.length; i++) {
            rlt[i] = (properties[i].subtract(min[i])).divide(range[i], 4, RoundingMode.HALF_UP);
        }

        return rlt;
    }

    /*
     * 归一化，返回归一化数据集，最小值和范围
     */
    public ThreeTuple<List<Data>, BigDecimal[], BigDecimal[]> norm(List<Data> dataset) {
        int n = dataset.get(0).getProperties().length;
        BigDecimal[] min = new BigDecimal[n];
        BigDecimal[] max = new BigDecimal[n];
        BigDecimal[] range = new BigDecimal[n];
        for (int j = 0; j < n; j++) {
            int i = j;
            min[i] = dataset.stream().map(d -> d.getProperties()[i]).min(Comparator.comparing(BigDecimal::doubleValue)).orElse(BigDecimal.ZERO);
            max[i] = dataset.stream().map(d -> d.getProperties()[i]).max(Comparator.comparing(BigDecimal::doubleValue)).orElse(BigDecimal.ZERO);
            range[i] = max[i].subtract(min[i]);
        }

        List<Data> normSet = new ArrayList<>(dataset.size());
        for (Data data : dataset) {
            BigDecimal[] properties = new BigDecimal[n];
            for (int i = 0; i < n; i++) {
                properties[i] = (data.getProperties()[i].subtract(min[i])).divide(range[i], MathContext.DECIMAL128);
            }
            normSet.add(new Data(properties, data.getLabel()));
        }

        return new ThreeTuple<>(normSet, min, range);
    }

    /*
     * 计算两点距离
     */
    private BigDecimal distance(BigDecimal[] p0, BigDecimal[] p1) {
        BigDecimal[] dist = new BigDecimal[p0.length];
        BigDecimal rlt = BigDecimal.ZERO;
        for (int i = 0; i < p0.length; i++) {
            dist[i] = p0[i].subtract(p1[i]);
        }

        for (BigDecimal item : dist) {
            rlt = rlt.add(item.pow(2, MathContext.DECIMAL128));
        }

        return BigDecimal.valueOf(
                Math.sqrt(rlt.setScale(4, RoundingMode.HALF_UP).doubleValue()))
                .setScale(2, RoundingMode.HALF_UP);
    }

}
