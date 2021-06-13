package com.moveble.dal.interfaces;

import com.moveble.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionTypeRepository extends JpaRepository<TransactionType, Integer> {
}
