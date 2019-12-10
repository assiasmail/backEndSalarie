package com.tsconsult.salarietest.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;

import com.tsconsult.salarietest.exceptions.FunctionalException;
import com.tsconsult.salarietest.model.Salarie;
// Ce bout de code ressemble étrangement a celui de Mr Sadoud avec les même erreurs, alors qu'on peut le solutionner de plusieurs maniere ...
// Essaies de faire avec un SWITCH et des énumétations.
// Le throws Exception ne sert à rien ici.
// d'une manière général les exceptions sont très mal gérées.

@Service
public class SalarieServiceImpl implements SalarieService{
	Field field = null;
	boolean exists = false;
    public enum Critere {

        nom, prenom, adresse, dateEntree, dateNaissance;
    }
	@Override
	public List<Salarie> filtreSalaries(List<Salarie> salaries,String critere) throws FunctionalException {
		System.out.println("service, critere :  " + critere);
		List<Salarie> salariesFiltres = new ArrayList<>();
		try {
		Critere critere1= Critere.valueOf(critere);
		
		salaries.stream().forEach(s -> {
			exists= false;
			 salariesFiltres.stream().forEach(sf -> {
				 switch (critere1) {
					case nom:
						if(s.getNom().equals(sf.getNom())) {
							exists = true;
						}
						break;
					case prenom:
						if(s.getPrenom().equals(sf.getPrenom())) {
							exists = true;
						}
						break;
					case dateEntree:
						if(s.getDateEntree().equals(sf.getDateEntree())) {
							exists = true;
						}
						break;
					case dateNaissance:
						if(s.getDateNaissance().equals(sf.getDateNaissance())) {
							exists = true;
						}
						break;
					case adresse:
						if(s.getAdresse().equals(sf.getAdresse())) {
							exists = true;
						}
						break;
						default:throw new FunctionalException("le critère selectioné est incorrect");	
							
				 }
				 
			 });
			 if(!exists) {
					salariesFiltres.add(s);
				}	
		});
		}catch (IllegalArgumentException e) {
			throw new FunctionalException("le critère est erroné");
		}
		
		return salariesFiltres;
		
	}
}
