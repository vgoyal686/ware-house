/**
 * @author Anurag
 * @description 
 */
package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.model.OrderRequest;

/**
 * @author Anurag
 * @description
 */
public interface IOrderRequestService
{
	public Boolean saveOrderRequest(OrderRequest orderRequest);

	public OrderRequest saveAndGetOrderRequest(OrderRequest orderRequest);

	public List<OrderRequest> findByCustomerID(String customerID);

	public List<OrderRequest> listByCustomerID(String customerID);

	public List<OrderRequest> findAllOrderRequest();

	public Page<OrderRequest> getAllOrderRequestWithPagination(Pageable pageable);

	boolean findById(Long id);

	public List<OrderRequest> findByCustomerIDOrderByCreatedDesc(String customerID);
	public Page<OrderRequest> findByCustomerIDOrderByCreatedDesc(String customerID, Pageable pageable);

}
