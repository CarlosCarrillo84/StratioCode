package com.stratiowars.core.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.stratiowars.core.service.DeathStarCodesService;

public class deathStarCodesControllerTest {

	@Autowired
	@Mock
	DeathStarCodesService service;
	
	@InjectMocks
	DeathStarCodesController controller;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new DeathStarCodesController();
		controller.setDeathstarcode(service);
	}
	@AfterEach
	public void tearDown() {
		controller = null;
	}
	
	@Test
	public void deathStarCodesControllerTestOK() throws Exception {

		ArrayList<String> codes = new ArrayList<String>(Arrays.asList("2952410b-0a94-446b-8bcb-448dc6e30b08"));
		when(service.decodeData(codes)).thenReturn(new ArrayList<String>(Arrays.asList("34-10-42-edcb86430")));
		assertEquals(new ArrayList<String>(Arrays.asList("34-10-42-edcb86430")), controller.decode(codes));

	}
	
}
