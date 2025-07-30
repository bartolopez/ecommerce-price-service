package es.ecommerce.domain.exception;

/**
 * Price not available exception
 */
public class PriceNotAvailableException extends RuntimeException {
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -2792807932420211047L;

	/**
	 * Default constructor
	 *
	 * @param message
	 *            exception message
	 */
	public PriceNotAvailableException(String message) {
		super(message);
	}
}
