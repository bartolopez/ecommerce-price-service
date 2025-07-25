package es.ecommerce.application.service;

import java.time.LocalDateTime;

import es.ecommerce.domain.model.Price;
import es.ecommerce.domain.port.PriceRepository;

/**
 * Price service
 */
public class PriceService {

	private final PriceRepository priceRepository;

	/**
	 * Constructor
	 *
	 * @param priceRepository
	 */
	public PriceService(PriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}

	/**
	 * Get price
	 *
	 * @param id
	 *            identifier
	 * @return price
	 */
	public Price getPrices(LocalDateTime applicationDate, Long productId, Long brandId) {
		return this.priceRepository.findByProduct(applicationDate, productId, brandId);
	}
}
