package com.moveble.service.impl;

import com.moveble.dal.interfaces.ITransactionTypeRepository;
import com.moveble.entity.TransactionType;
import com.moveble.service.interfaces.ITransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionTypeService implements ITransactionTypeService {

    private ITransactionTypeRepository transactionTypeRepository;

    @Autowired
    public TransactionTypeService(ITransactionTypeRepository transactionTypeRepository) {
        this.transactionTypeRepository = transactionTypeRepository;
    }

    @Override
    public List<TransactionType> findAll() {
        try {
            return transactionTypeRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public TransactionType update(TransactionType transactionType) {
        try {
            return transactionTypeRepository.save(transactionType);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public TransactionType create(TransactionType transactionType) {
        try {
            return transactionTypeRepository.save(transactionType);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        try {
            transactionTypeRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
