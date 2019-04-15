package com.subh.app.h2db;

import com.subh.app.h2db.repository.BillRepository;
import com.subh.app.h2db.repository.CustomerRepository;
import com.subh.app.h2db.service.FileStorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

@RunWith(SpringRunner.class)
@WebMvcTest
public class H2dbApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	CustomerRepository customerRepository;

	@MockBean
	FileStorageService fileStorageService;

	@MockBean
	BillRepository billRepository;

	@Test
	public void simpleUnitTest() throws Exception {

		Mockito.when(customerRepository.findAll()).thenReturn(
				Collections.emptyList());

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/customer/all")
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "Basic YWRtaW46YWRtaW4=")).andReturn();

		Mockito.verify(customerRepository).findAll();
	}


}
