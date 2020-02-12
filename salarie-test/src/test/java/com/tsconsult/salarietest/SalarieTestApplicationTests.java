package com.tsconsult.salarietest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.google.gson.Gson;
import com.tsconsult.salarietest.model.Salarie;
import com.tsconsult.salarietest.service.SalarieService;

import ch.qos.logback.core.util.ContentTypeUtil;

@SpringBootTest
@AutoConfigureMockMvc
class SalarieTestApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void shouldReturnListSalarie() throws Exception {
	
		 ObjectMapper mapper = new ObjectMapper();
		 mapper.registerModule(new JavaTimeModule());
		 mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		 List<Salarie> salaries= new ArrayList<>();
			salaries.add(new Salarie("Smail","Assia","Cité 90 logt, Draa-El-Mizan",LocalDate.of(1989, 2, 11), LocalDate.of(2017, 5, 7)));
			salaries.add(new Salarie("Smail","Sihem","Tigzirt",LocalDate.of(1985, 3, 23), LocalDate.of(2014, 9, 1)));
			salaries.add(new Salarie("Sihadj Mohand","Oualid","Alger",LocalDate.of(1985, 9, 22), LocalDate.of(2010, 1, 1)));
		    String json = mapper.writeValueAsString(salaries);
		    System.out.println("json : " + json);
		 MvcResult result = this.mockMvc.perform(post("/filtreSalarie").content(json).param("critere", "Nom").accept(MediaType.APPLICATION_JSON).contentType("application/json")
				.characterEncoding("UTF-8")).andReturn();
	
		 System.out.println("avant affichage");
		System.out.println(result.getResponse().getContentAsString());	
	}

}
