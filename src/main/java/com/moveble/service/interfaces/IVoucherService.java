package com.moveble.service.interfaces;

import com.moveble.entity.Voucher;

import java.util.List;

public interface IVoucherService {
    List<Voucher> findAll();

    Voucher update(Voucher claim);

    Voucher create(Voucher claim);

    Voucher findByNo(int no);

    Voucher findByRestNo(String restNo);

    List<Voucher> findAllByMovementType(int movementType);

    void delete(int id);
}
