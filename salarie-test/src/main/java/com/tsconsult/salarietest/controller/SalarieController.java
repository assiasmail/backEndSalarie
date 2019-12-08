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

import com.tsconsult.salarietest.model.Salarie;
import com.tsconsult.salarietest.service.SalarieService;

@RestController
public class SalarieController {

	// Il faut remonter que les Exceptions functionnelles "FunctionalException" au lieu d'Exception.
	// Ajoutes SWAGGER pour mieux documenter tes API.
	
	@Autowired
	private SalarieService salarieService;

	@PostMapping("/filtreSalarie")
	public ResponseEntity<List<Salarie>> filtreSalarie(@RequestBody List<Salarie> salaries, @RequestParam String critere) throws Exception{
		return new ResponseEntity<List<Salarie>>(salarieService.filtreSalaries(salaries,critere), HttpStatus.OK);
	}
}
