package com.tsconsult.salarietest.service;

import java.util.List;

import com.tsconsult.salarietest.model.Salarie;


// De préférence FunctionalException à la place d'Exception.

public interface SalarieService {
	public List<Salarie> filtreSalaries(List<Salarie> salaries, String critere) throws Exception;
}
