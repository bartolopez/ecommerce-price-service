package es.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Ecommerce price service application
 */
@SpringBootApplication(scanBasePackages = { "es.ecommerce" })
@EnableJpaRepositories(basePackages = { "es.ecommerce.infrastructure.persistence" })
public class EcommercePriceServiceApplication {

	/**
	 * Main method to starts application
	 *
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(EcommercePriceServiceApplication.class, args);
	}

}
