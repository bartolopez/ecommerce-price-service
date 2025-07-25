package es.ecommerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.ecommerce.application.service.PriceService;
import es.ecommerce.domain.port.PriceRepository;

@Configuration
public class PriceConfig {
	@Bean
	public PriceService priceService(PriceRepository priceRepository) {
		return new PriceService(priceRepository);
	}
}
