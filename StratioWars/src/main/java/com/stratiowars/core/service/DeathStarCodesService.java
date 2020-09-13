package com.stratiowars.core.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.stratiowars.core.util.Decrypt_Functions;
import com.stratiowars.core.util.Validator;

@Service
public class DeathStarCodesService{
	
	Decrypt_Functions decrypt = new Decrypt_Functions();
	Validator validator = new Validator();
	

	public ArrayList<String> decodeData(ArrayList<String> codes) {
		
		ArrayList<String> coordinates= new ArrayList<>();

		
		for (String code : codes) 
			if(validator.isCoordinate(code))
					coordinates.add(decrypt.sumHex(code.split("-")[0].toString())+"-"+
							decrypt.maxHex(code.split("-")[1].toString())+"-"+
							decrypt.compAndSumHex(code.split("-")[2].toString(), code.split("-")[3].toString())+"-"+
							decrypt.distAndSort(code.split("-")[4].toString()));
			else
				coordinates.add("The message is not a coordinate");
		return coordinates;
	}

	public void setDecrypt(Decrypt_Functions decrypt) {
		this.decrypt = decrypt;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	
}
