package es.ecommerce.web;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.ecommerce.application.service.PriceService;
import es.ecommerce.domain.model.Price;
import es.ecommerce.web.dto.PriceResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Price controller para gestionar prices
 */
@Tag(name = "Precios", description = "API para consultar precios aplicables")
@RestController
@RequestMapping("/prices")
public class PriceController {

	private final PriceService priceService;

	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}

	@Operation(summary = "Consulta el precio aplicable")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Precio encontrado"),
			@ApiResponse(responseCode = "404", description = "Precio no encontrado"), })
	@GetMapping
	public PriceResponseDTO getPrices(
			@RequestParam("suppliedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime suppliedDate,
			@RequestParam("productId") Long productId, @RequestParam("brandId") Long brandId) {

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
