package com.moveble.api;

import com.moveble.entity.Claim;
import com.moveble.service.interfaces.IClaimService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/claim")
@AllArgsConstructor
public class ClaimController {

    private final IClaimService claimService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Claim> create(@RequestBody Claim claim) {
        try {
            return ResponseEntity.ok(claimService.create(claim));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Claim> update(@RequestBody Claim claim) {
        try {
            return ResponseEntity.ok(claimService.update(claim));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Claim>> getAll() {
        try {
            return ResponseEntity.ok(claimService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    public ResponseEntity<Claim> getByName(@PathVariable("name") String name) {
        try {
            return ResponseEntity.ok(claimService.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        try {
            claimService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
