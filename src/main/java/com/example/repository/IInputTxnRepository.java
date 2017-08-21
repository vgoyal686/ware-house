package com.example.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.InventoryLeftInWarehouses;
import com.example.bean.InventoryStorageDaysForMonth;
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
  @Transactional
  @Query("UPDATE InputTxn inputTxn SET inputTxn.softDelete = :softDelete WHERE inputTxn.id in :inputTxnIds")
  int updateSoftDelete(@Param("inputTxnIds") List<Integer> inputTxnIds, @Param("softDelete") boolean softdelete);

  @Modifying(clearAutomatically = true)
  @Transactional
  @Query("UPDATE InputTxn inputTxn SET inputTxn.softDelete = :softDelete, inputTxn.outOrderID = :outOrderID WHERE inputTxn.id in :inputTxnIds")
  int updateSoftDeleteAndOutOrderID(@Param("inputTxnIds") List<Integer> inputTxnIds, @Param("softDelete") boolean softdelete, @Param("outOrderID") String outOrderID);

  @Modifying(clearAutomatically = true)
  @Transactional
  @Query("UPDATE InputTxn inputTxn SET inputTxn.softDelete = :softDelete, inputTxn.outOrderID = :outOrderID, inputTxn.outDate = :outDate WHERE inputTxn.id in :inputTxnIds")
  int updateSoftDeleteAndOutOrderIDAndDate(@Param("inputTxnIds") List<Integer> inputTxnIds, @Param("softDelete") boolean softdelete,
                                           @Param("outOrderID") String outOrderID, @Param("outDate") Date outDate);
  
  @Query(value = "select new com.example.bean.InventoryLeftInWarehouses(inputTxn.customerID, inputTxn.uom, count(inputTxn)) from InputTxn inputTxn WHERE inputTxn.customerID = :customerID group by inputTxn.customerID, inputTxn.uom")
  List<InventoryLeftInWarehouses> findInventoryLeftInWarehousesByCustomerID(@Param("customerID")  String customerID);
  
  @Query(value = 
  "select new com.example.bean.InventoryStorageDaysForMonth( inputTxn.customerID, inputTxn.orderID, inputTxn.uom, inputTxn.identifierID, inputTxn.inDateTime, "+  
  "COALESCE(inputTxn.outDate, :monthEndDateTime) , DATEDIFF( COALESCE(inputTxn.outDate, :monthEndDateTime), inputTxn.inDateTime) ) " + 
  "from InputTxn inputTxn " +
  "where COALESCE(inputTxn.outDate, :monthEndDateTime) <= :monthEndDateTime AND inputTxn.inDateTime >= :monthStartDateTime AND inputTxn.customerID = :customerID")
  List<InventoryStorageDaysForMonth> findInventoryStorageDaysForMonthByCustomerID(@Param("customerID")  String customerID,
                                                                                  @Param("monthStartDateTime") Date monthStartDateTime,
                                                                                  @Param("monthEndDateTime") Date monthEndDateTime);

  
  @Query(value = 
  "select new com.example.bean.InventoryStorageDaysForMonth( inputTxn.customerID, inputTxn.orderID, inputTxn.uom, inputTxn.identifierID, inputTxn.inDateTime, "+  
  "COALESCE(inputTxn.outDate, :monthEndDateTime) , DATEDIFF( COALESCE(inputTxn.outDate, :monthEndDateTime), inputTxn.inDateTime) ) " + 
  "from InputTxn inputTxn " +
  "where COALESCE(inputTxn.outDate, :monthEndDateTime) <= :monthEndDateTime AND inputTxn.inDateTime >= :monthStartDateTime AND inputTxn.customerID = :customerID")
  List<InventoryStorageDaysForMonth> findInventoryStorageDaysForMonthByCustomerID2(@Param("customerID")  String customerID,
                                                                                  @Param("monthStartDateTime") Date monthStartDateTime,
                                                                                  @Param("monthEndDateTime") Date monthEndDateTime);
  
}
