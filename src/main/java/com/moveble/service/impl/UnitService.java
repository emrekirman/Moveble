package com.moveble.service.impl;

import com.moveble.dal.interfaces.IUnitRepository;
import com.moveble.entity.Unit;
import com.moveble.service.interfaces.IUnitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UnitService implements IUnitService {

    private final IUnitRepository unitRepository;

    @Override
    public List<Unit> getAll() {
        try {
            return unitRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void create(Unit unit) {
        try {
            unitRepository.save(unit);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Unit findByName(String name) {
        try {
            return unitRepository.findByName(name);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public Unit update(Unit unit) {
        try {
            return unitRepository.save(unit);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(int id) {
        try {
            unitRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
