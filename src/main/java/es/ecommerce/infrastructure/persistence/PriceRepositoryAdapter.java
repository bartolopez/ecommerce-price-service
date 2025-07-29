package es.ecommerce.infrastructure.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.ecommerce.domain.model.Price;
import es.ecommerce.domain.port.PriceRepository;

/**
 * Price repository adapter implementa {@link PriceRepository} usando {@link PriceJpaRepository}
 */
@Component
public class PriceRepositoryAdapter implements PriceRepository {

	private static Logger logger = LoggerFactory.getLogger(PriceRepositoryAdapter.class);

	@Autowired
	private PriceJpaRepository jpa;

	@Override
	public List<Price> findByProduct(LocalDateTime applicationDate, Long productId, Long brandId) {

		logger.debug("Buscando precios para {}, {}, {}", applicationDate, productId, brandId);

		List<Price> prices = this.jpa.findByProduct(applicationDate, productId, brandId).stream().map(this::toDomain).toList();

		logger.debug("Resultados encontrados: {}", prices.size());

		return prices;
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
