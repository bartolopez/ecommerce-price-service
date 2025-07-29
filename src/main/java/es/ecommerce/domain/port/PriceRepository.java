package es.ecommerce.domain.port;

import java.time.LocalDateTime;
import java.util.List;

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
	List<Price> findByProduct(LocalDateTime applicationDate, Long brandId, Long productId);

}
