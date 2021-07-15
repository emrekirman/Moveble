package com.moveble.api;

import com.moveble.core.aop.annotation.ValidateHeader;
import com.moveble.entity.Unit;
import com.moveble.service.interfaces.IUnitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/units")
@ValidateHeader
@AllArgsConstructor
public class UnitController {

    private final IUnitService unitService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Unit>> getAll() {
        try {
            return ResponseEntity.ok(unitService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Unit> create(@Valid @RequestBody Unit unit) {
        try {
            unitService.create(unit);
            return ResponseEntity.ok(unit);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "findByName")
    public ResponseEntity<Unit> findByName(@RequestParam("name") String name) {
        try {
            return ResponseEntity.ok(unitService.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Unit> update(@Valid @RequestBody Unit unit) {
//        try {
        return ResponseEntity.ok(unitService.update(unit));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        try {
            unitService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
