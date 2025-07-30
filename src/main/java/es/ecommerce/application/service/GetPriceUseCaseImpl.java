package es.ecommerce.application.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ecommerce.domain.exception.PriceNotAvailableException;
import es.ecommerce.domain.model.Price;
import es.ecommerce.domain.port.GetPriceUseCase;
import es.ecommerce.domain.port.PriceRepository;

/**
 * Price service
 */
public class GetPriceUseCaseImpl implements GetPriceUseCase {

	private static final Logger log = LoggerFactory.getLogger(GetPriceUseCaseImpl.class);

	private final PriceRepository priceRepository;

	/**
	 * Constructor
	 *
	 * @param priceRepository
	 */
	public GetPriceUseCaseImpl(PriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}

	/**
	 * Get price
	 *
	 * @param id
	 *            identifier
	 * @return price
	 */
	@Override
	public Price getPrices(LocalDateTime applicationDate, Long productId, Long brandId) {
		log.info("Get prices -> date: {}  productId: {} brandId: {}", applicationDate, productId, brandId);
		return this.priceRepository.findByProduct(applicationDate, productId, brandId).stream().findFirst()
				.orElseThrow(() -> new PriceNotAvailableException("prices have not been found"));
	}
}
