/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.json.api.test;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;

import com.anaptecs.jeaf.json.api.JSONTools;
import com.anaptecs.jeaf.json.api.ObjectType;
import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import tools.jackson.databind.ObjectMapper;

@ToolsImplementation(toolsInterface = JSONTools.class)
public class TestJSONToolsImpl implements JSONTools {

  @Override
  public ObjectMapper getDefaultObjectMapper( ) {
    return null;
  }

  @Override
  public void writeObject(Object pObject, OutputStream pOutputStream) throws JEAFSystemException {
  }

  @Override
  public void writeObject(Object pObject, Writer pWriter) throws JEAFSystemException {
  }

  @Override
  public void writeObject(Object pObject, File pFile) throws JEAFSystemException {
  }

  @Override
  public String writeObjectToString(Object pObject) throws JEAFSystemException {
    return null;
  }

  @Override
  public byte[] writeObjectToBytes(Object pObject) throws JEAFSystemException {
    return null;
  }

  @Override
  public void writeObjects(Collection<?> pObjects, OutputStream pOutputStream, Class<?> pObjectType)
    throws JEAFSystemException {
  }

  @Override
  public void writeObjects(Collection<?> pObjects, Writer pWriter, Class<?> pObjectType) throws JEAFSystemException {
  }

  @Override
  public void writeObjects(Collection<?> pObjects, File pFile, Class<?> pObjectType) throws JEAFSystemException {
  }

  @Override
  public String writeObjectsToString(Collection<?> pObjects, Class<?> pObjectType) throws JEAFSystemException {
    return null;
  }

  @Override
  public byte[] writeObjectsToBytes(Collection<?> pObjects, Class<?> pObjectType) throws JEAFSystemException {
    return null;
  }

  @Override
  public <T> T read(InputStream pInputStream, Class<T> pType) throws JEAFSystemException {
    return null;
  }

  @Override
  public <T> T read(Reader pReader, Class<T> pType) throws JEAFSystemException {
    return null;
  }

  @Override
  public <T> T read(File pFile, Class<T> pType) throws JEAFSystemException {
    return null;
  }

  @Override
  public <T> T read(String pString, Class<T> pType) throws JEAFSystemException {
    return null;
  }

  @Override
  public <T> T read(byte[] pBytes, Class<T> pType) throws JEAFSystemException {
    return null;
  }

  @Override
  public <T> T read(String pString, ObjectType pResponseType) throws JEAFSystemException {
    return null;
  }

  @Override
  public <T> T read(byte[] pBytes, ObjectType pResponseType) throws JEAFSystemException {
    return null;
  }

  @Override
  public <T> T read(InputStream pInputStream, ObjectType pResponseType) throws JEAFSystemException {
    return null;
  }

  @Override
  public <T> T read(Reader pReader, ObjectType pResponseType) throws JEAFSystemException {
    return null;
  }

  @Override
  public <T> T read(File pFile, ObjectType pResponseType) throws JEAFSystemException {
    return null;
  }

  @Override
  public <T extends Collection<?>> T readToCollection(InputStream pInputStream, Class<T> pCollectionType,
      Class<?> pResultType)
    throws JEAFSystemException {
    return null;
  }

  @Override
  public <T extends Collection<?>> T readToCollection(Reader pReader, Class<T> pCollectionType, Class<?> pResultType)
    throws JEAFSystemException {
    return null;
  }

  @Override
  public <T extends Collection<?>> T readToCollection(File pFile, Class<T> pCollectionType, Class<?> pResultType)
    throws JEAFSystemException {
    return null;
  }

  @Override
  public <T extends Collection<?>> T readToCollection(String pJSONString, Class<T> pCollectionType,
      Class<?> pResultType)
    throws JEAFSystemException {
    return null;
  }

  @Override
  public <T extends Collection<?>> T readToCollection(byte[] pBytes, Class<T> pCollectionType, Class<?> pResultType)
    throws JEAFSystemException {
    return null;
  }

  @Override
  public <T extends Collection<?>> T readToCollection(InputStream pInputStream, Class<T> pCollectionType,
      ObjectType pObjectType)
    throws JEAFSystemException {
    return null;
  }

  @Override
  public <T extends Collection<?>> T readToCollection(Reader pReader, Class<T> pCollectionType,
      ObjectType pObjectType)
    throws JEAFSystemException {
    return null;
  }

  @Override
  public <T extends Collection<?>> T readToCollection(File pFile, Class<T> pCollectionType, ObjectType pObjectType)
    throws JEAFSystemException {
    return null;
  }

  @Override
  public <T extends Collection<?>> T readToCollection(String pJSONString, Class<T> pCollectionType,
      ObjectType pObjectType)
    throws JEAFSystemException {
    return null;
  }

  @Override
  public <T extends Collection<?>> T readToCollection(byte[] pBytes, Class<T> pCollectionType, ObjectType pObjectType)
    throws JEAFSystemException {
    return null;
  }
}
