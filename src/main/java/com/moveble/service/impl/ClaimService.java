package com.moveble.service.impl;

import com.moveble.dal.interfaces.IClaimRepository;
import com.moveble.entity.Claim;
import com.moveble.service.interfaces.IClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClaimService implements IClaimService {

    private IClaimRepository claimRepository;

    @Autowired
    public ClaimService(IClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    @Override
    public List<Claim> findAll() {
        try {
            return claimRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public Claim update(Claim claim) {
        try {
            return claimRepository.save(claim);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public Claim create(Claim claim) {
        try {
            return claimRepository.save(claim);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Claim findByName(String name) {
        try {
            return claimRepository.findByName(name);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        try {
            claimRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
