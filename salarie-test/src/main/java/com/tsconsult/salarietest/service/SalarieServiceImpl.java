package com.tsconsult.salarietest.service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tsconsult.salarietest.exceptions.FunctionalException;
import com.tsconsult.salarietest.model.Salarie;


@Service
public class SalarieServiceImpl implements SalarieService{
	// A quoi sert ces variables ?
	// Quelle est la nécessité de les déclarer comme attributs de Class ?
		

    public enum Critere {
    	// TODO Best practices
		// TODO On déclare les ENum en MAJESCULE
		// TODO NOM, PRENOM, ....
        NOM, PRENOM, ADRESSE, DATEENTREE, DATENAISSANCE;
    }

	@Override
	public List<Salarie> filtreSalaries(List<Salarie> salaries,String critere) throws FunctionalException {
		List<Salarie> salariesFiltres = new ArrayList<>();
		if( (critere == "" ) || (critere == null)) {
			throw new FunctionalException("le critère est vide");
		}
		else {
			String nfdNormalizedString = Normalizer.normalize(critere, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
			try {
				//TODO Le programme va surement fonctionner, qu'en est-il des performances
				// Je pense qu'on peut éviter la 2em boucle couteuse en perf.
				salaries.stream().forEach(s -> {
					
					 //salariesFiltres.stream().forEach(sf -> {
						switch (Critere.valueOf(nfdNormalizedString.toUpperCase())) {
						case NOM:
						{
							if(!salariesFiltres.stream().map(sf -> sf.getNom()).anyMatch(sm -> sm.equals(s.getNom()))){
								salariesFiltres.add(s);
							}		
							break;
						}
						case PRENOM:
							if(!salariesFiltres.stream().map(sf -> sf.getPrenom()).anyMatch(sm -> sm.equals(s.getPrenom()))){
								salariesFiltres.add(s);
							}	
							break;
						case DATEENTREE:
							if(!salariesFiltres.stream().map(sf -> sf.getDateEntree()).anyMatch(sm -> sm.equals(s.getDateEntree()))){
								salariesFiltres.add(s);
							}		
							break;
						case DATENAISSANCE:
							if(!salariesFiltres.stream().map(sf -> sf.getDateNaissance()).anyMatch(sm -> sm.equals(s.getDateNaissance()))){
								salariesFiltres.add(s);
							}
							break;
						case ADRESSE:
							if(!salariesFiltres.stream().map(sf -> sf.getAdresse()).anyMatch(sm -> sm.equals(s.getAdresse()))){
								salariesFiltres.add(s);
							}						
							break;
							// TODO c'est dommage de renvoyer une exception pour les cas "Nom, Prénom, ADRESSE.
							default:throw new FunctionalException("le critère selectioné est incorrect");					
					 }	
				
				});
				}catch (IllegalArgumentException e) {
					throw new FunctionalException("le critère est erroné");
				}	
		}
		//TODO les exceptions sont bien gérés reste à savoir si la variable "critere" = null ou "";
		
		return salariesFiltres;
		
	}
}
