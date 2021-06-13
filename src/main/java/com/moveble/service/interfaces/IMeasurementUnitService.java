package com.moveble.service.interfaces;

import com.moveble.entity.MeasurementUnit;

import java.util.List;

public interface IMeasurementUnitService {

    MeasurementUnit create(MeasurementUnit measurementUnit);

    List<MeasurementUnit> getAll();

    MeasurementUnit update(MeasurementUnit measurementUnit);

    void delete(int id);
}
