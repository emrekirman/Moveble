package com.moveble.api;

import com.moveble.entity.TransactionType;
import com.moveble.service.impl.TransactionTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactionType")
@AllArgsConstructor
public class TransactionTypeController {

    private final TransactionTypeService transactionTypeService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TransactionType> create(@RequestBody TransactionType transactionType) {
        try {
            return ResponseEntity.ok(transactionTypeService.create(transactionType));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TransactionType>> getAll() {
        try {
            return ResponseEntity.ok(transactionTypeService.findAll());
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<TransactionType> getById(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(transactionTypeService.findById(id));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<TransactionType> update(@RequestBody TransactionType transactionType) {
        try {
            return ResponseEntity.ok(transactionTypeService.update(transactionType));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        try {
            transactionTypeService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
