/**
 * @author Anurag
 * @description 
 */
package com.example.bean;

import org.springframework.web.multipart.commons.*;
/**
 * @author Anurag
 * @description 
 */
public class FileBean {

  private CommonsMultipartFile fileData;

  public CommonsMultipartFile getFileData()
  {
    return fileData;
  }

  public void setFileData(CommonsMultipartFile fileData)
  {
    this.fileData = fileData;
  }
}  