/**
 * @author Anurag
 * @description 
 */
package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.example.bean.InventoryLoadingChargesForMonth;
import com.example.bean.InventoryStorageDaysForMonth;
import com.example.bean.SumInventoryLoadingChargesForMonth;
import com.example.model.OrderRequest;

/**
 * @author Anurag
 * @description
 */
public interface IOrderRequestService
{
	public Boolean saveOrderRequest(OrderRequest orderRequest);

	public OrderRequest saveAndGetOrderRequest(OrderRequest orderRequest);

    List<OrderRequest> findByOrderID(int orderID);
    List<OrderRequest> findByOrderIDIn(List<Integer> orderID);

	public List<OrderRequest> findByCustomerID(String customerID);
	
	
	List<OrderRequest> findByCustomerIDAndInOrderType(String customerID);
	
	List<OrderRequest> findByCustomerIDAndOutOrderType(String customerID);
	
	public List<OrderRequest> listByCustomerID(String customerID);

	public List<OrderRequest> findAllOrderRequest();

	public Page<OrderRequest> getAllOrderRequestWithPagination(Pageable pageable);

	boolean findById(Long id);

	public List<OrderRequest> findByCustomerIDOrderByCreatedDesc(String customerID);
	public Page<OrderRequest> findByCustomerIDOrderByCreatedDesc(String customerID, Pageable pageable);
	
	List<InventoryLoadingChargesForMonth> findInventoryLoadingChargesMonthByCustomerID(String customerID, Date someDateOfAMonth);
	
	
	SumInventoryLoadingChargesForMonth findSumInventoryLoadingChargesMonthByCustomerID(String customerID, Date someDateOfAMonth);
	
	
}
