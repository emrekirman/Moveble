package com.moveble.service.impl;

import com.moveble.dal.interfaces.IVoucherRepository;
import com.moveble.entity.Voucher;
import com.moveble.service.interfaces.IVoucherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class VoucherService implements IVoucherService {

    private final IVoucherRepository voucherRepository;

    @Override
    public List<Voucher> findAll() {
        try {
            return voucherRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public Voucher update(Voucher voucher) {
        try {
            return voucherRepository.save(voucher);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public Voucher create(Voucher voucher) {
        try {
            return voucherRepository.save(voucher);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Voucher findByNo(int no) {
        try {
            return voucherRepository.findByNo(no);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Voucher findByRestNo(String restNo) {
        try {
            return voucherRepository.findByRestNo(restNo);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Voucher> findAllByMovementType(int movementType) {
        try {
            return voucherRepository.findAllByMovementType(movementType);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        try {
            voucherRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Voucher findById(int id){
        try {
            return voucherRepository.findById(id).get();
        }catch (Exception e){
            throw e;
        }
    }
}
