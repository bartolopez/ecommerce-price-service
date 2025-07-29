package es.ecommerce.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ecommerce.domain.model.Price;
import es.ecommerce.domain.port.PriceRepository;

/**
 * Test price service
 */
class PriceServiceTest {

	private static Logger logger = LoggerFactory.getLogger(PriceServiceTest.class);

	@Test
	public void validatePrice1() throws Exception {

		logger.info("Ejecutando test con logging activo");

		PriceRepository repo = mock(PriceRepository.class);
		GetPriceUseCaseImpl service = new GetPriceUseCaseImpl(repo);
		Date suppliedDate = Date
				.from(LocalDateTime.of(LocalDate.of(2020, 6, 14), LocalTime.of(10, 0, 0)).atZone(ZoneId.systemDefault()).toInstant());

		Long brandId = 1L;
		Long productId = 35455L;

		// Configura el mock para devolver un resultado válido
		when(repo.findByProduct(any(LocalDateTime.class), eq(productId), eq(brandId)))

				.thenReturn(Collections.singletonList(new Price(1L, brandId, LocalDateTime.of(2020, 6, 14, 0, 0),
						LocalDateTime.of(2020, 12, 31, 23, 59), 1L, productId, 0, 35.5, "EUR")));

		Price priceDTO = service.getPrices(LocalDateTime.ofInstant(suppliedDate.toInstant(), ZoneId.systemDefault()), productId, brandId);

		if (priceDTO != null) {
			assertEquals(35.5, priceDTO.price());
		}
		assertNotNull(priceDTO);

	}

	@Test
	public void validatePrice2() {
		PriceRepository repo = mock(PriceRepository.class);
		GetPriceUseCaseImpl service = new GetPriceUseCaseImpl(repo);
		Date suppliedDate = Date
				.from(LocalDateTime.of(LocalDate.of(2020, 6, 14), LocalTime.of(16, 0, 0)).atZone(ZoneId.systemDefault()).toInstant());

		Long brandId = 1L;
		Long productId = 35455L;

		// Configura el mock para devolver un resultado válido
		when(repo.findByProduct(any(LocalDateTime.class), eq(productId), eq(brandId)))

				.thenReturn(Collections.singletonList(new Price(1L, brandId, LocalDateTime.of(2020, 6, 14, 0, 0),
						LocalDateTime.of(2020, 12, 31, 23, 59), 1L, productId, 0, 25.45, "EUR")));

		Price priceDTO = service.getPrices(LocalDateTime.ofInstant(suppliedDate.toInstant(), ZoneId.systemDefault()), productId, brandId);

		if (priceDTO != null) {
			assertEquals(25.45, priceDTO.price());
		}
		assertNotNull(priceDTO);

	}

	@Test
	public void validatePrice3() {
		PriceRepository repo = mock(PriceRepository.class);
		GetPriceUseCaseImpl service = new GetPriceUseCaseImpl(repo);
		Date suppliedDate = Date
				.from(LocalDateTime.of(LocalDate.of(2020, 6, 14), LocalTime.of(21, 0, 0)).atZone(ZoneId.systemDefault()).toInstant());

		Long brandId = 1L;
		Long productId = 35455L;

		// Configura el mock para devolver un resultado válido
		when(repo.findByProduct(any(LocalDateTime.class), eq(productId), eq(brandId)))

				.thenReturn(Collections.singletonList(new Price(1L, brandId, LocalDateTime.of(2020, 6, 14, 0, 0),
						LocalDateTime.of(2020, 12, 31, 23, 59), 1L, productId, 0, 35.5, "EUR")));

		Price priceDTO = service.getPrices(LocalDateTime.ofInstant(suppliedDate.toInstant(), ZoneId.systemDefault()), productId, brandId);

		if (priceDTO != null) {
			assertEquals(35.5, priceDTO.price());
		}
		assertNotNull(priceDTO);

	}

	@Test
	public void validatePrice4() {
		PriceRepository repo = mock(PriceRepository.class);
		GetPriceUseCaseImpl service = new GetPriceUseCaseImpl(repo);

		Date suppliedDate = Date
				.from(LocalDateTime.of(LocalDate.of(2020, 6, 15), LocalTime.of(10, 0, 0)).atZone(ZoneId.systemDefault()).toInstant());

		Long brandId = 1L;
		Long productId = 35455L;

		// Configura el mock para devolver un resultado válido
		when(repo.findByProduct(any(LocalDateTime.class), eq(productId), eq(brandId)))

				.thenReturn(Collections.singletonList(new Price(1L, brandId, LocalDateTime.of(2020, 6, 14, 0, 0),
						LocalDateTime.of(2020, 12, 31, 23, 59), 1L, productId, 0, 30.5, "EUR")));

		Price priceDTO = service.getPrices(LocalDateTime.ofInstant(suppliedDate.toInstant(), ZoneId.systemDefault()), productId, brandId);

		if (priceDTO != null) {
			assertEquals(30.5, priceDTO.price());
		}
		assertNotNull(priceDTO);

	}

	@Test
	public void validatePrice5() {
		PriceRepository repo = mock(PriceRepository.class);
		GetPriceUseCaseImpl service = new GetPriceUseCaseImpl(repo);
		Date suppliedDate = Date
				.from(LocalDateTime.of(LocalDate.of(2020, 6, 16), LocalTime.of(21, 0, 0)).atZone(ZoneId.systemDefault()).toInstant());

		Long brandId = 1L;
		Long productId = 35455L;

		// Configura el mock para devolver un resultado válido
		when(repo.findByProduct(any(LocalDateTime.class), eq(productId), eq(brandId)))

				.thenReturn(Collections.singletonList(new Price(1L, brandId, LocalDateTime.of(2020, 6, 14, 0, 0),
						LocalDateTime.of(2020, 12, 31, 23, 59), 1L, productId, 0, 38.95, "EUR")));

		Price priceDTO = service.getPrices(LocalDateTime.ofInstant(suppliedDate.toInstant(), ZoneId.systemDefault()), productId, brandId);

		assertEquals(38.95, priceDTO.price());

	}
}
