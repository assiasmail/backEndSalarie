package com.tsconsult.salarietest.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;

import com.tsconsult.salarietest.exceptions.FunctionalException;
import com.tsconsult.salarietest.model.Salarie;


@Service
public class SalarieServiceImpl implements SalarieService{
	// A quoi sert ces variables ?
	// Quelle est la nécessité de les déclarer comme attributs de Class ?
	Field field = null;
	boolean exists = false;

    public enum Critere {
    	// TODO Best practices
		// TODO On déclare les ENum en MAJESCULE
		// TODO NOM, PRENOM, ....
        nom, prenom, adresse, dateEntree, dateNaissance;
    }

	@Override
	public List<Salarie> filtreSalaries(List<Salarie> salaries,String critere) throws FunctionalException {
		System.out.println("service, critere :  " + critere);
		List<Salarie> salariesFiltres = new ArrayList<>();
		//TODO les exceptions sont bien gérés reste à savoir si la variable "critere" = null ou "";
		try {
		//TODO Le programme va surement fonctionner, qu'en est-il des performances
		// Je pense qu'on peut éviter la 2em boucle couteuse en perf.
		salaries.stream().forEach(s -> {
			exists= false;
			 salariesFiltres.stream().forEach(sf -> {
				 switch (Critere.valueOf(critere)) {
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
						// TODO c'est dommage de renvoyer une exception pour les cas "Nom, Prénom, ADRESSE.
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
