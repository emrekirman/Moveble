package com.moveble.service.impl;

import com.moveble.dal.interfaces.IMeasurementUnitRepository;
import com.moveble.entity.MeasurementUnit;
import com.moveble.service.interfaces.IMeasurementUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeasurementUnitService implements IMeasurementUnitService {

    private IMeasurementUnitRepository repository;

    @Autowired
    public MeasurementUnitService(IMeasurementUnitRepository repository) {
        this.repository = repository;
    }

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
        }catch (Exception e){
            throw e;
        }
    }
}
