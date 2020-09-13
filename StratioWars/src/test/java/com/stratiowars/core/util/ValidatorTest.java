package com.stratiowars.core.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
	
	Validator validator;
	Validator validatorNull;
	
	@BeforeEach
	public void setUp() {
		validator = new Validator();
	}
	@AfterEach
	public void tearDown() {
		validator = null;
	}
	@Test
	public void decode_FuntionsNotNullTest() {
		assertNotNull(validator);
	}
	@Test
	public void decode_FuntionsNullTest() {
		assertNull(validatorNull);
	}
	/*
	Method 				|  Input								| Output
						|										|
	IsCoordinate	    | 2952410b-0a94-446b-8bcb-48dc6e30b08   | true
	
	 */	
	@Test
	public void validatorIsCoordinate() {
		assertEquals(true , validator.isCoordinate("2952410b-0a94-446b-8bcb-48dc6e30b088"));
	}
	
	/*
	Method 				|  Input								| Output
						|										|
	IsCoordinate	    | 2952410b-0a94-446b-   				| false
	
	 */	
	@Test
	public void validatorIsCoorBadInput() {
		assertEquals(false , validator.isCoordinate("2952410b-0a94-446b-"));
	}
	/*
	Method 				|  Input								| Output
						|										|
	IsCoordinate	    | 295241p-0a94-446b-8bcb-48dc6e30b08    | false
	
	 */	
	@Test
	public void validatorIsCoorBadGalaxy() {
		assertEquals(false , validator.isCoordinate("295241b-0a94-446b-8bcb-48dc6e30b08"));
	}
	/*
	Method 				|  Input								| Output
						|										|
	IsCoordinate	    | 2952410b-0a94-446b-8bcb-48dc6e30b08    | false
	
	 */	
	@Test
	public void validatorIsCoorBadGalaxyNoHex() {
		assertEquals(false , validator.isCoordinate("2952410p-0a94-446b-8bcb-48dc6e30b08"));
	}
	/*
	Method 				|  Input								| Output
						|										|
	IsCoordinate	    | 295241b3-09-446b-8bcb-48dc6e30b08     | false
	
	 */	
	@Test
	public void validatorIsCoorBadQuadrant() {
		assertEquals(false , validator.isCoordinate("295241b3-09-446b-8bcb-48dc6e30b08"));
	}
	/*
	Method 				|  Input								| Output
						|										|
	IsCoordinate	    | 295241b3-08m9-446b-8bcb-48dc6e30b08     | false
	
	 */	
	@Test
	public void validatorIsCoorBadQuadrantNoHex() {
		assertEquals(false , validator.isCoordinate("295241b3-08m9-446b-8bcb-48dc6e30b08"));
	}
	/*
	Method 				|  Input								| Output
						|										|
	IsCoordinate	    | 295241b3-0a94-46-8bcb-48dc6e30b08     | false
	
	 */	
	@Test
	public void validatorIsCoorBadStarSystem1() {
		assertEquals(false , validator.isCoordinate("295241b3-0a94-46-8bcb-48dc6e30b08"));
	}
	
	/*
	Method 				|  Input								| Output
						|										|
	IsCoordinate	    | 295241b3-0a94-47p6-8bcb-48dc6e30b08   | false
	
	 */	
	@Test
	public void validatorIsCoorBadStarSystem1NoHex() {
		assertEquals(false , validator.isCoordinate("295241b3-0a94-47p6-8bcb-48dc6e30b08"));
	}
	/*
	Method 				|  Input								| Output
						|										|
	IsCoordinate	    | 295241b3-0a94-446b-8ac-48dc6e30b08    | false
	
	 */	
	@Test
	public void validatorIsCoorBadStarSystem2() {
		assertEquals(false , validator.isCoordinate("295241b3-0a94-446b-8ac-48dc6e30b08"));
	}

	/*
	Method 				|  Input								| Output
						|										|
	IsCoordinate	    | 295241b3-0a94-446b-8pac-48dc6e30b08   | false
	
	 */	
	@Test
	public void validatorIsCoorBadStarSystem2NoHex() {
		assertEquals(false , validator.isCoordinate("295241b3-0a94-446b-8pac-48dc6e30b08"));
	}
	
	/*
	Method 				|  Input								| Output
						|										|
	IsCoordinate	    | 295241b3-0a94-446b-8bcb-48dc6e3008    | false
	
	 */	
	@Test
	public void validatorIsCoorBadPlanet() {
		assertEquals(false , validator.isCoordinate("295241b3-0a94-446b-8bcb-48dc6e3008"));
	}
	/*
	Method 				|  Input								| Output
						|										|
	IsCoordinate	    | 295241b3-0a94-446b-8bcb-48dc6e3008l9  | false
	
	 */	
	@Test
	public void validatorIsCoorBadPlanetNotHex() {
		assertEquals(false , validator.isCoordinate("295241b3-0a94-446b-8bcb-48dc6e3008l9"));
	}
	/*
	Method 				|  Input								| Output
						|										|
	distincLenght	    | 4,"0a94"						        | false
	
	 */	
	@Test
	public void validatordistincLenghtFalse() {
		assertEquals(false , validator.distincLenght(4,"0a94"));
	}
	/*
	Method 				|  Input								| Output
						|										|
	distincLenght	    | 5,"0a94"						        | true
	
	 */	
	@Test
	public void validatordistincLenghtTrue() {
		assertEquals(true, validator.distincLenght(5,"0a94"));
	}
	/*
	Method 				|  Input								| Output
						|										|
	isNotHex		    | "56t"						            | true
	
	 */	
	@Test
	public void validatorisNotHexTrue() {
		assertEquals(true, validator.isNotHex("56t"));
	}
	/*
	Method 				|  Input								| Output
						|										|
	isNotHex		    | "56a"						            | false
	
	 */	
	@Test
	public void validatorisNotHexFalse() {
		assertEquals(false, validator.isNotHex("56a"));
	}
}
