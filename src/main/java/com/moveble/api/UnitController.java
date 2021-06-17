package com.moveble.api;

import com.moveble.core.aop.annotation.ValidateHeader;
import com.moveble.entity.Unit;
import com.moveble.service.interfaces.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@ValidateHeader
public class UnitController {

    private IUnitService unitService;

    @Autowired
    public UnitController(IUnitService unitService) {
        this.unitService = unitService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "units/getAll")
    public ResponseEntity<List<Unit>> getAll() {
        try {
            return ResponseEntity.ok(unitService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "units/create")
    public ResponseEntity<Unit> create(@Valid @RequestBody Unit unit) {
        try {
            unitService.create(unit);
            return ResponseEntity.ok(unit);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "units/findByName")
    public ResponseEntity<Unit> findByName(@RequestParam("name") String name) {
        try {
            return ResponseEntity.ok(unitService.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "units/update")
    public ResponseEntity<Unit> update(@Valid @RequestBody Unit unit) {
//        try {
        return ResponseEntity.ok(unitService.update(unit));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
    }


}
