package com.moveble.dal.interfaces;

import com.moveble.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClaimRepository extends JpaRepository<Claim, Integer> {

    Claim findByName(String name);
}
