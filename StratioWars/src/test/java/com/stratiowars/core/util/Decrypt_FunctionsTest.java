package com.stratiowars.core.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Decrypt_FunctionsTest {
	
	Decrypt_Functions decode;
	Decrypt_Functions decodeNull;

	@BeforeEach
	public void setUp() {
		decode = new Decrypt_Functions();
	}
	@AfterEach
	public void tearDown() {
		decode = null;
	}
	@Test
	public void decode_FuntionsNotNullTest() {
		assertNotNull(decode);
	}
	@Test
	public void decode_FuntionsNullTest() {
		assertNull(decodeNull);
	}
	/*
	Method 				|  Input		| Output
						|				|
	sumHex				|  2952410b	    |  34
	
	 */
	@Test
	public void decode_FuntionSumHexTest() {
		String result = "34";
		String input = "2952410b";
		assertEquals(result,decode.sumHex(input) );
		
	}
	/*
	Method 				|  Input		| Output
						|				|
	maxHex				|   0a94	    |     10
	
	 */
	@Test
	public void decode_FuntionMaxHexTest() {
		assertEquals("10",decode.maxHex("0a94") );
	}
	/*
	Method 				|  Input		| Output
						|				|
	compAndSumHex		| 446b, 8bcb    |  10
	
	 */
	@Test
	public void decode_FuntionCompAndSumHexTest() {
		assertEquals("42",decode.compAndSumHex("446b","8bcb"));
	}
	/*
	Method 				|  Input		| Output
						|				|
	distAndSort			| 448dc6e30b08  | edcb86430
	
	 */	
	@Test
	public void decode_FuntiondistAndSortTest() {
		assertEquals("edcb86430",decode.distAndSort("448dc6e30b08"));
	}
}
