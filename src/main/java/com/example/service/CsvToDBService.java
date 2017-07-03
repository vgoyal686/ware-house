/**
 * @author Anurag
 * @description 
 */
package com.example.service;


/**
 * @author Anurag
 * @description 
 */
public class CsvToDBService {

  public String getSampleCsvPath() {    
    return "src/main/resources/sample_product.csv";
  }
  
  public String getCreateTableString() {
    String headers = "Barcode NO.,Isc(A),Voc(V),Imp(A),Vmp(V),Pmax(W),Carton NO.,Pallet NO.,Cable Length,Connector,Country of Origin,Current Sorting";
    headers = headers.replaceAll(" ", "_");
    headers = headers.replaceAll("\\.", "");
    headers = headers.replaceAll("\\(", "_");
    headers = headers.replaceAll("\\)", "");
    String replaceKeyWord = " VARCHAR(255),";
    String createTablePrefix = "CREATE TABLE IF NOT EXISTS SAMPLE (";
    String createTablePostfix = "  VARCHAR(255) )";
    String createTableString =  headers.replaceAll(",", replaceKeyWord);
    createTableString =  createTablePrefix + createTableString + createTablePostfix;
    System.out.println(createTableString);
    return createTableString;
  }

  public String getCsvToDBTableString() {
    
    String sql = "LOAD DATA LOCAL INFILE '/Users/anurag/Documents/freelancing/ware-house/src/main/resources/sample_product.csv' "
              +" INTO TABLE SAMPLE "
              +" FIELDS TERMINATED BY ',' " 
              +" LINES TERMINATED BY '\n' "
              +" IGNORE 1 LINES;";
    
    System.out.println(sql);
    return sql;
  }
  public static void main(String[] args) {
    
    CsvToDBService csvToDBService = new CsvToDBService();
    
    String createTableString = csvToDBService.getCreateTableString();
    JDBCExample.exceuteQuery(createTableString);
    
    String csvToDBTableString = csvToDBService.getCsvToDBTableString();
    JDBCExample.exceuteQuery(csvToDBTableString);
  }
}
