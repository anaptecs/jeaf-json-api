/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.json.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.anaptecs.jeaf.json.api.JSONTools;
import com.anaptecs.jeaf.json.api.ObjectMapperModuleFactory;

/**
 * Annotation is intended to mark {@link ObjectMapperModuleFactory} implementations so that they can be detected by JEAF
 * at runtime (e.g. with the help of JEAF Maven Plugin).
 * 
 * The annotation itself does not define any properties but it is required that classes with this annotation implement
 * interface {@link ObjectMapperModuleFactory}
 * 
 * @author JEAF Development Team
 */
@Retention(RUNTIME)
@Target(TYPE)
@Documented
public @interface ModuleFactory {
  /**
   * Name of the resource that contains the name of the class with the @XFunConfig annotation.
   */
  String MODULE_FACTORY_CONFIG_RESOURCE_NAME = "ModuleFactoryConfig";

  /**
   * Path under which the configuration file is stored.
   */
  String MODULE_FACTORY_CONFIG_PATH = JSONTools.JSON_BASE_PATH + '/' + MODULE_FACTORY_CONFIG_RESOURCE_NAME;

}
