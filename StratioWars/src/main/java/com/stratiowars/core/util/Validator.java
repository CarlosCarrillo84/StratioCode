package com.stratiowars.core.util;

public class Validator {
	
	static final int galaxy = 8;
	static final int quadrant = 4;
	static final int starsystem = 4;
	static final int planet = 12;
	
	
	public boolean isCoordinate(String string) {
		if(string.split("-").length!=5)
			return false;
		if(distincLenght(galaxy, string.split("-")[0]) || isNotHex(string.split("-")[0]))
			return false;
		if(distincLenght(quadrant, string.split("-")[1]) || isNotHex(string.split("-")[1]))
			return false;
		if(distincLenght(starsystem, string.split("-")[2]) || isNotHex(string.split("-")[2]))
			return false;
		if(distincLenght(starsystem, string.split("-")[3]) || isNotHex(string.split("-")[3]))
			return false;
		if(distincLenght(planet, string.split("-")[4])  || isNotHex(string.split("-")[4]))
			return false;
		
		return true;
	}
	public boolean distincLenght(int lenght, String string) {
		return lenght != string.length();
	}
	public boolean isNotHex(String string) {
		String hex = "0123456789abcdef";
		for(Character character: string.toLowerCase().toCharArray()) 
			if(!hex.contains(character.toString()))
				return true;
		return false;
	}
}
