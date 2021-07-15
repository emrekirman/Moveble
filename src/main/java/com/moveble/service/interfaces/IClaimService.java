package com.moveble.service.interfaces;

import com.moveble.entity.Claim;

import java.util.List;

public interface IClaimService {

    List<Claim> findAll();

    Claim update(Claim claim);

    Claim create(Claim claim);

    void delete(int id);

    Claim findByName(String name);
    
}
