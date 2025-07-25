package es.ecommerce.web.dto;

import java.time.LocalDateTime;

/**
 * Prices data model
 */
public class PriceResponseDTO {

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
	 * Precio final de venta.
	 */
	private Double price;

	public Long getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public LocalDateTime getStartDate() {
		return this.startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return this.endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Long getPriceList() {
		return this.priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
