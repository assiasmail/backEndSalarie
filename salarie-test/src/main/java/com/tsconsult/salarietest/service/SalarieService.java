package com.tsconsult.salarietest.service;

import java.util.List;

import com.tsconsult.salarietest.exceptions.FunctionalException;
import com.tsconsult.salarietest.model.Salarie;
import com.tsconsult.salarietest.service.SalarieServiceImpl.Critere;

public interface SalarieService {
	
		public List<Salarie> filtreSalaries(List<Salarie> salaries, String critere) throws FunctionalException;

}
