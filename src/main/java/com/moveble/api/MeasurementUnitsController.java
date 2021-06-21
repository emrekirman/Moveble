package com.moveble.api;

import com.moveble.entity.MeasurementUnit;
import com.moveble.service.interfaces.IMeasurementUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/measurementUnits")
@CrossOrigin(origins = {"https://localhost:3000", "http://localhost:3000"})
public class MeasurementUnitsController {

    private IMeasurementUnitService measurementUnitService;

    @Autowired
    public MeasurementUnitsController(IMeasurementUnitService measurementUnitService) {
        this.measurementUnitService = measurementUnitService;
    }

    @RequestMapping(method = RequestMethod.POST,value = "create")
    public ResponseEntity<MeasurementUnit> create(@RequestBody MeasurementUnit model) {
        try {
            return ResponseEntity.ok(measurementUnitService.create(model));
        } catch (Exception e) {
            throw e;
        }
    }
}
