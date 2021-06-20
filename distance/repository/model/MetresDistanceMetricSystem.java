package ru.itcsolutions.distance.repository.model;

import ru.itcsolutions.distance.repository.MetricSystem;


public class MetresDistanceMetricSystem implements MetricSystem {

    private String name;
    private Double indexFromMetres;

    public MetresDistanceMetricSystem() {
        this.name = "Метрическая система измерения (метры)";
        this.indexFromMetres = new Double(1);
    }

    @Override
    public Double getConvertIndexFromMetres() {
        return this.indexFromMetres;
    }

    @Override
    public String getMetricSystemName() {
        return this.name;
    }
//
    @Override
    public Double convertFromMetres(Double metresAmount) {
        return metresAmount;
    }

    @Override
    public Double convertFromKilometres(Double kilometresAmount) {
        return kilometresAmount / 1000;
    }
}
