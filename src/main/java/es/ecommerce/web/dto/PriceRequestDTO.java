package es.ecommerce.web.dto;

import java.time.LocalDateTime;

/**
 * Prices data model
 */
public class PriceRequestDTO {

	/**
	 * Brand identifier
	 */
	private Long brandId;

	/**
	 * Rango de fechas en el que aplica el precio tarifa indicado.
	 */
	private LocalDateTime applicationDate;

	public LocalDateTime getApplicationDate() {
		return this.applicationDate;
	}

	public void setApplicationDate(LocalDateTime applicationDate) {
		this.applicationDate = applicationDate;
	}

	/**
	 * Identificador código de producto.
	 */
	private Long productId;

	public Long getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
