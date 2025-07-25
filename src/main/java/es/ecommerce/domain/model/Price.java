package es.ecommerce.domain.model;

import java.time.LocalDateTime;

/**
 * Prices data model
 */
public class Price {

	/**
	 * Identifier
	 */
	private Long id;

	/**
	 * Brand identifier
	 */
	private Long brandId;

	/**
	 * rango de fechas en el que aplica el precio tarifa indicado.
	 */
	private LocalDateTime startDate;

	/**
	 * rango de fechas en el que aplica el precio tarifa indicado.
	 */
	private LocalDateTime endDate;

	/**
	 * Identificador de la tarifa de precios aplicable.
	 */
	private Long priceList;

	/**
	 * Identificador código de producto.
	 */
	private Long productId;

	/**
	 * Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor
	 * numérico).
	 */
	private Integer priority;

	/**
	 * Precio final de venta.
	 */
	private Double price;

	/**
	 * iso de la moneda.
	 */
	private String currency;

	/**
	 * Constructor
	 *
	 * @param id
	 *            id
	 * @param brandId
	 *            brandId
	 * @param startDate
	 *            startDate
	 * @param endDate
	 *            endDate
	 * @param priceList
	 *            priceList
	 * @param productId
	 *            productId
	 * @param priority
	 *            priority
	 * @param price
	 *            price
	 * @param currency
	 *            currency
	 */
	public Price(Long id, Long brandId, LocalDateTime startDate, LocalDateTime endDate, Long priceList, Long productId, Integer priority,
			Double price, String currency) {
		super();
		this.id = id;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.currency = currency;
	}

	public Long id() {
		return this.id;
	}

	public LocalDateTime startDate() {
		return this.startDate;
	}

	public LocalDateTime endDate() {
		return this.endDate;
	}

	public Long brandId() {
		return this.brandId;
	}

	public Long priceList() {
		return this.priceList;
	}

	public Long productId() {
		return this.productId;
	}

	public Integer priority() {
		return this.priority;
	}

	public Double price() {
		return this.price;
	}

	public String currency() {
		return this.currency;
	}

}
