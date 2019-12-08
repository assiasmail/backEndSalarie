package com.tsconsult.salarietest.service;

import java.util.List;

import com.tsconsult.salarietest.model.Salarie;

public interface SalarieService {
	public List<Salarie> filtreSalaries(List<Salarie> salaries, String critere) throws Exception;
}
