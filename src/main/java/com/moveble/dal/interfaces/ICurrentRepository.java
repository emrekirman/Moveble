package com.moveble.dal.interfaces;

import com.moveble.entity.Current;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICurrentRepository extends JpaRepository<Current, Integer> {
}
