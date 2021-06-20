package ru.itcsolutions.distance.repository.model;

import ru.itcsolutions.distance.repository.MetricSystem;

/**
 * Расстояния в метрах/километрах
 *
 * @author mikhailyuk
 * @since 16.06.2021
 */
public class NodesDistanceMetricSystem implements MetricSystem {

    private String name;
    private Double indexFromNodes;

    public NodesDistanceMetricSystem() {
        this.name = "Метрическая система измерения (Узлы)";
        this.indexFromNodes = new Double(1);
    }

    @Override
    public Double getConvertIndexFromNodes() {
        return this.indexFromNodes;
    }

    @Override
    public String getMetricSystemName() {
        return this.name;
    }

    @Override
    public Double convertFromMetres(Double MetresAmount) {
        return MetresAmount / 1000 * 0.53995680346039;
    }
//
    @Override
    public Double convertFromKilometres(Double kilometresAmount) {
        return kilometresAmount * 0.53995680346039;
    }
}
