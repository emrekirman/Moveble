package com.moveble.api;

import com.moveble.entity.Claim;
import com.moveble.service.interfaces.IClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/claim")
public class ClaimController {

    private IClaimService claimService;

    @Autowired
    public ClaimController(IClaimService claimService) {
        this.claimService = claimService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "create")
    public ResponseEntity<Claim> create(@RequestBody Claim claim) {
        try {
            return ResponseEntity.ok(claimService.create(claim));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "update")
    public ResponseEntity<Claim> update(@RequestBody Claim claim) {
        try {
            return ResponseEntity.ok(claimService.update(claim));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAll")
    public ResponseEntity<List<Claim>> getAll() {
        try {
            return ResponseEntity.ok(claimService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "getByName")
    public ResponseEntity<Claim> getByName(@RequestParam("name") String name) {
        try {
            return ResponseEntity.ok(claimService.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "delete")
    public ResponseEntity<Boolean> delete(@RequestParam("id") int id) {
        try {
            claimService.delete(id);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
