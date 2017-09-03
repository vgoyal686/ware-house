/**
 * @author Anurag
 * @description 
 */
package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bean.InventoryLoadingChargesForMonth;
import com.example.bean.InventoryStorageDaysForMonth;
import com.example.bean.SumInventoryLoadingChargesForMonth;
import com.example.model.OrderRequest;

/**
 * @author Anurag
 * @description 
 */
@Repository("orderRequestRepository")
public interface IOrderRequestRepository extends JpaRepository<OrderRequest, Long> {

 // OrderRequest findByCustomerID(String customerID);  
  //Iterable<OrderRequest> findByCustomerID(String customerID);  
  List<OrderRequest> findAll();
  Page<OrderRequest> findAll(Pageable pageable);
  List<OrderRequest> findByCustomerID(String customerID);
  
  List<OrderRequest> findByOrderID(int orderID);
  List<OrderRequest> findByOrderIDIn(List<Integer> orderIDs);
  
  List<OrderRequest> findByCustomerIDAndOrderType(String customerID, String orderType);
  
  List<OrderRequest> findByCustomerIDOrderByCreatedDesc(String customerID);
  Page<OrderRequest> findByCustomerIDOrderByCreatedDesc(String customerID, Pageable pageable);
  
  @Query(value = 
  "select new com.example.bean.InventoryLoadingChargesForMonth( orderRequest.customerID, orderRequest.orderID, orderRequest.uom, orderRequest.orderDate, "+  
  "COALESCE(orderRequest.loadingCharge, '0') , COALESCE(orderRequest.unloadingCharge, '0') , COALESCE(orderRequest.otherCharge, '0') ) " + 
  "from OrderRequest orderRequest " +
  "where orderRequest.customerID = :customerID AND ( " +
  "( orderRequest.orderDate >= :monthStartDateTime AND orderRequest.orderDate <= :monthEndDateTime  )  " +
  " )")
  List<InventoryLoadingChargesForMonth> findInventoryLoadingChargesMonthByCustomerID(@Param("customerID")  String customerID,
                                                                                  @Param("monthStartDateTime") Date monthStartDateTime,
                                                                                  @Param("monthEndDateTime") Date monthEndDateTime);
List<OrderRequest> findByOrderTypeOrderByCreatedDesc(String string);
  
  
}
