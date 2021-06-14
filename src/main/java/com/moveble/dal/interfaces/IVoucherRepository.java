package com.moveble.dal.interfaces;

import com.moveble.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVoucherRepository extends JpaRepository<Voucher, Integer> {

    Voucher findByNo(int no);

    Voucher findByRestNo(String restNo);

    List<Voucher> findAllByMovementType(int movementType);
}
