package com.stratiowars.core.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.stratiowars.core.service.DeathStarCodesService;

public class deathStarCodesControllerTest {

	@Mock
	@Autowired
	DeathStarCodesService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	DeathStarCodesController controller;
	
	@BeforeEach
	public void setUp() {
	
		MockitoAnnotations.initMocks(this);
		controller = new DeathStarCodesController();
	}
	@AfterEach
	public void tearDown() {
		controller = null;
	}
	
	@Test
	public void deathStarCodesControllerTestOK() throws Exception {
		//Gson gson = new Gson();
		//ArrayList<String> codes = new ArrayList<String>(Arrays.asList("2952410b-0a94-446b-8bcb-448dc6e30b08","2952410b-0a94-446b-8bcb-448dc6e30b08"));
		//String  jsonString = gson.toJson(codes);
		//System.out.println(jsonString);
		//String jsonStringOut = gson.toJson(new ArrayList<String>(Arrays.asList("34-10-42-edcb86430")));
		
		//when(service.decodeData(codes)).thenReturn(new ArrayList<String>(Arrays.asList("34-10-42-edcb86430")));
		//assertEquals(new ArrayList<String>(Arrays.asList("34-10-42-edcb86430")), c.decodeData(codes));
		
		//mockMvc.perform(post("/decode").contentType(MediaType.APPLICATION_JSON).content(jsonString))
        //.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
}
