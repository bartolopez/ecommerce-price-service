package es.ecommerce.exception;

import org.springframework.http.HttpStatus;

/**
 * Base exception that defines the custom runtime exception
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 156114868211761034L;

	private static final String COLON_SPACE = ": ";

	/** Code of the exception type */
	private final CodeException baseCodeException;

	/** Exception message */
	private final String exceptionMessage;

	/** HTTP status code custom */
	private final HttpStatus httpStatusCode;

	/**
	 * Default constructor. Uses the exception with unexpected error
	 */
	public BaseException() {

		this(BaseCodeException.UNEXPECTED_ERROR);
	}

	/**
	 * Constructor with code exception
	 *
	 * @param codeException
	 *            Exception code
	 */
	public BaseException(CodeException codeException) {

		this(codeException, null, null, HttpStatus.valueOf(((BaseCodeException) codeException).getHttpStatusCode()));
	}

	/**
	 * Constructor with code exception and error message
	 *
	 * @param codeException
	 *            Exception code
	 * @param message
	 *            Message with error
	 */
	public BaseException(CodeException codeException, String message) {

		this(codeException, message, null, HttpStatus.valueOf(((BaseCodeException) codeException).getHttpStatusCode()));
	}

	/**
	 * Constructor with code exception, error message and original exception
	 *
	 * @param codeException
	 *            Exception code
	 * @param message
	 *            Message with error
	 * @param cause
	 *            Original exception
	 */
	public BaseException(CodeException codeException, String message, Throwable cause) {

		this(codeException, message, cause, null);
	}

	/**
	 * Constructor with code exception, additional info and original exception
	 *
	 * @param codeException
	 *            Exception code
	 * @param cause
	 *            Original exception
	 * @param httpStatusCode
	 *            HTTP Status code
	 */
	public BaseException(CodeException codeException, Throwable cause, HttpStatus httpStatusCode) {

		this(codeException, null, cause, httpStatusCode);
	}

	/**
	 * Constructor with code exception, error message, original exception, additional info and HTTP code to use
	 *
	 * @param codeException
	 *            Exception code
	 * @param message
	 *            Message with error
	 * @param cause
	 *            Original exception
	 * @param httpStatusCode
	 *            Custom HTTP status code to use
	 */
	public BaseException(CodeException codeException, String message, Throwable cause, HttpStatus httpStatusCode) {

		super(buildExceptionMessage(message, cause), cause);

		this.baseCodeException = codeException;
		this.exceptionMessage = super.getMessage();
		this.httpStatusCode = httpStatusCode;
	}

	/**
	 * Constructor with original exception. Code will be the generic
	 *
	 * @param cause
	 *            Original exception
	 */
	public BaseException(Throwable cause) {

		super(cause.getMessage(), cause);

		// Exception without code, is a generic
		this.baseCodeException = BaseCodeException.UNEXPECTED_ERROR;
		this.exceptionMessage = cause.getMessage();
		this.httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	/**
	 * Build the exception message using the available information
	 *
	 * @param codeException
	 *            Exception code
	 * @param message
	 *            Message whith error
	 * @param cause
	 *            Original exception
	 * @return Message
	 */
	private static String buildExceptionMessage(String message, Throwable cause) {

		StringBuilder exceptionMessage = new StringBuilder();

		if (message != null && !message.isEmpty()) {

			exceptionMessage.append(message);
		}

		if (cause != null && cause.getMessage() != null && !cause.getMessage().isEmpty()) {

			if (exceptionMessage.length() > 0) {
				exceptionMessage.append(COLON_SPACE);
			}

			exceptionMessage.append(cause.getMessage());
		}

		return exceptionMessage.toString();
	}

	/**
	 * Get the base code exception
	 *
	 * @return Code exception
	 */
	public CodeException getBaseCodeException() {
		return this.baseCodeException;
	}

	/**
	 * Get the base code exception in string format
	 *
	 * @return Code exception string
	 */
	public String getCode() {
		return this.baseCodeException.getCode();
	}

	/**
	 * Get the exception message
	 *
	 * @return Exception message
	 */
	public String getExceptionMessage() {
		return this.exceptionMessage;
	}

	/**
	 * Get the HTTP status code of the exception
	 *
	 * @return HTTP status code
	 */
	public HttpStatus getHttpStatusCode() {
		return this.httpStatusCode;
	}
}
