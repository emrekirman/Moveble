package com.moveble.service.impl;

import com.moveble.dal.interfaces.IProductDescriptionRepository;
import com.moveble.entity.ProductDescription;
import com.moveble.service.interfaces.IProductDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductDescriptionService implements IProductDescriptionService {

    private IProductDescriptionRepository productDescriptionRepository;

    @Autowired
    public ProductDescriptionService(IProductDescriptionRepository productDescriptionRepository) {
        this.productDescriptionRepository = productDescriptionRepository;
    }

    @Override
    public List<ProductDescription> findAll() {
        try {
            return productDescriptionRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public ProductDescription update(ProductDescription productDescription) {
        try {
            return productDescriptionRepository.save(productDescription);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public ProductDescription create(ProductDescription productDescription) {
        try {
            return productDescriptionRepository.save(productDescription);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        try {
            productDescriptionRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ProductDescription findByCode(String code) {
        try {
            return productDescriptionRepository.findByCode(code);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ProductDescription findByName(String name) {
        try {
            return productDescriptionRepository.findByName(name);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ProductDescription findById(int id) {
        try {
            return productDescriptionRepository.findById(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
