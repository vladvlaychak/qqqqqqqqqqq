package ru.itcsolutions.distance.repository;

/**
 Метрическая система
**/
public interface DistanceMetricSystem {
    public Double getConvertIndexFromMetres();
    public String getMetricSystemName();
    public Double convertFromMetres(Double metresAmount);
    public Double convertFromKilometres(Double kilometresAmount);
}
