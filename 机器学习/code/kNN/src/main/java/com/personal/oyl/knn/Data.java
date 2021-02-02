package com.personal.oyl.knn;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author OuYang Liang
 * @since 2021-01-28
 */
public class Data {
    private BigDecimal[] properties;
    private String label;

    public Data(BigDecimal[] properties, String label) {
        this.properties = properties;
        this.label = label;
    }

    public BigDecimal[] getProperties() {
        return properties;
    }

    public void setProperties(BigDecimal[] properties) {
        this.properties = properties;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Data{" +
                "properties=" + Arrays.toString(properties) +
                ", label='" + label + '\'' +
                '}';
    }
}
