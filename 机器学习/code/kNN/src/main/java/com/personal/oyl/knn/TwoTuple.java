package com.personal.oyl.knn;

/**
 * @author OuYang Liang
 * @since 2021-01-29
 */
public class TwoTuple <K1, K2> {
    private K1 first;
    private K2 second;

    public TwoTuple(K1 first, K2 second) {
        this.first = first;
        this.second = second;
    }

    public TwoTuple() {
    }

    public K1 getFirst() {
        return first;
    }

    public void setFirst(K1 first) {
        this.first = first;
    }

    public K2 getSecond() {
        return second;
    }

    public void setSecond(K2 second) {
        this.second = second;
    }
}
