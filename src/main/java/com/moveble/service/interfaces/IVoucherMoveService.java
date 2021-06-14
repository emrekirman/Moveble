package com.moveble.service.interfaces;

import com.moveble.entity.VoucherMove;

import java.util.List;

public interface IVoucherMoveService {

    List<VoucherMove> findAll();

    VoucherMove update(VoucherMove voucherMove);

    VoucherMove create(VoucherMove voucherMove);

    void delete(int id);

    List<VoucherMove> findByMovementType(int movementType);
}
