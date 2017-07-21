package com.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;
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
}
