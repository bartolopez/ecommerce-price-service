package es.ecommerce.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * REST exception handler
 *
 * Used with BaseException errors and any other generic exception
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BaseRestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Default constructor
	 */
	public BaseRestResponseEntityExceptionHandler() {
		super();
	}

	/**
	 * Handler method for BaseException
	 *
	 * @param exception
	 *            the exception
	 * @param request
	 *            the request
	 * @return the error message
	 */
	@ExceptionHandler(value = { BaseException.class })
	protected ResponseEntity<Object> handleBaseException(BaseException exception, WebRequest request) {

		// By default the HTTP status is a 400 error
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		ErrorResponseDto errorResponse = new ErrorResponseDto();

		if (exception != null) {

			// If the exception has additional info, create the message
			errorResponse.setCode(exception.getCode().trim());
			errorResponse.setMessage(exception.getMessage());

			// Custom HTTP status code
			if (exception.getHttpStatusCode() != null) {
				httpStatus = exception.getHttpStatusCode();
			}

		} else {
			// If the exception is null create a new generic exception
			exception = new BaseException(BaseCodeException.UNEXPECTED_ERROR);
		}

		// Log the exception
		this.logger.error(exception.getMessage(), exception);

		// Handle and throw the exception message
		return this.handleExceptionInternal(exception, errorResponse, new HttpHeaders(), httpStatus, request);
	}

	/**
	 * Handler method for Exception in order to transform it into a BaseException
	 *
	 * @param exception
	 *            Exception
	 * @param request
	 *            Web request
	 * @return Error message
	 */
	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleAnyException(Exception exception, WebRequest request) {

		BaseException baseException = new BaseException(exception);

		return this.handleBaseException(baseException, request);
	}

}