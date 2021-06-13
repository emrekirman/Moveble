package com.moveble.dal.interfaces;

import com.moveble.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVoucherRepository extends JpaRepository<Voucher, Integer> {
}
