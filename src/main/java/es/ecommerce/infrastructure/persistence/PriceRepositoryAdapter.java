package es.ecommerce.infrastructure.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.ecommerce.domain.model.Price;
import es.ecommerce.domain.port.PriceRepository;
import es.ecommerce.exception.BaseCodeException;
import es.ecommerce.exception.BaseException;

/**
 * Price repository adapter implementa {@link PriceRepository} usando {@link PriceJpaRepository}
 */
@Component
public class PriceRepositoryAdapter implements PriceRepository {

	@Autowired
	private PriceJpaRepository jpa;

	@Override
	public Price findByProduct(LocalDateTime applicationDate, Long productId, Long brandId) {
		Price res;

		List<PriceEntity> prices = this.jpa.findByProduct(applicationDate, productId, brandId);

		if (prices.isEmpty()) {
			throw new BaseException(BaseCodeException.NOT_FOUND, "prices have not been found");
		} else {
			res = this.toDomain(prices.get(0));
		}

		return res;
	}

	/**
	 * Convert to domain
	 *
	 * @param entity
	 *            entity
	 * @return domain
	 */
	private Price toDomain(PriceEntity entity) {
		return new Price(entity.getId(), entity.getBrandId(), entity.getStartDate(), entity.getEndDate(), entity.getPriceList(),
				entity.getProductId(), entity.getPriority(), entity.getPrice(), entity.getCurrency());
	}
}
