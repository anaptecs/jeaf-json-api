/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.json.problem.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.anaptecs.jeaf.json.problem.Problem;
import com.anaptecs.jeaf.json.problem.Problem.Builder;
import com.anaptecs.jeaf.json.problem.RESTProblemException;
import org.junit.jupiter.api.Test;

public class ProblemTest {
  @Test
  void testProblem( ) {
    // Test Problem creation
    Builder lBuilder = Problem.builder();
    Problem lProblem = lBuilder.setType("PROBLEM-123456789").setDetail("Some detail").setStatus(400).setTitle(
        "Yet another Problem!").setInstance("Instance Information").build();
    assertEquals("PROBLEM-123456789", lProblem.getType());
    assertEquals("Some detail", lProblem.getDetail());
    assertEquals(400, lProblem.getStatus());
    assertEquals("Yet another Problem!", lProblem.getTitle());
    assertEquals("Instance Information", lProblem.getInstance());
    assertEquals("{\n" + "  \"type\": \"PROBLEM-123456789\",\n" + "  \"title\": \"Yet another Problem!\",\n"
        + "  \"status\": 400,\n" + "  \"detail\": \"Some detail\",\n" + "  \"instance\": \"Instance Information\"\n"
        + "}", lProblem.toString());

    lProblem = Problem.builder(lProblem).build();
    assertEquals("PROBLEM-123456789", lProblem.getType());
    assertEquals("Some detail", lProblem.getDetail());
    assertEquals(400, lProblem.getStatus());
    assertEquals("Yet another Problem!", lProblem.getTitle());
    assertEquals("Instance Information", lProblem.getInstance());

    // Test default value.
    lProblem = Problem.builder().build();
    assertEquals("about:blank", lProblem.getType());
    assertNull(lProblem.getDetail());
    assertEquals(0, lProblem.getStatus());
    assertEquals("Unknown HTTP Status", lProblem.getTitle());
    assertNull(lProblem.getInstance());
    assertEquals("{\n" + "  \"type\": \"about:blank\",\n" + "  \"title\": \"Unknown HTTP Status\",\n"
        + "  \"status\": 0\n" + "}", lProblem.toString());

    lProblem = new Problem();
    assertEquals("about:blank", lProblem.getType());
    assertNull(lProblem.getDetail());
    assertEquals(0, lProblem.getStatus());
    assertNull(lProblem.getTitle());
    assertNull(lProblem.getInstance());

  }

  @Test
  void testRESTProblemException( ) {
    RESTProblemException lProblemException = new RESTProblemException(400);
    assertTrue(lProblemException.getMessage().endsWith("REST call returned problem JSON (http status code: 400)"));
    Problem lProblem = lProblemException.getProblem();
    assertNotNull(lProblem);
    assertEquals("about:blank", lProblem.getType());
    assertEquals("Bad Request", lProblem.getTitle());
    assertEquals(400, lProblem.getStatus());
    assertEquals(null, lProblem.getDetail());
    assertEquals(null, lProblem.getInstance());

    lProblemException =
        new RESTProblemException(Problem.builder().setType("PROBLEM-123456789").setDetail("Some detail").setStatus(400)
            .setTitle("Yet another Problem!").setInstance("Instance Information").build());
    lProblem = lProblemException.getProblem();
    assertEquals("PROBLEM-123456789", lProblem.getType());
    assertEquals("Some detail", lProblem.getDetail());
    assertEquals(400, lProblem.getStatus());
    assertEquals("Yet another Problem!", lProblem.getTitle());
    assertEquals("Instance Information", lProblem.getInstance());
  }
}
