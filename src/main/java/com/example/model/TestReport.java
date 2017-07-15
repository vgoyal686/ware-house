/**
 * @author Anurag
 * @description 
 */
package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Anurag
 * @description 
 */
@Entity
@Table(name = "TestReport")
public class TestReport {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
  @Column(name="Barcode")
  private String Barcode;
  
  @Column(name="Isc")
  private String Isc;
  
  @Column(name="Voc")
  private String Voc;
  
  @Column(name="Imp")
  private String Imp;
  
  @Column(name="Vmp")
  private String Vmp;
  
  @Column(name="Pmax")
  private String Pmax;
  
  @Column(name="Carton")
  private String Carton;
  
  @Column(name="Pallet")
  private String Pallet;
  
  @Column(name="CableLength")
  private String cableLength;
  
  @Column(name="Connector")
  private String Connector;
  
  @Column(name="Country")
  private String CountryOfOrigin;
  
  @Column(name="Current")
  private String CurrentSorting;

  /**
   * @author Anurag
   * @return the barcode
   */
  public String getBarcode() {
    return Barcode;
  }

  /**
   * @author Anurag
   * @param barcode the barcode to set
   */
  public void setBarcode(String barcode) {
    Barcode = barcode;
  }

  /**
   * @author Anurag
   * @return the isc
   */
  public String getIsc() {
    return Isc;
  }

  /**
   * @author Anurag
   * @param isc the isc to set
   */
  public void setIsc(String isc) {
    Isc = isc;
  }

  /**
   * @author Anurag
   * @return the voc
   */
  public String getVoc() {
    return Voc;
  }

  /**
   * @author Anurag
   * @param voc the voc to set
   */
  public void setVoc(String voc) {
    Voc = voc;
  }

  /**
   * @author Anurag
   * @return the imp
   */
  public String getImp() {
    return Imp;
  }

  /**
   * @author Anurag
   * @param imp the imp to set
   */
  public void setImp(String imp) {
    Imp = imp;
  }

  /**
   * @author Anurag
   * @return the vmp
   */
  public String getVmp() {
    return Vmp;
  }

  /**
   * @author Anurag
   * @param vmp the vmp to set
   */
  public void setVmp(String vmp) {
    Vmp = vmp;
  }

  /**
   * @author Anurag
   * @return the pmax
   */
  public String getPmax() {
    return Pmax;
  }

  /**
   * @author Anurag
   * @param pmax the pmax to set
   */
  public void setPmax(String pmax) {
    Pmax = pmax;
  }

  /**
   * @author Anurag
   * @return the carton
   */
  public String getCarton() {
    return Carton;
  }

  /**
   * @author Anurag
   * @param carton the carton to set
   */
  public void setCarton(String carton) {
    Carton = carton;
  }

  /**
   * @author Anurag
   * @return the pallet
   */
  public String getPallet() {
    return Pallet;
  }

  /**
   * @author Anurag
   * @param pallet the pallet to set
   */
  public void setPallet(String pallet) {
    Pallet = pallet;
  }

  /**
   * @author Anurag
   * @return the cableLength
   */
  public String getCableLength() {
    return cableLength;
  }

  /**
   * @author Anurag
   * @param cableLength the cableLength to set
   */
  public void setCableLength(String cableLength) {
    this.cableLength = cableLength;
  }

  /**
   * @author Anurag
   * @return the connector
   */
  public String getConnector() {
    return Connector;
  }

  /**
   * @author Anurag
   * @param connector the connector to set
   */
  public void setConnector(String connector) {
    Connector = connector;
  }

  /**
   * @author Anurag
   * @return the countryOfOrigin
   */
  public String getCountryOfOrigin() {
    return CountryOfOrigin;
  }

  /**
   * @author Anurag
   * @param countryOfOrigin the countryOfOrigin to set
   */
  public void setCountryOfOrigin(String countryOfOrigin) {
    CountryOfOrigin = countryOfOrigin;
  }

  /**
   * @author Anurag
   * @return the currentSorting
   */
  public String getCurrentSorting() {
    return CurrentSorting;
  }

  /**
   * @author Anurag
   * @param currentSorting the currentSorting to set
   */
  public void setCurrentSorting(String currentSorting) {
    CurrentSorting = currentSorting;
  }

  /**
   * @param barcode
   * @param isc
   * @param voc
   * @param imp
   * @param vmp
   * @param pmax
   * @param carton
   * @param pallet
   * @param cableLength
   * @param connector
   * @param countryOfOrigin
   * @param currentSorting
   */
  public TestReport(String barcode, String isc, String voc, String imp, String vmp, String pmax,
      String carton, String pallet, String cableLength, String connector, String countryOfOrigin,
      String currentSorting) {
    super();
    Barcode = barcode;
    Isc = isc;
    Voc = voc;
    Imp = imp;
    Vmp = vmp;
    Pmax = pmax;
    Carton = carton;
    Pallet = pallet;
    this.cableLength = cableLength;
    Connector = connector;
    CountryOfOrigin = countryOfOrigin;
    CurrentSorting = currentSorting;
  } 
  
  
}
