package com.anaptecs.jeaf.json.api;

import com.anaptecs.jeaf.xfun.annotations.MessageResource;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.ErrorCode;
import com.anaptecs.jeaf.xfun.api.messages.MessageRepository;

/**
 * Class contains all generated constants for messages of JEAF JSON
 *
 * @author JEAF Development Team
 * @version 1.0
 */
@MessageResource(path = "JSONMessages.xml")
public final class JSONMessages {
  /**
   * Constant for XML file that contains all messages that are defined within this class.
   */
  private static final String MESSAGE_RESOURCE = "JSONMessages.xml";

  /**
   * Exceptions with this error code are thrown in case that an exception occurs during JSON serialization of an object.
   */
  public static final ErrorCode JSON_SERIALIZATION_FAILED;

  /**
   * Exceptions with this error code are thrown in case that an exception occurs during JSON deserialization of an
   * object.
   */
  public static final ErrorCode JSON_DESERIALIZATION_FAILED;

  /**
   * AbstractObjectIDDeserializer expects Object-IDs to be serialized as text only. If it was serialized as real object
   * then exception with this error code will be thrown.
   */
  public static final ErrorCode UNEXPECTED_NODE_TYPE_FOR_OBJECT_ID_DESERIAL;

  /**
   * Exceptions with this error code are thrown in case that unexpected node type is part of the JSON data that should
   * be deserialized.
   */
  public static final ErrorCode UNEXPECTED_NODE_TYPE_FOR_DESERIALIZATION;

  /**
   * Exceptions with this error code are thrown in case that a REST call returned a problem JSON instead of a real
   * response.
   */
  public static final ErrorCode RECEIVED_REST_PROBLEM_JSON;

  /**
   * Exceptions with this error code are thrown in case that a REST response could not be processed on client side due
   * to some problem.
   */
  public static final ErrorCode REST_RESPONSE_PROCESSING_ERROR;

  /**
   * This error code is used in case that a http response object could not be closed properly.
   */
  public static final ErrorCode UNABLE_TO_CLOSE_HTTP_RESPONSE;

  /**
   * This error code is used in case that a circuit breaker for external REST services is open.
   */
  public static final ErrorCode CIRCUIT_BREAKER_OPEN;

  /**
   * This error code is used in case that a circuit breaker is not protecting the system due to ist state.
   */
  public static final ErrorCode CIRCUIT_BREAKER_NOT_ACTIVE;
  /**
   * Static initializer contains initialization for all generated constants.
   */
  static {
    MessageRepository lRepository = XFun.getMessageRepository();
    lRepository.loadResource(MESSAGE_RESOURCE);
    // Handle all info messages.
    // Handle all messages for errors.
    JSON_SERIALIZATION_FAILED = lRepository.getErrorCode(1800);
    JSON_DESERIALIZATION_FAILED = lRepository.getErrorCode(1801);
    UNEXPECTED_NODE_TYPE_FOR_OBJECT_ID_DESERIAL = lRepository.getErrorCode(1802);
    UNEXPECTED_NODE_TYPE_FOR_DESERIALIZATION = lRepository.getErrorCode(1803);
    RECEIVED_REST_PROBLEM_JSON = lRepository.getErrorCode(1804);
    REST_RESPONSE_PROCESSING_ERROR = lRepository.getErrorCode(1805);
    UNABLE_TO_CLOSE_HTTP_RESPONSE = lRepository.getErrorCode(1806);
    CIRCUIT_BREAKER_OPEN = lRepository.getErrorCode(1807);
    CIRCUIT_BREAKER_NOT_ACTIVE = lRepository.getErrorCode(1808);
    // Handle all localized strings.
  }

  /**
   * Constructor is private to ensure that no instances of this class will be created.
   */
  private JSONMessages( ) {
    // Nothing to do.
  }
}