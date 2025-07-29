
package es.ecommerce.domain.port;

import java.time.LocalDateTime;

import es.ecommerce.domain.model.Price;

/**
 * Interface to get prices
 */
public interface GetPriceUseCase {
	Price getPrices(LocalDateTime date, Long productId, Long brandId);
}
