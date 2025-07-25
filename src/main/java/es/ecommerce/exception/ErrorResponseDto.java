package es.ecommerce.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Error response data for REST services
 */
@JsonInclude(Include.NON_NULL)
public class ErrorResponseDto {

	private static final int NUMBER_100 = 100;

	private String code;

	private String message;

	private String additionalInfo;

	/**
	 * Default constructor
	 */
	public ErrorResponseDto() {

		super();

		// Default values
		this.code = BaseCodeException.UNEXPECTED_ERROR.getCode();
	}

	/**
	 * Constructor with params
	 *
	 * @param code
	 *            Exception code
	 * @param message
	 *            Exception message
	 */
	public ErrorResponseDto(String code, String message) {

		this(code, message, null);
	}

	/**
	 * Constructor with params
	 *
	 * @param code
	 *            Exception code
	 * @param message
	 *            Exception message
	 * @param additionalInfo
	 *            Additional info
	 */
	public ErrorResponseDto(String code, String message, String additionalInfo) {

		super();

		this.code = code;
		this.message = message;
		this.additionalInfo = additionalInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(NUMBER_100);
		builder.append("ErrorResponseDto [code=").append(this.code).append(", message=").append(this.message).append(", additionalInfo=")
				.append(this.additionalInfo).append("]");
		return builder.toString();
	}

	/**
	 * Gets the code
	 *
	 * @return the code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * Sets the code
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Get the error message
	 *
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Set the error message
	 *
	 * @param message
	 *            the message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Set the error additional info
	 *
	 * @return the additional info
	 */
	public String getAdditionalInfo() {
		return this.additionalInfo;
	}

	/**
	 * Set the error additional info
	 *
	 * @param additionalInfo
	 *            the additional info
	 */
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

}
