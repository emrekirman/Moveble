package com.moveble.api;

import com.moveble.entity.MeasurementUnit;
import com.moveble.service.interfaces.IMeasurementUnitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/measurementUnits")
@CrossOrigin(origins = {"https://localhost:3000", "http://localhost:3000"})
@AllArgsConstructor
public class MeasurementUnitsController {

    private final IMeasurementUnitService measurementUnitService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<MeasurementUnit> create(@RequestBody MeasurementUnit model) {
        try {
            return ResponseEntity.ok(measurementUnitService.create(model));
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<MeasurementUnit>> getAll() {
        try {
            return ResponseEntity.ok(measurementUnitService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody MeasurementUnit model) {
        try {
            return new ResponseEntity(measurementUnitService.update(model), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        try {
            measurementUnitService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        try {
            MeasurementUnit model = measurementUnitService.findById(id);
            return ResponseEntity.ok(model);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
