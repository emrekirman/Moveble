package com.moveble.service.impl;

import com.moveble.dal.interfaces.IMeasurementUnitRepository;
import com.moveble.entity.MeasurementUnit;
import com.moveble.service.interfaces.IMeasurementUnitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class MeasurementUnitService implements IMeasurementUnitService {

    private final IMeasurementUnitRepository repository;

    @Override
    @Transactional
    public MeasurementUnit create(MeasurementUnit measurementUnit) {
        try {
            return repository.save(measurementUnit);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<MeasurementUnit> getAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    @Transactional
    public MeasurementUnit update(MeasurementUnit measurementUnit) {
        try {
            return repository.save(measurementUnit);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public MeasurementUnit findById(int id) {
        try {
            return repository.findById(id).get();
        } catch (Exception e) {
            throw e;
        }
    }
}
