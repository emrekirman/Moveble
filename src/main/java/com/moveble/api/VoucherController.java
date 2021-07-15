package com.moveble.api;

import com.moveble.entity.Voucher;
import com.moveble.service.impl.VoucherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voucher")
@AllArgsConstructor
public class VoucherController {

    private final VoucherService voucherService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Voucher> create(@RequestBody Voucher voucher) {
        try {
            return ResponseEntity.ok(voucherService.create(voucher));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Voucher>> getAll() {
        try {
            return ResponseEntity.ok(voucherService.findAll());
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Voucher> getById(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(voucherService.findById(id));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "findByNo/{no}")
    public ResponseEntity<Voucher> getByNo(@PathVariable("no") int no) {
        try {
            return ResponseEntity.ok(voucherService.findByNo(no));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        try {
            voucherService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Voucher> update(@RequestBody Voucher voucher) {
        try {
            return ResponseEntity.ok(voucherService.update(voucher));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
