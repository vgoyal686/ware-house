/**
 * @author Anurag
 * @description 
 */
package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.OrderRequest;
import com.example.repository.IOrderRequestRepository;

/**
 * @author Anurag
 * @description
 */
@Service("orderRequestService")
public class OrderRequestServiceImpl implements IOrderRequestService
{

	@Autowired
	private IOrderRequestRepository orderRequestRepository;

	@Override
	public Boolean saveOrderRequest(OrderRequest orderRequest)
	{

		try
		{
			orderRequestRepository.save(orderRequest);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public OrderRequest saveAndGetOrderRequest(OrderRequest orderRequest)
	{

		return orderRequestRepository.save(orderRequest);
	}

	@Override
    public List<OrderRequest> findByOrderID(int orderID){
      return orderRequestRepository.findByOrderID(orderID);
    }
	
	@Override
    public List<OrderRequest> findByOrderIDIn(List<Integer> orderID){
	  return orderRequestRepository.findByOrderIDIn(orderID);
	}
	
	@Override
	public List<OrderRequest> findByCustomerID(String customerID)
	{
	   return orderRequestRepository.findByCustomerID(customerID);
	}

	
	  @Override
	  public List<OrderRequest> findByCustomerIDAndInOrderType(String customerID) {
	    
	    return orderRequestRepository.findByCustomerIDAndOrderType(customerID, "in");
	  }

	  @Override
	  public List<OrderRequest> findByCustomerIDAndOutOrderType(String customerID) {

	    return orderRequestRepository.findByCustomerIDAndOrderType(customerID, "out");
	  }
	
	@Override
	public boolean findById(Long id)
	{

		return orderRequestRepository.exists(id);
	}

	@Override
	public List<OrderRequest> listByCustomerID(String customerID)
	{

		return orderRequestRepository.findByCustomerID(customerID);
	}

	@Override
	public List<OrderRequest> findAllOrderRequest()
	{

		return orderRequestRepository.findAll();
	}

	@Override
	public Page<OrderRequest> getAllOrderRequestWithPagination(Pageable pageable)
	{
		Page<OrderRequest> blogList = orderRequestRepository.findAll(pageable);
		return blogList;
	}

  @Override
  public List<OrderRequest> findByCustomerIDOrderByCreatedDesc(String customerID) {
    
    return orderRequestRepository.findByCustomerIDOrderByCreatedDesc(customerID);
  }

  @Override
  public Page<OrderRequest> findByCustomerIDOrderByCreatedDesc(String customerID,
      Pageable pageable) {

    return orderRequestRepository.findByCustomerIDOrderByCreatedDesc(customerID, pageable);
  }


}
