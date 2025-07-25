package es.ecommerce.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

import es.ecommerce.domain.model.Price;
import es.ecommerce.domain.port.PriceRepository;

class PriceServiceTest {

	@Test
	public void validatePrice1() throws Exception {
		PriceRepository repo = mock(PriceRepository.class);
		PriceService service = new PriceService(repo);
		Date suppliedDate = Date
				.from(LocalDateTime.of(LocalDate.of(2020, 6, 14), LocalTime.of(10, 0, 0)).atZone(ZoneId.systemDefault()).toInstant());

		Long brandId = 1L;
		Long productId = 35455L;

		Price priceDTO = service.getPrices(LocalDateTime.ofInstant(suppliedDate.toInstant(), ZoneId.systemDefault()), productId, brandId);

		assertEquals(35.5, priceDTO.price());

	}

	@Test
	public void validatePrice2() {
		PriceRepository repo = mock(PriceRepository.class);
		PriceService service = new PriceService(repo);
		Date suppliedDate = Date
				.from(LocalDateTime.of(LocalDate.of(2020, 6, 14), LocalTime.of(16, 0, 0)).atZone(ZoneId.systemDefault()).toInstant());

		Long brandId = 1L;
		Long productId = 35455L;

		Price priceDTO = service.getPrices(LocalDateTime.ofInstant(suppliedDate.toInstant(), ZoneId.systemDefault()), productId, brandId);

		assertEquals(25.45, priceDTO.price());

	}

	@Test
	public void validatePrice3() {
		PriceRepository repo = mock(PriceRepository.class);
		PriceService service = new PriceService(repo);
		Date suppliedDate = Date
				.from(LocalDateTime.of(LocalDate.of(2020, 6, 14), LocalTime.of(21, 0, 0)).atZone(ZoneId.systemDefault()).toInstant());

		Long brandId = 1L;
		Long productId = 35455L;

		Price priceDTO = service.getPrices(LocalDateTime.ofInstant(suppliedDate.toInstant(), ZoneId.systemDefault()), productId, brandId);

		assertEquals(35.5, priceDTO.price());

	}

	@Test
	public void validatePrice4() {
		PriceRepository repo = mock(PriceRepository.class);
		PriceService service = new PriceService(repo);

		Date suppliedDate = Date
				.from(LocalDateTime.of(LocalDate.of(2020, 6, 15), LocalTime.of(10, 0, 0)).atZone(ZoneId.systemDefault()).toInstant());

		Long brandId = 1L;
		Long productId = 35455L;

		Price priceDTO = service.getPrices(LocalDateTime.ofInstant(suppliedDate.toInstant(), ZoneId.systemDefault()), productId, brandId);

		assertEquals(30.5, priceDTO.price());

	}

	@Test
	public void validatePrice5() {
		PriceRepository repo = mock(PriceRepository.class);
		PriceService service = new PriceService(repo);
		Date suppliedDate = Date
				.from(LocalDateTime.of(LocalDate.of(2020, 6, 16), LocalTime.of(21, 0, 0)).atZone(ZoneId.systemDefault()).toInstant());

		Long brandId = 1L;
		Long productId = 35455L;

		Price priceDTO = service.getPrices(LocalDateTime.ofInstant(suppliedDate.toInstant(), ZoneId.systemDefault()), productId, brandId);

		assertEquals(38.95, priceDTO.price());

	}
}
