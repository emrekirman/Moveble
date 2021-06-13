package com.moveble.dal.interfaces;

import com.moveble.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUnitRepository extends JpaRepository<Unit, Integer> {

    Unit findByName(String name);

}
