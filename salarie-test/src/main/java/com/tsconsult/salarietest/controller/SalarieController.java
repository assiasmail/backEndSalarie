package com.tsconsult.salarietest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsconsult.salarietest.exceptions.FunctionalException;
import com.tsconsult.salarietest.model.Salarie;
import com.tsconsult.salarietest.service.SalarieService;
import com.tsconsult.salarietest.service.SalarieServiceImpl.Critere;

@RestController
public class SalarieController {

	// Ajoutes SWAGGER pour mieux documenter tes API.
	
	@Autowired
	private SalarieService salarieService;

	@PostMapping("/filtreSalarie")
	public ResponseEntity<List<Salarie>> filtreSalarie(@RequestBody List<Salarie> salaries, @RequestParam String critere) throws FunctionalException{
		//TODO Il ne faut jamais écrire ds la console en PROD !!!!
		
		return new ResponseEntity<List<Salarie>>(salarieService.filtreSalaries(salaries, critere), HttpStatus.OK);
	}
}
