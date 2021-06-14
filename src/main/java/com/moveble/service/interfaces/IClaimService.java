package com.moveble.service.interfaces;

import com.moveble.dal.interfaces.IClaimRepository;
import com.moveble.entity.Claim;

import java.util.List;

public interface IClaimService {

    List<Claim> findAll();

    Claim update(Claim claim);

    Claim create(Claim claim);

    Claim findByName(String name);
}
