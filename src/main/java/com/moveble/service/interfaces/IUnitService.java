package com.moveble.service.interfaces;

import com.moveble.entity.Unit;

import java.util.List;

public interface IUnitService {

    List<Unit> getAll();

    void create(Unit unit);

    Unit findByName(String name);

    Unit update(Unit unit);

    void delete(int id);
}
