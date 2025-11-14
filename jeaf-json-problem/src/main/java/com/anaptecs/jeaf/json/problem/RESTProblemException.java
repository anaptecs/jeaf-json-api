/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.json.problem;

import java.io.InputStream;

import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.json.api.JSONTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Class represents an exceptions that was caused by a problem JSON object that was returned as response from a REST
 * call.
 * 
 * @author JEAF Development Team
 */
public class RESTProblemException extends JEAFSystemException {
  private static final long serialVersionUID = 1L;

  /**
   * Problem that was returned from a REST call. Attribute is never null.
   */
  private final Problem problem;

  /**
   * Initialize object
   * 
   * @param pProblem Problem that was received from a REST call. The parameter must not be null.
   */
  public RESTProblemException( Problem pProblem ) {
    super(JSONMessages.RECEIVED_REST_PROBLEM_JSON, String.valueOf(pProblem.getStatus()));

    problem = pProblem;
  }

  /**
   * Initialize object
   * 
   * @param pProblem Problem that was received from a REST call. The parameter must not be null.
   * @param pCause Exception that cause this problem. The parameter may be null.
   */
  public RESTProblemException( Problem pProblem, Throwable pCause ) {
    super(JSONMessages.RECEIVED_REST_PROBLEM_JSON, pCause, String.valueOf(pProblem.getStatus()));

    problem = pProblem;
  }

  /**
   * Initialize object.
   * 
   * @param pStatus HTTP status code in case that the REST resource did not return a problem JSON.
   */
  public RESTProblemException( int pStatus ) {
    super(JSONMessages.RECEIVED_REST_PROBLEM_JSON, String.valueOf(pStatus));

    problem = Problem.builder().setStatus(pStatus).build();
  }

  /**
   * Initialize object.
   * 
   * @param pStatus HTTP status code in case that the REST resource did not return a problem JSON.
   * @param pHttpResponseStream Input stream containing the response of the REST call.
   */
  public RESTProblemException( int pStatus, InputStream pHttpResponseStream ) {
    super(JSONMessages.RECEIVED_REST_PROBLEM_JSON, String.valueOf(pStatus));

    // Try to extract problem JSON from response stream.
    Problem lProblem;
    try {
      lProblem = JSONTools.getJSONTools().read(pHttpResponseStream, Problem.class);
    }
    // Server did not return problem JSON. At least we have a http status code.
    catch (JEAFSystemException e) {
      XFun.getTrace().warn(e);
      lProblem = Problem.builder().setStatus(pStatus).build();
    }
    problem = lProblem;
  }

  /**
   * Method returns a problem object describing the error that occurred. The problem object at least has an http error
   * code.
   * 
   * @return {@link Problem} Problem object that was received. The method never returns null.
   */
  public Problem getProblem( ) {
    return problem;
  }
}
