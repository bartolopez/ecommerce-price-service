package es.ecommerce.e2e.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;

/**
 * E2E Price test
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PriceE2ETest {

	@LocalServerPort
	private int port;

	@BeforeEach
	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = this.port;
	}

	// Test 1: 14 de junio 10:00
	@Test
	void test1_shouldReturn_35_50() {
		given().queryParam("suppliedDate", "2020-06-14T10:00:00").queryParam("productId", 35455).queryParam("brandId", 1).when()
				.get("/prices").then().statusCode(200).body("price", equalTo(35.5f));
	}

	// Test 2: 14 de junio 16:00
	@Test
	void test2_shouldReturn_25_45() {
		given().queryParam("suppliedDate", "2020-06-14T16:00:00").queryParam("productId", 35455).queryParam("brandId", 1).when()
				.get("/prices").then().statusCode(200).body("price", equalTo(25.45f));
	}

	// Test 3: 14 de junio 21:00
	@Test
	void test3_shouldReturn_35_50() {
		given().queryParam("suppliedDate", "2020-06-14T21:00:00").queryParam("productId", 35455).queryParam("brandId", 1).when()
				.get("/prices").then().statusCode(200).body("price", equalTo(35.5f));
	}

	// Test 4: 15 de junio 10:00
	@Test
	void test4_shouldReturn_30_50() {
		given().queryParam("suppliedDate", "2020-06-15T10:00:00").queryParam("productId", 35455).queryParam("brandId", 1).when()
				.get("/prices").then().statusCode(200).body("price", equalTo(30.5f));
	}

	// Test 5: 16 de junio 21:00
	@Test
	void test5_shouldReturn_38_95() {
		given().queryParam("suppliedDate", "2020-06-16T21:00:00").queryParam("productId", 35455).queryParam("brandId", 1).when()
				.get("/prices").then().statusCode(200).body("price", equalTo(38.95f));
	}

	// Test invalid product
	@Test
	void test_should_return_404_for_invalid_product() {
		given().queryParam("suppliedDate", "2020-06-14T10:00:00").queryParam("productId", "99999").queryParam("brandId", "1").when()
				.get("/prices").then().statusCode(404).body("message", equalTo("prices have not been found"));
	}

	// Test missing param
	@Test
	void test_should_return_400_when_missing_param() {
		given().queryParam("productId", "35455").queryParam("brandId", "1").when().get("/prices").then().statusCode(400);
	}

}
