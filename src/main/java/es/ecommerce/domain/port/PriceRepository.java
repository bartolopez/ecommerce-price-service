package es.ecommerce.domain.port;

import java.time.LocalDateTime;

import es.ecommerce.domain.model.Price;

/**
 * Price repository
 */
public interface PriceRepository {

	/**
	 * Find price
	 *
	 * @param id
	 *            identifier
	 * @return price
	 */
	Price findByProduct(LocalDateTime applicationDate, Long brandId, Long productId);

}
