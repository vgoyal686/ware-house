package com.example.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.InputTxn;

/**
 * @author Anurag
 * @description 
 */
@Repository("inputTxnRepository")
public interface IInputTxnRepository extends JpaRepository<InputTxn, Long> {

  InputTxn findByCustomerID(String customerID);  
  InputTxn findByWarehouseID(String warehouseID);
  InputTxn findByOrderID(String orderID);

  InputTxn findByCustomerIDAndSoftDelete(String customerID, boolean softDelete);  
  InputTxn findByWarehouseIDAndSoftDelete(String warehouseID, boolean softDelete);
  InputTxn findByOrderIDAndSoftDelete(String orderID, boolean softDelete);

  @Modifying(clearAutomatically = true)
  @Query("UPDATE InputTxn inputTxn SET inputTxn.softDelete = :softDelete WHERE inputTxn.id in :inputTxnIds")
  int updateSoftDelete(@Param("inputTxnIds") List<Integer> inputTxnIds, @Param("softDelete") boolean softdelete);
}