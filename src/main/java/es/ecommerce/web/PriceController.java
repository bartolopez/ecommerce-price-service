package es.ecommerce.web;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.ecommerce.application.service.PriceService;
import es.ecommerce.domain.model.Price;
import es.ecommerce.web.dto.PriceResponseDTO;

/**
 * Price controller para gestionar prices
 */
@RestController
@RequestMapping("/prices")
public class PriceController {
	private final PriceService priceService;

	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}

	@GetMapping("")
	public PriceResponseDTO getPrices(@RequestParam LocalDateTime suppliedDate, @RequestParam Long brandId, @RequestParam Long productId) {
		Price price = this.priceService.getPrices(suppliedDate, productId, brandId);

		return this.mapToDto(price);
	}

	/**
	 * Map price to dto
	 *
	 * @param price
	 *            price
	 * @return price response
	 */
	private PriceResponseDTO mapToDto(Price price) {
		PriceResponseDTO dto = new PriceResponseDTO();

		dto.setBrandId(price.brandId());
		dto.setStartDate(price.startDate());
		dto.setEndDate(price.endDate());
		dto.setPriceList(price.priceList());
		dto.setProductId(price.productId());
		dto.setPrice(price.price());

		return dto;
	}
}
