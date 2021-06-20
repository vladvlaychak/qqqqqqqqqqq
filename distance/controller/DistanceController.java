package ru.itcsolutions.Distance.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import ru.itcsolutions.distance.dto.ConvertData;
import ru.itcsolutions.distance.repository.DistanceMetricSystem;
import ru.itcsolutions.distance.service.DistanceService;
import ru.itcsolutions.distance.dto.DataTransferObject;


import java.util.List;

@Component
@RestController
@RequestMapping("/DistanceMetricSystem")
public class DistancesController {

    private final DistanceService DistanceService;

    /*
     Конструктор
     */
    public DistanceController(DistanceService DistanceService) {
        this.DistanceService = DistanceService;
    }

    /**
     * Получить все Валюты
     * @return список всех Валют
     */
    @GetMapping("/DistanceMetricSystem/all")
    public ResponseEntity<List<DistanceMetricSystem>> getAll() {
        return ResponseEntity.ok(DistanceService.getAllDistance());
    }

    /**
     * Получить валюту по  буквенному идентификатору
     * @param code - идентификатор валюты
     * @return Валюта по идентификатору   как именно ты его менял?
     */
    @GetMapping("/DistanceMetricSystem/{id}")
    public ResponseEntity<DistanceMetricSystem> getDistanceMetricSystem(@PathVariable("id") String code) {
        try {
            return ResponseEntity.ok(DistanceService.getDistanceMetricSystemCode (code));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/DistanceMetricSystem/convert/{amount}")
    public ResponseEntity<List<ConvertData>> getDistanceMetricSystem(@PathVariable("amount") Double metresAmount){
        try {
            return ResponseEntity.ok(DistanceService.convertFromUSD(metresAmount));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    /**
     * Обновить или создать новый заказ
     * @param code - идентификатор заказа
     * @param dataTransferObject - объект с данными заказа
     * @return обновленный заказ
     */
    @PutMapping("/DistanceMetricSystem/{id}")
    public ResponseEntity<DistanceMetricSystem> addOrUpdateDistanceMetricSystem(
            @PathVariable("id") String code,
            @RequestBody DataTransferObject dataTransferObject) {
        try {
            return ResponseEntity.ok(DistanceService.addOrUpdateDistanceMetricSystem(code, dataTransferObject));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Удалить заказ
     * @param code - идентификатор заказа
     * @return ничего
     */
    @DeleteMapping("/DistanceMetricSystem/{id}")
    public ResponseEntity<Void> deleteDistanceMetricSystem(@PathVariable("id") String code) {
        DistanceService.deleteDistanceMetricSystem(code);
        return ResponseEntity.ok().build();
    }
}
