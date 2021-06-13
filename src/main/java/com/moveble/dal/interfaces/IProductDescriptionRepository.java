package com.moveble.dal.interfaces;

import com.moveble.entity.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDescriptionRepository extends JpaRepository<ProductDescription, Integer> {
}
