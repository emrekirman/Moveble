package com.moveble.service.impl;

import com.moveble.dal.interfaces.ITransactionTypeRepository;
import com.moveble.entity.TransactionType;
import com.moveble.service.interfaces.ITransactionTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionTypeService implements ITransactionTypeService {

    private final ITransactionTypeRepository transactionTypeRepository;

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
