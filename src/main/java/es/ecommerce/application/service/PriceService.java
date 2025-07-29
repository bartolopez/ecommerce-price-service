package es.ecommerce.application.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ecommerce.domain.model.Price;
import es.ecommerce.domain.port.PriceRepository;
import es.ecommerce.exception.BaseCodeException;
import es.ecommerce.exception.BaseException;

/**
 * Price service
 */
public class PriceService {

	private static final Logger log = LoggerFactory.getLogger(PriceService.class);

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
		log.info("Get prices -> date: {}  productId: {} brandId: {}", applicationDate, productId, brandId);
		return this.priceRepository.findByProduct(applicationDate, productId, brandId).stream().findFirst()
				.orElseThrow(() -> new BaseException(BaseCodeException.NOT_FOUND, "prices have not been found"));
	}
}
