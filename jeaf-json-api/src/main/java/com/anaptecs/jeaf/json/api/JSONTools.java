/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.json.api;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.List;

import com.anaptecs.jeaf.json.annotations.ModuleFactory;
import com.anaptecs.jeaf.json.annotations.ObjectMapperConfig;
import com.anaptecs.jeaf.tools.api.ToolsLoader;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Interface defines a set of method that simplify serialization and deserialization of objects into and from JSON.
 * 
 * Please be aware that when deserializing collections back to Java objects <code>readToList(...)</code> methods need to
 * be used instead of standard <code>read(...)</code> method. For further explanation about that please refer to:
 * https://www.baeldung.com/jackson-collection-array
 * 
 * @author JEAF Development Team
 */
public interface JSONTools {
  /**
   * Name of the base path under which all X-Fun configuration files are located.
   */
  final String JSON_BASE_PATH = "META-INF/JEAF/JSON";

  /**
   * Configured implementation of JSON tools.
   */
  final JSONTools JSON_TOOLS = ToolsLoader.getTools(JSONTools.class);

  /**
   * Method returns the configured implementation of the JSON Tools.
   * 
   * @return {@link JSONTools} Configured implementation of JSON tools. The method never returns null.
   */
  static JSONTools getJSONTools( ) {
    return JSON_TOOLS;
  }

  /**
   * Method returns a JSON {@link ObjectMapper} that is configured as defined using {@link ObjectMapperConfig} and
   * {@link ModuleFactory}.
   * 
   * @return {@link ObjectMapper} Object mapper that should be used for JSON serialization.
   */
  ObjectMapper getDefaultObjectMapper( );

  /**
   * Method serializes the passed object to the passed stream.
   * 
   * @param pObject Object that should be serialized as JSON. The parameter may be null.
   * @param pOutputStream Stream to which the object should be written. The parameter must not be null.
   * @throws JEAFSystemException if an error occurs during serialization
   */
  void writeObject( Object pObject, OutputStream pOutputStream ) throws JEAFSystemException;

  /**
   * Method serializes the passed object to the passed writer.
   * 
   * @param pObject Object that should be serialized as JSON. The parameter may be null.
   * @param pWriter Writer to which the object should be written. The parameter must not be null.
   * @throws JEAFSystemException if an error occurs during serialization
   */
  void writeObject( Object pObject, Writer pWriter ) throws JEAFSystemException;

  /**
   * Method serializes the passed object to the passed file.
   * 
   * @param pObject Object that should be serialized as JSON. The parameter may be null.
   * @param pFile File to which the object should be written. The parameter must not be null.
   * @throws JEAFSystemException if an error occurs during serialization
   */
  void writeObject( Object pObject, File pFile ) throws JEAFSystemException;

  /**
   * Method serializes the passed object as string.
   * 
   * @param pObject Object that should be serialized as JSON. The parameter may be null.
   * @return {@link String} JSON serialized object as String. The method never returns null.
   * @throws JEAFSystemException if an error occurs during serialization
   */
  String writeObjectToString( Object pObject ) throws JEAFSystemException;

  /**
   * Method serializes the passed object as byte array.
   * 
   * @param pObject Object that should be serialized as JSON. The parameter may be null.
   * @return byte[] JSON serialized object as byte array. The method never returns null.
   * @throws JEAFSystemException if an error occurs during serialization
   */
  byte[] writeObjectToBytes( Object pObject ) throws JEAFSystemException;

  /**
   * Method serializes the passed {@link Collection} to the passed stream.
   * 
   * @param pObjects Collection of objects that should be serialized as JSON. The parameter may be null.
   * @param pOutputStream Stream to which the object should be written. The parameter must not be null.
   * @param pObjectType {@link Class} object representing the type of objects that are inside the collection. As type
   * info of Java generics is not present at runtime this information has to be passed as additional parameter.
   * @throws JEAFSystemException if an error occurs during serialization
   */
  void writeObjects( Collection<?> pObjects, OutputStream pOutputStream, Class<?> pObjectType )
    throws JEAFSystemException;

