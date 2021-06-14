package com.moveble.service.interfaces;

import com.moveble.entity.ProductDescription;
import com.moveble.entity.VoucherMove;

import java.util.List;

public interface IProductDescriptionService {

    List<ProductDescription> findAll();

    ProductDescription update(ProductDescription productDescription);

    ProductDescription create(ProductDescription productDescription);

    void delete(int id);

    ProductDescription findByCode(String code);

    ProductDescription findByName(String name);

    ProductDescription findById(int id);
}
