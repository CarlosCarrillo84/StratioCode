package com.stratiowars.core.util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Decrypt_Functions {


	/*
	 * Quita los duplicados y ordena en orden descendente
	 */
	public String distAndSort(String string){

		return string.toLowerCase().chars().mapToObj(item -> (char) item)
				.collect(Collectors.toList()).stream()
				.distinct().sorted(Comparator.reverseOrder())
				.map(String::valueOf)
				.collect(Collectors.joining());
	}
	
	/*
	 * Compara cada caracter hexadecimal de 2 string, coge el mayor y suma el resultado en decimal
	 */
	public String compAndSumHex(String string1, String string2) {
		
		List<Character> code1 = string1.chars().mapToObj(item -> (char) item).collect(Collectors.toList());
		List<Character> code2 = string2.chars().mapToObj(item -> (char) item).collect(Collectors.toList());
		Integer suma = 0;
			for(int i =0; i<code1.size();i++) {
				suma = suma+ Integer.parseInt(maxHex(code1.get(i).toString()+code2.get(i).toString()));
			};
		return suma.toString();
	}
	
	/*
	 * Suma todos los caracteres hexadecimales de un string y los devuelve en decimal
	 */	
	public String sumHex(String string) {

			return string.chars().mapToObj(item -> (char) item)
					.collect(Collectors.toList())
					.stream().map(n-> Integer.parseInt(n.toString(),16))
					.reduce(0,Integer::sum).toString();

	}
	
	/*
	 * Analiza cada caracter hexadecimal de String  y se queda con el mayor y lo devuelve en decimal
	 */	
	public String maxHex(String string) {
			return string.chars().mapToObj(item -> (char) item)
					.collect(Collectors.toList())
					.stream().map(n-> Integer.parseInt(n.toString(),16))
					.max(Integer::compare).get().toString();
	}
	
	
	
}
