package com.moveble.dal.interfaces;

import com.moveble.entity.VoucherMove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVoucherMoveRepository extends JpaRepository<VoucherMove, Integer> {

    List<VoucherMove> findByMovementType(int movementType);
}
