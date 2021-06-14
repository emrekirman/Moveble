package com.moveble.service.impl;

import com.moveble.dal.interfaces.IVoucherMoveRepository;
import com.moveble.entity.VoucherMove;
import com.moveble.service.interfaces.IVoucherMoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VoucherMoveService implements IVoucherMoveService {

    private IVoucherMoveRepository voucherMoveRepository;

    @Autowired
    public VoucherMoveService(IVoucherMoveRepository voucherMoveRepository) {
        this.voucherMoveRepository = voucherMoveRepository;
    }

    @Override
    public List<VoucherMove> findAll() {
        try {
            return voucherMoveRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public VoucherMove update(VoucherMove voucherMove) {
        try {
            return voucherMoveRepository.save(voucherMove);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public VoucherMove create(VoucherMove voucherMove) {
        try {
            return voucherMoveRepository.save(voucherMove);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        try {
            voucherMoveRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<VoucherMove> findByMovementType(int movementType) {
        try {
            return voucherMoveRepository.findByMovementType(movementType);
        } catch (Exception e) {
            throw e;
        }
    }
}
