/**
 * @author Anurag
 * @description 
 */
package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

}
