package com.personal.oyl.knn;

/**
 * @author OuYang Liang
 * @since 2021-01-29
 */
public class ThreeTuple<K1, K2, K3> extends TwoTuple<K1, K2> {
    private K3 third;

    public ThreeTuple(K1 first, K2 second, K3 third) {
        super(first, second);
        this.third = third;
    }

    public ThreeTuple() {

    }

    public K3 getThird() {
        return third;
    }

    public void setThird(K3 third) {
        this.third = third;
    }
}
