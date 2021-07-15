package com.moveble.api;

import com.moveble.entity.VoucherMove;
import com.moveble.service.impl.VoucherMoveService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/voucherMove")
@AllArgsConstructor
public class VoucherMoveController {

    private final VoucherMoveService voucherMoveService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<VoucherMove> create(@RequestBody VoucherMove voucherMove) {
        try {
            return ResponseEntity.ok(voucherMoveService.create(voucherMove));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<VoucherMove>> getAll() {
        try {
            return ResponseEntity.ok(voucherMoveService.findAll());
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<VoucherMove> update(@RequestBody VoucherMove voucherMove) {
        try {
            return ResponseEntity.ok(voucherMoveService.update(voucherMove));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
