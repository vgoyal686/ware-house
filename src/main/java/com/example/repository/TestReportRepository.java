/**
 * @author Anurag
 * @description 
 */
package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.TestReport;;


/**
 * @author Anurag
 * @description 
 */
@Repository("testReportRepository")
public interface TestReportRepository extends JpaRepository<TestReport, Long> {
    TestReport findByBarcode(String barcode);
}
