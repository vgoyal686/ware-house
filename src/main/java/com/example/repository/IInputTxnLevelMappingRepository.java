package com.example.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.InputTxnLevelMapping;

/**
 * @author Anurag
 * @description 
 */
@Repository("inputTxnLevelMappingRepository")
public interface IInputTxnLevelMappingRepository extends JpaRepository<InputTxnLevelMapping, Long> {

//  InputTxnLevelMapping findByCustomerID(String customerID);  
//  InputTxnLevelMapping findByWarehouseID(String warehouseID);
//  InputTxnLevelMapping findByOrderID(String orderID);
  
  List<InputTxnLevelMapping> findByCustomerID(String customerID);  
  List<InputTxnLevelMapping> findByWarehouseID(String warehouseID);
  List<InputTxnLevelMapping> findByOrderID(String orderID);
  
//  InputTxnLevelMapping findByLevel1Value(String level1Value);
//  InputTxnLevelMapping findByLevel2Value(String level2Value);
//  InputTxnLevelMapping findByLevel3Value(String level3Value);
  
  List<InputTxnLevelMapping> findByLevel1Value(String level1Value);
  List<InputTxnLevelMapping> findByLevel2Value(String level2Value); 
  List<InputTxnLevelMapping> findByLevel3Value(String level3Value); 
  
  @EntityGraph(value = "InputTxnLevelMapping.detail", type = EntityGraphType.LOAD)
  public List<InputTxnLevelMapping> findByLevel1NameAndLevel1Value(String level1Name, String level1Value);
  
  @EntityGraph(attributePaths = { "inputTxn" })
  public List<InputTxnLevelMapping> findByLevel2NameAndLevel2Value(String level2Name, String level2Value);
  
  @EntityGraph(value = "InputTxnLevelMapping.detail", type = EntityGraphType.LOAD)
  public List<InputTxnLevelMapping> findByLevel3NameAndLevel3Value(String level3Name, String level3Value);

  public Page<InputTxnLevelMapping> findByLevel1NameAndLevel1Value(String level1Name, String level1Value, Pageable pageable);
  public Page<InputTxnLevelMapping> findByLevel2NameAndLevel2Value(String level2Name, String level2Value, Pageable pageable);
  public Page<InputTxnLevelMapping> findByLevel3NameAndLevel3Value(String level3Name, String level3Value, Pageable pageable);

}