  /**
   * Method serializes the passed {@link Collection} to the passed writer.
   * 
   * @param pObjects Collection of objects that should be serialized as JSON. The parameter may be null.
   * @param pWriter Writer to which the object should be written. The parameter must not be null.
   * @param pObjectType {@link Class} object representing the type of objects that are inside the collection. As type
   * info of Java generics is not present at runtime this information has to be passed as additional parameter.
   * @throws JEAFSystemException if an error occurs during serialization
   */
  void writeObjects( Collection<?> pObjects, Writer pWriter, Class<?> pObjectType ) throws JEAFSystemException;

  /**
   * Method serializes the passed {@link Collection} to the passed file.
   * 
   * @param pObjects Collection of objects that should be serialized as JSON. The parameter may be null.
   * @param pFile File to which the object should be written. The parameter must not be null.
   * @param pObjectType {@link Class} object representing the type of objects that are inside the collection. As type
   * info of Java generics is not present at runtime this information has to be passed as additional parameter.
   * @throws JEAFSystemException if an error occurs during serialization
   */
  void writeObjects( Collection<?> pObjects, File pFile, Class<?> pObjectType ) throws JEAFSystemException;

  /**
   * Method serializes the passed {@link Collection} as string.
   * 
   * @param pObjects Collection of objects that should be serialized as JSON. The parameter may be null.
   * @param pObjectType {@link Class} object representing the type of objects that are inside the collection. As type
   * info of Java generics is not present at runtime this information has to be passed as additional parameter.
   * @return {@link String} JSON serialized object as String. The method never returns null.
   * @throws JEAFSystemException if an error occurs during serialization
   */
  String writeObjectsToString( Collection<?> pObjects, Class<?> pObjectType ) throws JEAFSystemException;

  /**
   * Method serializes the passed {@link Collection} as byte array.
   * 
   * @param pObjects Collection of objects that should be serialized as JSON. The parameter may be null.
   * @param pObjectType {@link Class} object representing the type of objects that are inside the collection. As type
   * info of Java generics is not present at runtime this information has to be passed as additional parameter.
   * @return {@link String} JSON serialized object as String. The method never returns null.
   * @throws JEAFSystemException if an error occurs during serialization
   */
  byte[] writeObjectsToBytes( Collection<?> pObjects, Class<?> pObjectType ) throws JEAFSystemException;

