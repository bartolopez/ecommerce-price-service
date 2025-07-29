package es.ecommerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.ecommerce.application.service.GetPriceUseCaseImpl;
import es.ecommerce.domain.port.PriceRepository;

@Configuration
public class PriceConfig {
	@Bean
	public GetPriceUseCaseImpl priceService(PriceRepository priceRepository) {
		return new GetPriceUseCaseImpl(priceRepository);
	}
}
