package com.moveble.service.impl;

import com.moveble.dal.interfaces.IVoucherMoveRepository;
import com.moveble.dto.StockDto;
import com.moveble.entity.VoucherMove;
import com.moveble.service.interfaces.IVoucherMoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

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

    /*Güncel stok mevcudunu getirir.*/
    @Override
    public List<StockDto> getStocks() {
        try {
            List<StockDto> list = voucherMoveRepository.getStocks();
            Hashtable<String, StockDto> data = new Hashtable<String, StockDto>();

            for (StockDto item : list) {
                String key = item.getProductDescriptionName() + "_" + item.getUnitName();
                if (!data.containsKey(key)) {
                    data.put(key, new StockDto());
                }
                if (item.getMovementType() == 1) {//çıkış ise mevcuttan düşecek.
                    item.setQuantity(item.getQuantity() * (-1));
                }
                data.get(key).setQuantity(data.get(key).getQuantity() + item.getQuantity());
            }

//            list = new ArrayList<StockDto>();
            list = data.values().stream().filter(x -> x.getQuantity() > 0).collect(Collectors.toList());

//            for (StockDto item : data.values()) {
//                if (item.getQuantity() > 0) {
//                    list.add(item);
//                }
//            }

            return list;
        } catch (Exception e) {
            throw e;
        }
    }
}