  /**
   * Method deserializes the passed string into an object of the passed type.
   * 
   * @param pContent String from which the data should be read. The parameter must not be null.
   * @param pResultType Type of the object that should be created. The parameter must not be null.
   * @return T Object of passed type that was created. The method may return null if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T> T read( String pContent, Class<T> pResultType ) throws JEAFSystemException;

  /**
   * Method deserializes the passed byte array into an object of the passed type.
   * 
   * @param pBytes Byte array from which the data should be read. The parameter must not be null.
   * @param pResultType Type of the object that should be created. The parameter must not be null.
   * @return T Object of passed type that was created. The method may return null if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T> T read( byte[] pBytes, Class<T> pResultType ) throws JEAFSystemException;

  /**
   * Method deserializes the data of passed stream into an object of the passed type.
   * 
   * @param pInputStream Stream from which the data should be read. The parameter must not be null.
   * @param pResultType Type of the object that should be created. The parameter must not be null.
   * @return T Object of passed type that was created. The method may return null if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T> T read( InputStream pInputStream, Class<T> pResultType ) throws JEAFSystemException;

  /**
   * Method deserializes the data from the passed reader into an object of the passed type.
   * 
   * @param pReader Reader from which the data should be read. The parameter must not be null.
   * @param pResultType Type of the object that should be created. The parameter must not be null.
   * @return T Object of passed type that was created. The method may return null if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T> T read( Reader pReader, Class<T> pResultType ) throws JEAFSystemException;

  /**
   * Method deserializes the data from the passed file into an object of the passed type.
   * 
   * @param pFile File from which the data should be read. The parameter must not be null.
   * @param pResultType Type of the object that should be created. The parameter must not be null.
   * @return T Object of passed type that was created. The method may return null if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T> T read( File pFile, Class<T> pResultType ) throws JEAFSystemException;

  /**
   * Method deserializes the passed string into an object of the passed type.
   * 
   * @param pString String from which the data should be read. The parameter must not be null.
   * @param pResultType Type of the object that should be created. The parameter must not be null.
   * @return T Object of passed type that was created. The method may return null if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T> T read( String pString, ObjectType pResultType ) throws JEAFSystemException;

  /**
   * Method deserializes the passed byte array into an object of the passed type.
   * 
   * @param pBytes Byte array from which the data should be read. The parameter must not be null.
   * @param pResultType Type of the object that should be created. The parameter must not be null.
   * @return T Object of passed type that was created. The method may return null if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T> T read( byte[] pBytes, ObjectType pResultType ) throws JEAFSystemException;

  /**
   * Method deserializes the data of passed stream into an object of the passed type.
   * 
   * @param pInputStream Stream from which the data should be read. The parameter must not be null.
   * @param pResultType Type of the object that should be created. The parameter must not be null.
   * @return T Object of passed type that was created. The method may return null if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T> T read( InputStream pInputStream, ObjectType pResultType ) throws JEAFSystemException;

  /**
   * Method deserializes the data from the passed reader into an object of the passed type.
   * 
   * @param pReader Reader from which the data should be read. The parameter must not be null.
   * @param pResultType Type of the object that should be created. The parameter must not be null.
   * @return T Object of passed type that was created. The method may return null if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T> T read( Reader pReader, ObjectType pResultType ) throws JEAFSystemException;

  /**
   * Method deserializes the data from the passed file into an object of the passed type.
   * 
   * @param pFile File from which the data should be read. The parameter must not be null.
   * @param pResultType Type of the object that should be created. The parameter must not be null.
   * @return T Object of passed type that was created. The method may return null if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T> T read( File pFile, ObjectType pResultType ) throws JEAFSystemException;

  /**
   * Method deserializes the data of passed stream into a {@link List} of objects of the passed type.
   * 
   * @param pInputStream Stream from which the data should be read. The parameter must not be null.
   * @param pCollectionType Type of collection that should be used to store the created objects. The parameter must not
   * be null.
   * @param pResultType Type of the object that should be created. The parameter must not be null.
   * @return {@link List} List of objects of passed type that was created from the JSON data. The method may return null
   * if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T extends Collection<?>> T readToCollection( InputStream pInputStream, Class<T> pCollectionType,
      Class<?> pResultType )
    throws JEAFSystemException;

  /**
   * Method deserializes the data from the passed reader into a {@link List} of objects of the passed type.
   * 
   * @param pReader Reader from which the data should be read. The parameter must not be null.
   * @param pCollectionType Type of collection that should be used to store the created objects. The parameter must not
   * be null.
   * @param pResultType Type of the object that should be created. The parameter must not be null.
   * @return {@link List} List of objects of passed type that was created from the JSON data. The method may return null
   * if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T extends Collection<?>> T readToCollection( Reader pReader, Class<T> pCollectionType, Class<?> pResultType )
    throws JEAFSystemException;

  /**
   * Method deserializes the data from the passed file into a {@link List} of objects of the passed type.
   * 
   * @param pFile File from which the data should be read. The parameter must not be null.
   * @param pCollectionType Type of collection that should be used to store the created objects. The parameter must not
   * be null.
   * @param pResultType Type of the object that should be created. The parameter must not be null.
   * @return {@link List} List of objects of passed type that was created from the JSON data. The method may return null
   * if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T extends Collection<?>> T readToCollection( File pFile, Class<T> pCollectionType, Class<?> pResultType )
    throws JEAFSystemException;

  /**
   * Method deserializes the passed string into a {@link Collection} of objects of the passed type.
   * 
   * @param pJSONString String from which the data should be read. The parameter must not be null.
   * @param pCollectionType Type of collection that should be used to store the created objects. The parameter must not
   * be null.
   * @param pResultType Type of the object that should be created. The parameter must not be null.
   * @return {@link List} List of objects of passed type that was created from the JSON data. The method may return null
   * if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T extends Collection<?>> T readToCollection( String pJSONString, Class<T> pCollectionType, Class<?> pResultType )
    throws JEAFSystemException;

  /**
   * Method deserializes the passed string into a {@link List} of objects of the passed type.
   * 
   * @param pBytes Byte array from which the data should be read. The parameter must not be null.
   * @param pCollectionType Type of collection that should be used to store the created objects. The parameter must not
   * be null.
   * @param pResultType Type of the object that should be created. The parameter must not be null.
   * @return {@link List} List of objects of passed type that was created from the JSON data. The method may return null
   * if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T extends Collection<?>> T readToCollection( byte[] pBytes, Class<T> pCollectionType, Class<?> pResultType )
    throws JEAFSystemException;

  /**
   * Method deserializes the data of passed stream into a {@link List} of objects of the passed type.
   * 
   * @param pInputStream Stream from which the data should be read. The parameter must not be null.
   * @param pCollectionType Type of collection that should be used to store the created objects. The parameter must not
   * be null.
   * @param pObjectType Type of the object that should be created. The parameter must not be null.
   * @return {@link List} List of objects of passed type that was created from the JSON data. The method may return null
   * if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T extends Collection<?>> T readToCollection( InputStream pInputStream, Class<T> pCollectionType,
      ObjectType pObjectType )
    throws JEAFSystemException;

  /**
   * Method deserializes the data from the passed reader into a {@link List} of objects of the passed type.
   * 
   * @param pReader Reader from which the data should be read. The parameter must not be null.
   * @param pCollectionType Type of collection that should be used to store the created objects. The parameter must not
   * be null.
   * @param pObjectType Type of the object that should be created. The parameter must not be null.
   * @return {@link List} List of objects of passed type that was created from the JSON data. The method may return null
   * if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T extends Collection<?>> T readToCollection( Reader pReader, Class<T> pCollectionType, ObjectType pObjectType )
    throws JEAFSystemException;

  /**
   * Method deserializes the data from the passed file into a {@link List} of objects of the passed type.
   * 
   * @param pFile File from which the data should be read. The parameter must not be null.
   * @param pCollectionType Type of collection that should be used to store the created objects. The parameter must not
   * be null.
   * @param pObjectType Type of the object that should be created. The parameter must not be null.
   * @return {@link List} List of objects of passed type that was created from the JSON data. The method may return null
   * if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T extends Collection<?>> T readToCollection( File pFile, Class<T> pCollectionType, ObjectType pObjectType )
    throws JEAFSystemException;

  /**
   * Method deserializes the passed string into a {@link Collection} of objects of the passed type.
   * 
   * @param pJSONString String from which the data should be read. The parameter must not be null.
   * @param pCollectionType Type of collection that should be used to store the created objects. The parameter must not
   * be null.
   * @param pObjectType Type of the object that should be created. The parameter must not be null.
   * @return {@link List} List of objects of passed type that was created from the JSON data. The method may return null
   * if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T extends Collection<?>> T readToCollection( String pJSONString, Class<T> pCollectionType, ObjectType pObjectType )
    throws JEAFSystemException;

  /**
   * Method deserializes the passed string into a {@link List} of objects of the passed type.
   * 
   * @param pBytes Byte array from which the data should be read. The parameter must not be null.
   * @param pCollectionType Type of collection that should be used to store the created objects. The parameter must not
   * be null.
   * @param pObjectType Type of the object that should be created. The parameter must not be null.
   * @return {@link List} List of objects of passed type that was created from the JSON data. The method may return null
   * if null was serialized.
   * @throws JEAFSystemException if an error occurs during deserialization
   */
  <T extends Collection<?>> T readToCollection( byte[] pBytes, Class<T> pCollectionType, ObjectType pObjectType )
    throws JEAFSystemException;

}
