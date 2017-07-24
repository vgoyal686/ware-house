/**
 * @author Anurag
 * @description 
 */
package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Anurag
 * @description 
 */
public class Level1PK implements Serializable {
  
  protected String identifierID;

  protected String uom;

  /**
   * @param identifierID
   * @param uom
   */
  public Level1PK(String identifierID, String uom) {
    this.identifierID = identifierID;
    this.uom = uom;
  }
  
  public Level1PK() {}

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((identifierID == null) ? 0 : identifierID.hashCode());
    result = prime * result + ((uom == null) ? 0 : uom.hashCode());
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Level1PK other = (Level1PK) obj;
    if (identifierID == null) {
      if (other.identifierID != null) return false;
    } else if (!identifierID.equals(other.identifierID)) return false;
    if (uom == null) {
      if (other.uom != null) return false;
    } else if (!uom.equals(other.uom)) return false;
    return true;
  }
  
  
  
}
