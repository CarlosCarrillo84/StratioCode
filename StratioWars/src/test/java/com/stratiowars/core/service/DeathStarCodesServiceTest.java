package com.stratiowars.core.service;

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

import com.stratiowars.core.util.Decrypt_Functions;
import com.stratiowars.core.util.Validator;


public class DeathStarCodesServiceTest {

	@InjectMocks
	@Autowired
	DeathStarCodesService deathstarcodes;
	
	@Mock
	Validator validator;
	
	@Mock
	Decrypt_Functions decrypt;
	
	
	@BeforeEach
	public void setUp() {
	
		MockitoAnnotations.initMocks(this);
		deathstarcodes.setValidator(validator);
		deathstarcodes.setDecrypt(decrypt);
	}
	@AfterEach
	public void tearDown() {
		validator = null;
		decrypt = null;
		deathstarcodes = null;
	}
	
	@Test
	public void DeathStarCodeServiceOKTest() {
		ArrayList<String> codes = new ArrayList<String>(Arrays.asList("2952410b-0a94-446b-8bcb-448dc6e30b08"));
		
		when(validator.isCoordinate("2952410b-0a94-446b-8bcb-448dc6e30b08")).thenReturn(true);
		when(decrypt.sumHex("2952410b")).thenReturn("34");
		when(decrypt.maxHex("0a94")).thenReturn("10");
		when(decrypt.compAndSumHex("446b","8bcb")).thenReturn("42");
		when(decrypt.distAndSort("448dc6e30b08")).thenReturn("edcb86430");
		
		assertEquals(new ArrayList<String>(Arrays.asList("34-10-42-edcb86430")), deathstarcodes.decodeData(codes));
	}
	@Test
	public void DeathStarCodeServiceKOTest() {
		ArrayList<String> codes = new ArrayList<String>(Arrays.asList("29524?0b-0a94-446b-8bcb-448dc6e30b08"));
		
		when(validator.isCoordinate("29524?0b-0a94-446b-8bcb-448dc6e30b08")).thenReturn(false);
		
		assertEquals(new ArrayList<String>(Arrays.asList("The message is not a coordinate")), deathstarcodes.decodeData(codes));
	}
}
