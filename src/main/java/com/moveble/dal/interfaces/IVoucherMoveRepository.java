package com.moveble.dal.interfaces;

import com.moveble.dto.StockDto;
import com.moveble.entity.VoucherMove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVoucherMoveRepository extends JpaRepository<VoucherMove, Integer> {

    List<VoucherMove> findByMovementType(int movementType);

    @Query("Select new com.moveble.dto.StockDto(vo.quantity,u.name,u.id,p.name,p.id,v.movementType) " +
            "from VoucherMove vo " +
            "inner join Unit u " +
            "inner join ProductDescription p " +
            "inner join Voucher v")
    List<StockDto> getStocks();
}
