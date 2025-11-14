/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.json.api;

/**
 * Class is the entry point to access JEAF JSON functionality.
 * 
 * @author JEAF Development Team
 */
public class JSON {
  /**
   * Method returns JSONTools implementation as it was configured.
   * 
   * @return {@link JSONTools} JSONTools implementation. The method never returns null.
   */
  public static JSONTools getJSONTools( ) {
    return JSONTools.getJSONTools();
  }
}
