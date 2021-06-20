package ru.itcsolutions.distance.repository.model;

import ru.itcsolutions.distance.repository.MetricSystem;

/**
 * Расстояния в метрах/километрах
 *
 * @author mikhailyuk
 * @since 16.06.2021
 */
public class MilsDistanceMetricSystem implements MetricSystem {

    private String name;
    private Double indexFromMils;

    public MilsDistanceMetricSystem() {
        this.name = "Метрическая система измерения (Мили)";
        this.indexFromMils = new Double(1);
    }

    @Override
    public Double getConvertIndexFromMils() {
        return this.indexFromMils;
    }

    @Override
    public String getMetricSystemName() {
        return this.name;
    }

    @Override
    public Double convertFromMetres(Double MetresAmount) {
        return MetresAmount / 1000 * 0,62;
    }
// что здесь делать
    @Override
    public Double convertFromKilometres(Double kilometresAmount) {
        return kilometresAmount * 0,62;
    }
}
