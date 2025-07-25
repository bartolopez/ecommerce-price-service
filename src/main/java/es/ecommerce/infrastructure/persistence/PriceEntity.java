package es.ecommerce.infrastructure.persistence;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Prices data model
 */
@Entity
@Table(name = "PRICES")
public class PriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(name = "brand_id")
	private Long brandId;

	@Column(name = "start_date", nullable = false)
	private LocalDateTime startDate;

	@Column(name = "end_date", nullable = false)
	private LocalDateTime endDate;

	@Column(name = "price_list")
	private Long priceList;

	@Column(name = "product_id", nullable = false)
	private Long productId;

	private Integer priority;

	@Column(nullable = false)
	private Double price;

	@Column(name = "curr")
	private String currency;

	/**
	 * Get identifier
	 *
	 * @return identifier
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets the entity ID
	 *
	 * @param id
	 *            new entity ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get brand ID
	 *
	 * @return brand id
	 */
	public Long getBrandId() {
		return this.brandId;
	}

	/**
	 * Set brand ID
	 *
	 * @param brandId
	 *            brand id
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	/**
	 * Get start date
	 *
	 * @return start date
	 */
	public LocalDateTime getStartDate() {
		return this.startDate;
	}

	/**
	 * Set start date
	 *
	 * @param startDate
	 *            start date
	 */
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	/**
	 * Get end date
	 *
	 * @return end date
	 */
	public LocalDateTime getEndDate() {
		return this.endDate;
	}

	/**
	 * Set end date
	 *
	 * @param endDate
	 *            end date
	 */
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	/**
	 * Get price list
	 *
	 * @return price list
	 */
	public Long getPriceList() {
		return this.priceList;
	}

	/**
	 * Set price list
	 *
	 * @param priceList
	 *            price list
	 */
	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	/**
	 * Get product identifier
	 *
	 * @return product identifier
	 */
	public Long getProductId() {
		return this.productId;
	}

	/**
	 * Set product identifier
	 *
	 * @param productId
	 *            product identifier
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * Get priority
	 *
	 * @return priority
	 */
	public Integer getPriority() {
		return this.priority;
	}

	/**
	 * Set priority
	 *
	 * @param priority
	 *            priority
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * Get price
	 *
	 * @return price
	 */
	public Double getPrice() {
		return this.price;
	}

	/**
	 * Set price
	 *
	 * @param price
	 *            price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Get currency
	 *
	 * @return currency
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Set currency
	 *
	 * @param currency
	 *            currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
