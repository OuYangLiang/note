package com.personal.oyl.knn;

import com.personal.oyl.knn.util.FileReader;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * @author OuYang Liang
 * @since 2021-01-29
 */
public class App1 {
    public static void main(String[] args) throws IOException {

        List<String> lines = FileReader.INSTANCE.read("./datingTestSet.txt");
        List<Data> dataset = new LinkedList<>();
        for (String line : lines) {
            String[] parts = line.trim().split("\\t");
            BigDecimal[] props = new BigDecimal[3];
            props[0] = new BigDecimal(parts[0].trim());
            props[1] = new BigDecimal(parts[1].trim());
            props[2] = new BigDecimal(parts[2].trim());

            dataset.add(new Data(props, parts[3].trim()));
        }

        double total = 0;
        double error = 0;
        for (Data data : dataset) {
            total++;
            if (!KNN.INSTANCE.compute(data.getProperties(), dataset, 3).equals(data.getLabel())) {
                error ++;
                System.out.println(KNN.INSTANCE.compute(data.getProperties(), dataset, 3) + " : " + data.getLabel());
            }
        }

        System.out.println( 100 * (1 - error / total));
    }
}
