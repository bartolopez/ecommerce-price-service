package es.ecommerce.web.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import es.ecommerce.EcommercePriceServiceApplication;

/**
 * Test for rest controller validation
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = EcommercePriceServiceApplication.class)
@AutoConfigureMockMvc
public class PriceControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	/**
	 * Initial mock mvc
	 */
	@BeforeEach
	public void init() {

		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void validatePrice1() throws Exception {

		String suppliedDate = "2020-06-14T10:00:00";
		Long brandId = 1L;
		Long productId = 35455L;

		String uri = new StringBuilder("/prices").append("?brandId=").append(brandId).append("&productId=").append(productId)
				.append("&suppliedDate=").append(suppliedDate).toString();

		this.mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON))

				.andDo(MockMvcResultHandlers.print())

				.andExpect(status().isOk())

				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.5));

	}

	@Test
	public void validatePrice2() throws Exception {
		String suppliedDate = "2020-06-14T16:00:00";

		Long brandId = 1L;
		Long productId = 35455L;

		String uri = new StringBuilder("/prices").append("?brandId=").append(brandId).append("&productId=").append(productId)
				.append("&suppliedDate=").append(suppliedDate).toString();

		this.mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON))

				.andDo(MockMvcResultHandlers.print())

				.andExpect(status().isOk())

				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45));
	}

	@Test
	public void validatePrice3() throws Exception {
		String suppliedDate = "2020-06-14T21:00:00";
		Long brandId = 1L;
		Long productId = 35455L;

		String uri = new StringBuilder("/prices").append("?brandId=").append(brandId).append("&productId=").append(productId)
				.append("&suppliedDate=").append(suppliedDate).toString();

		this.mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON))

				.andDo(MockMvcResultHandlers.print())

				.andExpect(status().isOk())

				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.5));
	}

	@Test
	public void validatePrice4() throws Exception {
		String suppliedDate = "2020-06-15T10:00:00";
		Long brandId = 1L;
		Long productId = 35455L;

		String uri = new StringBuilder("/prices").append("?brandId=").append(brandId).append("&productId=").append(productId)
				.append("&suppliedDate=").append(suppliedDate.toString()).toString();

		this.mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON))

				.andDo(MockMvcResultHandlers.print())

				.andExpect(status().isOk())

				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.5));
	}

	@Test
	public void validatePrice5() throws Exception {
		String suppliedDate = "2020-06-16T21:00:00";
		Long brandId = 1L;
		Long productId = 35455L;

		String uri = new StringBuilder("/prices").append("?brandId=").append(brandId).append("&productId=").append(productId)
				.append("&suppliedDate=").append(suppliedDate).toString();

		this.mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON))

				.andDo(MockMvcResultHandlers.print())

				.andExpect(status().isOk())

				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(38.95));
	}

}
