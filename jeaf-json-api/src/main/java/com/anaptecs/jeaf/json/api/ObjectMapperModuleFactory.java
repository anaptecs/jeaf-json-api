/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.json.api;

import tools.jackson.databind.JacksonModule;
import tools.jackson.databind.ObjectMapper;

/**
 * Interface defines a factory that can be used to create {@link Module}s for {@link ObjectMapper}s. In addition to the
 * methods defined by the interface it is also required that implementations provide a public default constructor.
 *
 * @author JEAF Development Team
 *
 */
public interface ObjectMapperModuleFactory {
  /**
   * Method ceates a new {@link Module} that will be added to the ObjectMaper that is used to convert Java objects to
   * JSON and vice versa
   *
   * @return
   */
  JacksonModule createModule( );
}
