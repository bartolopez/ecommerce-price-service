package es.ecommerce.web.exception;

import java.util.Arrays;

/**
 * Códigos de excepción base. Define varios códigos de error genéricos que podrán reutilizarse en las distintas funcionalidades.
 * 
 * @author aars
 *
 */
public enum BaseCodeException implements CodeException {

	/** Unexpected error. HTTP 500: Internal Server Error */
	UNEXPECTED_ERROR("UNEXPECTED_ERROR", 500),

	/** Service unavailable */
	SERVICE_UNAVAILABLE("SERVICE_UNAVAILABLE", 503),

	/** Some register, object or configuration not found. HTTP 404: Not found */
	NOT_FOUND("NOT_FOUND", 404),

	/** Unauthorized */
	UNAUTHORIZED("UNAUTHORIZED", 401),

	/** Forbidden */
	FORBIDDEN("FORBIDDEN", 403),

	/** Bad request. HTTP 400: Bad Request */
	BAD_REQUEST("BAD_REQUEST", 400),

	/** Received a null data in a required param. HTTP 400: Bad Request */
	NULL_DATA("NULL_DATA", 400),

	/** Incorrect format. HTTP 400: Bad Request */
	WRONG_FORMAT("WRONG_FORMAT", 400);

	/** Code exception */
	private String code;

	/** HTTP Status code */
	private Integer httpStatusCode;

	/**
	 * Constructor with code, internal
	 *
	 * @param code
	 *            Exception code
	 */
	private BaseCodeException(String code, Integer httpStatusCode) {
		this.code = code;
		this.httpStatusCode = httpStatusCode;
	}

	/**
	 * Get the code exception
	 *
	 * @return Code
	 */
	@Override
	public String getCode() {
		return this.code;
	}

	/**
	 * Get the HTTP Status code
	 *
	 * @return HTTP Status Code
	 */
	public Integer getHttpStatusCode() {
		return this.httpStatusCode;
	}

	/**
	 * Find an enum value by exception code. If a code is assigned to multiple enum values, get the first occurrence
	 *
	 * @param code
	 *            Exception code
	 * @return Enum value
	 */
	public static final BaseCodeException getByCode(String code) {

		return Arrays.stream(BaseCodeException.values()).filter(enumCode -> enumCode.code.equals(code)).findFirst()
				.orElse(UNEXPECTED_ERROR);
	}

	/**
	 * Find an enum value by HTTP status code. If a status code is assigned to multiple enum values, get the first occurrence
	 *
	 * @param httpStatusCode
	 *            HTTP status code
	 * @return Enum value
	 */
	public static final BaseCodeException getByHttpStatusCode(Integer httpStatusCode) {

		return Arrays.stream(BaseCodeException.values())
				.filter(enumHttpStatusCode -> enumHttpStatusCode.httpStatusCode.equals(httpStatusCode)).findFirst()
				.orElse(UNEXPECTED_ERROR);
	}
}
