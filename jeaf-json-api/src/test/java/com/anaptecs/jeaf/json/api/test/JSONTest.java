/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.json.api.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Collection;
import java.util.Set;

import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.json.api.JSONTools;
import com.anaptecs.jeaf.json.api.ObjectType;
import com.anaptecs.jeaf.json.api.ObjectType.CollectionObjectType;
import com.anaptecs.jeaf.json.api.ObjectType.SingleObjectType;
import org.junit.jupiter.api.Test;

class JSONTest {

  @Test
  void testJSONAccess( ) {
    JSONTools lTools = JSONTools.getJSONTools();
    assertEquals(TestJSONToolsImpl.class, lTools.getClass());
  }

  @Test
  void testMessages( ) {
    assertEquals("Exception during JSON serialization. Additional Message",
        JSONMessages.JSON_SERIALIZATION_FAILED.toString("Additional Message"));
    assertEquals("Exception during JSON deserialization. Additional Message",
        JSONMessages.JSON_DESERIALIZATION_FAILED.toString("Additional Message"));
  }

  @Test
  void testObjectType( ) {
    // Test single object type.
    SingleObjectType lSingleObjectType = (SingleObjectType) ObjectType.createObjectType(String.class);
    assertNotNull(lSingleObjectType);
    assertEquals(String.class, lSingleObjectType.getObjectType());

    // Check null handling
    try {
      ObjectType.createObjectType(null);
      fail();
    }
    catch (IllegalArgumentException e) {
      assertEquals("Check failed. pObjectType must not be NULL.", e.getMessage());
    }

    // Test collection object type.
    CollectionObjectType lCollectionObjectType =
        (CollectionObjectType) ObjectType.createObjectType(Set.class, Integer.class);
    assertNotNull(lCollectionObjectType);
    assertEquals(Set.class, lCollectionObjectType.getCollectionType());
    assertEquals(Integer.class, lCollectionObjectType.getObjectType());

    try {
      ObjectType.createObjectType(Collection.class, null);
      fail();
    }
    catch (IllegalArgumentException e) {
      assertEquals("Check failed. pObjectType must not be NULL.", e.getMessage());
    }
    try {
      ObjectType.createObjectType(null, Long.class);
      fail();
    }
    catch (IllegalArgumentException e) {
      assertEquals("Check failed. pCollectionType must not be NULL.", e.getMessage());
    }
  }
}
