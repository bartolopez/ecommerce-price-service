package es.ecommerce.infrastructure.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repositorio de precios
 */
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

	@Query("""
			SELECT p FROM Price p
			WHERE p.productId = :productId
			  AND p.brand.id = :brandId
			  AND :applicationDate BETWEEN p.startDate AND p.endDate
			ORDER BY p.priority DESC
			""")
	List<PriceEntity> findByProduct(@Param("applicationDate") LocalDateTime applicationDate, @Param("productId") Long productId,
			@Param("brandId") Long brandId);

}
