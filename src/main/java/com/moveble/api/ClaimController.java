package com.moveble.api;

import com.moveble.entity.Claim;
import com.moveble.service.interfaces.IClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/claim")
public class ClaimController {
    private IClaimService claimService;

    @Autowired
    public ClaimController(IClaimService claimService) {
        this.claimService = claimService;
    }

    @RequestMapping(method = RequestMethod.POST,value = "create")
    public ResponseEntity<Claim> create(@RequestBody Claim claim){
        try {
            return ResponseEntity.ok(claimService.create(claim));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
