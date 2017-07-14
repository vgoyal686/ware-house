/**
 * @author Anurag
 * @description 
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.OrderRequest;

/**
 * @author Anurag
 * @description 
 */
@Repository("orderRequestRepository")
public interface IOrderRequestRepository extends JpaRepository<OrderRequest, Long> {

  OrderRequest findByCustomerID(String customerID);  

}
