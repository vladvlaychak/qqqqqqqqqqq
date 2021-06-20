package ru.itcsolutions.distance.repository;

import org.springframework.stereotype.Service;
import ru.itcsolutions.distance.repository.model.MetresDistanceMetricSystem;
import ru.itcsolutions.distance.repository.model.MilsDistanceMetricSystem;
import ru.itcsolutions.distance.repository.model.NodesDistanceMetricSystem;
import java.util.ArrayList;
import java.util.List;

@Service
public class DistanceRepository {


    private List<DistanceMetricSystem> distance;


    public DistanceMetricSystemRepository() {
        distance = new ArrayList<>();

        distance.add(new MilsDistanceMetricSystem(1.21,978,"Мили"));
        distance.add(new NodesCurrency(1,840,"Узлы"));

    }

    /**
     * Не ну это для тебя не долго
     * @return список
     */
    public List<Distance> getdistance() {
        return distance;
    }

    /**
     *
     * @param distance - список закзаов
     */
    public void setdistance(List<Distance> distance) {
        this.distance = distance;
    }
}
