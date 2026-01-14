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
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.MapperFeature;
import tools.jackson.databind.SerializationFeature;

/**
 * Annotation can be used to configured the JSON object mapper according to your needs. If you do not define an explicit
 * configuration the default settings will be used which should fit for most needs.
 *
 * For special date handling during JSON serialization please refer to: https://www.baeldung.com/jackson-serialize-dates
 *
 * @author JEAF Development Team
 */
@Retention(RUNTIME)
@Target(TYPE)
@Documented
public @interface ObjectMapperConfig {
  /**
   * Name of the resource that contains the name of the class with the @XFunConfig annotation.
   */
  String OBJECT_MAPPER_CONFIG_RESOURCE_NAME = "ObjectMapperConfig";

  /**
   * Path under which the configuration file is stored.
   */
  String OBJECT_MAPPER_CONFIG_PATH = JSONTools.JSON_BASE_PATH + '/' + OBJECT_MAPPER_CONFIG_RESOURCE_NAME;

  /**
   * Attribute can be used to configure minimum visibility of fields which will be directly accessed when serializing
   * objects. By default all non-transient non-static fields will be serialized no matter what visibility they have.
   */
  JsonAutoDetect.Visibility defaultFieldVisibility() default JsonAutoDetect.Visibility.ANY;

  /**
   * Attribute can be used to configure the minimum visibility of getters that should be used to resolve properties. By
   * default getters are not used.
   */
  JsonAutoDetect.Visibility defaultGetterVisibility() default JsonAutoDetect.Visibility.NONE;

  /**
   * Attribute can be used to configure the minimum visibility of setters that should be used to set properties. By
   * default setters are not used.
   */
  JsonAutoDetect.Visibility defaultSetterVisibility() default JsonAutoDetect.Visibility.NONE;

  /**
   * Attribute can be used to configure the minimum visibility of creation methods (constructors, factory methods). By
   * default visibility is not relevant.
   */
  JsonAutoDetect.Visibility defaultCreatorVisibility() default JsonAutoDetect.Visibility.ANY;

  /**
   * Attribute can be used to define which properties should be included when an object is serialized to JSON. By
   * default all non empty attributes will be included. This settings differs from Jackson's default values in order to
   * reduce content to what is really needed.
   */
  JsonInclude.Include defaultPropertyInclusion() default JsonInclude.Include.NON_EMPTY;

  /**
   * Attribute can be used to explicitly enable features of the ObjectMapper.
   */
  MapperFeature[] enabledMapperFeatures() default {};

  /**
   * Attribute can be used to explicitly disable features of the ObjectMapper.
   */
  MapperFeature[] disabledMapperFeatures() default {};

  /**
   * Attribute can be used to explicitly enable serialization features of the ObjectMapper.
   */
  SerializationFeature[] enabledSerializationFeatures() default {};

  /**
   * Attribute can be used to explicitly disable serialization features of the ObjectMapper.
   */
  SerializationFeature[] disabledSerializationFeatures() default {};

  /**
   * Attribute can be used to explicitly enable deserialization features of the ObjectMapper.
   */
  DeserializationFeature[] enabledDeserializationFeatures() default {};

  /**
   * Attribute can be used to explicitly disable deserialization features of the ObjectMapper.
   */
  DeserializationFeature[] disabledDeserializationFeatures() default {
    DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES };

  // Date-Handling: https://www.baeldung.com/jackson-serialize-dates
}
