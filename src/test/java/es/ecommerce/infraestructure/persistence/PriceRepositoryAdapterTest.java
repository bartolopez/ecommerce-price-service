package es.ecommerce.infraestructure.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import es.ecommerce.domain.model.Price;
import es.ecommerce.infrastructure.persistence.PriceEntity;
import es.ecommerce.infrastructure.persistence.PriceJpaRepository;
import es.ecommerce.infrastructure.persistence.PriceRepositoryAdapter;

/**
 * Test Adapter
 */
@ExtendWith(MockitoExtension.class)
class PriceRepositoryAdapterTest {

	@Mock
	private PriceJpaRepository priceJpaRepository;

	@InjectMocks
	private PriceRepositoryAdapter adapter;

	@Test
	void should_return_domain_prices() {
		// Arrange
		PriceEntity entity = new PriceEntity();
		entity.setId(1L);
		entity.setBrandId(1L);
		entity.setProductId(35455L);
		entity.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
		entity.setEndDate(LocalDateTime.of(2020, 6, 14, 23, 59));
		entity.setPriceList(1L);
		entity.setPriority(0);
		entity.setPrice(35.50d);
		entity.setCurrency("EUR");

		when(this.priceJpaRepository.findByProduct(any(), any(), any())).thenReturn(List.of(entity));

		// Act
		List<Price> result = this.adapter.findByProduct(LocalDateTime.now(), 35455L, 1L);

		// Assert
		assertEquals(1, result.size());
		assertEquals(35455L, result.get(0).productId());
		assertEquals(35.50d, result.get(0).price());
	}
}
