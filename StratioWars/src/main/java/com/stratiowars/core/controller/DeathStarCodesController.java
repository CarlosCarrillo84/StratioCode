package com.stratiowars.core.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stratiowars.core.service.DeathStarCodesService;

@RestController
public class DeathStarCodesController {

	@Autowired
	DeathStarCodesService deathstarcode;
	
	@PostMapping("/decode")	
	public ArrayList<String> decode(@RequestBody ArrayList<String> code){
		return deathstarcode.decodeData(code);
	}

	public void setDeathstarcode(DeathStarCodesService deathstarcode) {
		this.deathstarcode = deathstarcode;
	}

}
