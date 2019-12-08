package com.tsconsult.salarietest.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tsconsult.salarietest.model.Salarie;
// Ce bout de code ressemble étrangement a celui de Mr Sadoud avec les même erreurs, alors qu'on peut le solutionner de plusieurs maniere ...
// Essaies de faire avec un SWITCH et des énumétations.
// Le throws Exception ne sert à rien ici.
// d'une manière général les exceptions sont très mal gérées.

@Service
public class SalarieServiceImpl implements SalarieService{
	Field field = null;
	boolean exists = false;
	
	@Override
	public List<Salarie> filtreSalaries(List<Salarie> salaries,String critere) throws Exception {
		
		List<Salarie> salariesFiltres = new ArrayList<>();
		field = Salarie.class.getDeclaredField(critere);
		field.setAccessible(true);
		salaries.stream().forEach(s -> {
			 exists= false;
			salariesFiltres.stream().forEach(sf -> {
				try {
					if(field.get(s).equals(field.get(sf))) {
						exists = true;
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			if(!exists) {
				salariesFiltres.add(s);
			}
		});
		return salariesFiltres;
		
	}
}
