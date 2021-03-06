package com.moveble.service.interfaces;

import com.moveble.entity.TransactionType;

import java.util.List;

public interface ITransactionTypeService {

    List<TransactionType> findAll();

    TransactionType update(TransactionType transactionType);

    TransactionType create(TransactionType transactionType);

    void delete(int id);

    TransactionType findById(int id);
}
