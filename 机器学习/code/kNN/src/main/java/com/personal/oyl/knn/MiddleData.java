package com.personal.oyl.knn;

import java.math.BigDecimal;

/**
 * @author OuYang Liang
 * @since 2021-01-28
 */
public class MiddleData {
    private int idx;
    private BigDecimal distance;

    public MiddleData(int idx, BigDecimal distance) {
        this.idx = idx;
        this.distance = distance;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }
}
