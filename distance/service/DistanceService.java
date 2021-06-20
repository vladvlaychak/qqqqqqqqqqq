package ru.itcsolutions.distance.service;

import org.springframework.stereotype.Service;
import ru.itcsolutions.distance.dto.DataTransferObject;
import ru.itcsolutions.distance.repository.model.KilometresDistanceMetricSystem;
import ru.itcsolutions.distance.repository.model.MetresDistanceMetricSystem;
import ru.itcsolutions.distance.repository.model.MilsDistanceMetricSystem;
import ru.itcsolutions.distance.repository.model.NodesDistanceMetricSystem;
import ru.itcsolutions.distance.repository.DistanceMetricSystem;
import ru.itcsolutions.distance.repository.distanceRepository;
import ru.itcsolutions.distance.dto.ConvertData;

import java.util.ArrayList;
import java.util.List;


@Service
public class distanceService {

    private final distanceRepository distanceRepository;

    /*
     Конструктор
     */
    public distanceService(distanceRepository distanceRepository) {
        this.distanceRepository = distanceRepository;
    }

    public DistanceMetricSystem getDistanceMetricSystemCodeNum(int codeNum) throws Exception {
        List<DistanceMetricSystem> distance = distanceRepository.getdistance();
        for (DistanceMetricSystem DistanceMetricSystem: distance) {
            if (DistanceMetricSystem.getDistanceMetricSystemCodeNum() == codeNum) {
                return DistanceMetricSystem;
            }
        }
        throw new Exception("Валюты с таким кодом нет " + codeNum);
    }

    public DistanceMetricSystem getDistanceMetricSystemCode(String code) throws Exception {
        List<DistanceMetricSystem> distance = distanceRepository.getdistance();
        for (DistanceMetricSystem DistanceMetricSystem: distance) {
            if (DistanceMetricSystem.getDistanceMetricSystemCode().equals(code)) {
                return DistanceMetricSystem;
            }
        }
        throw new Exception("Валюты с таким кодом нет " + code);
    }

    /**
     * Добавить обновить заказ
     * @param code - идентификатор
     * @param dataTransferObject - данные заказа
     * @return новый/обновленный заказ
     */
    public DistanceMetricSystem addOrUpdateDistanceMetricSystem(String code, DataTransferObject dataTransferObject) throws Exception {

        // удаляем предыдущие записи по идентификатору
        deleteDistanceMetricSystem(code);

        // получаем свежий спсиок после удлаения
        List<DistanceMetricSystem> distance = distanceRepository.getdistance();

        DistanceMetricSystem newOrUpdatedDistanceMetricSystem;
        if (code.equalsIgnoreCase("Узлы")) {
            newOrUpdatedDistanceMetricSystem = new NodesDistanceMetricSystem(
                    dataTransferObject.getCourse(),
                    dataTransferObject.getCodeNum(),
                    dataTransferObject.getCode()
            );
        }
        else if (code.equalsIgnoreCase("Мили")){
            newOrUpdatedDistanceMetricSystem = new MilsDistanceMetricSystem(
                    dataTransferObject.getCourse(),
                    dataTransferObject.getCodeNum(),
                    dataTransferObject.getCode()
            );
        }
        else {
            newOrUpdatedDistanceMetricSystem = new MetresDistanceMetricSystem(
                    dataTransferObject.getCourse(),
                    dataTransferObject.getCodeNum(),
                    dataTransferObject.getCode()
            );
        }

        //обновлем в списке
        distance.add(newOrUpdatedDistanceMetricSystem);
        distanceRepository.setdistance(distance);
        return newOrUpdatedDistanceMetricSystem;
    }

    public Double getConvertIndexFromMetres(Double course) throws Exception {
        List<DistanceMetricSystem> distance = distanceRepository.getdistance();
        for (DistanceMetricSystem DistanceMetricSystem : distance) {
            course = DistanceMetricSystem.getConvertIndexFromMetres();
                return course;

        }
        return course;
    }

    public List<ConvertData> convertFromMetres(Double metresAmount){
        List<DistanceMetricSystem> distance = distanceRepository.getdistance();
        List<ConvertData> amounts=new ArrayList<>();
        for (DistanceMetricSystem DistanceMetricSystem : distance) {
            Double result = metresAmount * DistanceMetricSystem.getConvertIndexFromMetres();
            String code = DistanceMetricSystem.getDistanceMetricSystemCode();
            amounts.add(new ConvertData(code, result));

        }
        return amounts;
    }

    public List<ConvertData> convertFromKilometres(Double kilometresAmount){
        List<DistanceMetricSystem> distance = distanceRepository.getdistance();
        List<ConvertData> amounts=new ArrayList<>();
        for (DistanceMetricSystem DistanceMetricSystem : distance) {
            Double result = kilometresAmount * DistanceMetricSystem.getConvertIndexFromMetres();
            String code = DistanceMetricSystem.getDistanceMetricSystemCode();
            amounts.add(new ConvertData(code, result));

        }
        return amounts;
    }


    /**
     * Удалить валюту по идентификатору
     * @param code - идентификатор
     */
    public void deleteDistanceMetricSystem(String code) {
        List<DistanceMetricSystem> distance = distanceRepository.getdistance();

        // удаляем предыдущие записи по идентификатору
        List<DistanceMetricSystem> newdistance = new ArrayList<>();
        for (DistanceMetricSystem DistanceMetricSystem: distance) {
            if (!DistanceMetricSystem.getDistanceMetricSystemCode().equals(code)) {
                newdistance.add(DistanceMetricSystem);
            }
        }
        //обновлем в списке
        distanceRepository.setdistance(newdistance);
    }

    /**
     * Вернуть все валюты
     * @return - спсиок валют
     */
    public List<DistanceMetricSystem> getAlldistance() {
        return distanceRepository.getdistance();
    }
}
